package cn.tedu.straw.portal.controller;


import cn.tedu.straw.portal.dto.AnswerDTO;
import cn.tedu.straw.portal.model.Answer;
import cn.tedu.straw.portal.security.UserInfo;
import cn.tedu.straw.portal.service.IAnswerService;
import cn.tedu.straw.portal.service.ex.ParameterValidationException;
import cn.tedu.straw.portal.vo.AnswerVO;
import cn.tedu.straw.portal.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-28
 */
@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    @Autowired
    private IAnswerService answerService;

    // http://localhost:8080/api/v1/answers/post?questionId=1&content=666
    @RequestMapping("/post")
    public R<Answer> post(@Validated AnswerDTO answerDTO,
                          BindingResult bindingResult,
                          @AuthenticationPrincipal UserInfo userInfo) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new ParameterValidationException(message);
        }
        Answer answer = answerService.post(answerDTO, userInfo.getId(), userInfo.getNickname());
        return R.ok(answer);
    }

    // http://localhost:8080/api/v1/answers/question/16
    @GetMapping("/question/{questionId}")
    public R<List<AnswerVO>> getListByQuestionId(@PathVariable("questionId") Integer questionId) {
        return R.ok(answerService.getListByQuestionId(questionId));
    }

}
