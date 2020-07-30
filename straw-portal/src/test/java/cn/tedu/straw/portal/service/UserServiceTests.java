package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.service.ex.ServiceException;
import cn.tedu.straw.portal.vo.TeacherVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserServiceTests {

    @Autowired
    IUserService userService;

    @Test
    void registerStudent() {
        try {
            User user = new User();
            user.setPhone("13800138006");
            user.setNickname("小吴同学");
            user.setPassword("123456");
            // 班级邀请码信息
            // JSD1912-876840  1
            // JSD2001-706246  0
            // JSD2002-525416  1
            // JSD2003-005803  1
            String inviteCode = "JSD2003-005803";
            userService.registerStudent(user, inviteCode);
            log.debug("register student > OK.");
        } catch (ServiceException e) {
            log.debug("register student > failure.");
            log.debug("cause : {}", e.getClass());
        }
    }

    @Test
    void login() {
        String username = "13700137001";
        UserDetails userDetails = userService.login(username);
        log.debug("login, user details={}", userDetails);
    }

    @Test
    void findTeachers() {
        List<TeacherVO> teachers = userService.findTeachers();
        log.debug("teacher count = {}", teachers.size());
        for (TeacherVO teacher : teachers) {
            log.debug(">>> {}", teacher);
        }
    }

}
