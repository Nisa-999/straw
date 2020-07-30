package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.dto.AnswerDTO;
import cn.tedu.straw.portal.service.ex.ServiceException;
import cn.tedu.straw.portal.vo.AnswerVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AnswerServiceTests {

    @Autowired
    IAnswerService service;

    @Test
    void post() {
        try {
            AnswerDTO answerDTO = new AnswerDTO()
                    .setQuestionId(1)
                    .setContent("HAHAHA!!!");
            Integer userId = 2;
            String userNickName = "天下第一";
            service.post(answerDTO, userId, userNickName);
            log.debug("OK");
        } catch (ServiceException e) {
            log.debug("failure >>> ", e);
        }
    }

    @Test
    void getListByQuestionId() {
        Integer questionId = 16;
        List<AnswerVO> answers = service.getListByQuestionId(questionId);
        for (AnswerVO answer : answers) {
            log.debug("AnswerVO >>> {}", answer);
        }
    }

}
