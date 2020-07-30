package cn.tedu.straw.portal.controller;


import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.service.IUserService;
import cn.tedu.straw.portal.service.ex.*;
import cn.tedu.straw.portal.vo.R;
import cn.tedu.straw.portal.vo.TeacherVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-14
 */
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    // http://localhost:8080/api/v1/users/student/register?inviteCode=JSD2003-111111&nickname=Hello&phone=13800138002&password=1234
    @RequestMapping("/student/register")
    public R<Void> studentRegister(String inviteCode,
        @Validated User user, BindingResult bindingResult) {
        if (inviteCode == null || inviteCode.length() < 4 || inviteCode.length() > 20) {
            throw new ParameterValidationException("邀请码必须是4~20个字符！");
        }
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult
                    .getFieldError().getDefaultMessage();
            log.debug("validation has error : {}", errorMessage);
            throw new ParameterValidationException(errorMessage);
        }

        userService.registerStudent(user, inviteCode);
        return R.ok();
    }

    // http://localhost:8080/api/v1/users/teacher/list
    @GetMapping("/teacher/list")
    public R<List<TeacherVO>> getTeachers() {
        return R.ok(userService.findTeachers());
    }

}
