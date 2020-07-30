package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.vo.QuestionListItemVO;
import cn.tedu.straw.portal.vo.QuestionVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class QuestionMapperTests {

    @Autowired
    QuestionMapper mapper;

    @Test
    void findById() {
        Integer id = 5;
        QuestionVO questionVO = mapper.findById(id);
        log.debug("question >>> {}", questionVO);
    }

    @Test
    void findMostHits() {
        List<QuestionListItemVO> questions
                = mapper.findMostHits();
        log.debug("question count={}", questions.size());
        for (QuestionListItemVO question : questions) {
            log.debug(">>> {}", question);
        }
    }

    @Test
    void findStudentQuestions() {
        Integer userId = 9;
        List<QuestionVO> questions = mapper.findStudentQuestions(userId);
        log.debug("question count={}", questions.size());
        for (QuestionVO question : questions) {
            log.debug(">>> {}", question);
        }
    }

    @Test
    void findTeacherQuestions() {
        Integer teacherId = 3;
        List<QuestionVO> questions = mapper.findTeacherQuestions(teacherId);
        log.debug("question count={}", questions.size());
        for (QuestionVO question : questions) {
            log.debug(">>> {}", question);
        }
    }

}
