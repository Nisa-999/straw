package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.vo.AnswerVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AnswerMapperTests {

    @Autowired
    AnswerMapper mapper;

    @Test
    void findListByQuestionId() {
        Integer questionId = 16;
        List<AnswerVO> answers = mapper.findListByQuestionId(questionId);
        for (AnswerVO answer : answers) {
            log.debug("AnswerVO >>> {}", answer);
        }
    }

}
