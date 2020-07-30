package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.dto.QuestionDTO;
import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.service.ex.ServiceException;
import cn.tedu.straw.portal.vo.QuestionListItemVO;
import cn.tedu.straw.portal.vo.QuestionVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class QuestionServiceTests {

    @Autowired
    IQuestionService service;

    @Test
    void create() {
        try {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setTitle("SpringSecurity验证时记录了用户的ID吗？");
            questionDTO.setContent("SpringSecurity自动完成验证，可以获取用户名，但是，用户ID在哪里获取？");
            questionDTO.setTagIds(new Integer[] { 5, 8, 13 });
            questionDTO.setTeacherIds(new Integer[] { 2, 3 });
            Integer userId = 5;
            String userNickname = "超级码农";
            service.create(questionDTO, userId, userNickname);
            log.debug("create question ok.");
        } catch (ServiceException e) {
            log.debug("create question failure.", e);
        }
    }

    @Test
    void getQuestionById() {
        Integer id = 6;
        QuestionVO questionVO = service.getQuestionById(id);
        log.debug("question >>> {}", questionVO);
    }

    @Test
    void getMostHits() {
        List<QuestionListItemVO> questions = service.getMostHits();
        log.debug("question count={}", questions.size());
        for (QuestionListItemVO question : questions) {
            log.debug(">>> {}", question);
        }
    }

    @Test
    void getQuestionsByUserId() {
        Integer userId = 3;
        Integer type = User.TYPE_TEACHER;
        Integer page = 0;
        PageInfo<QuestionVO> pageInfo = service.getQuestionsByUserId(userId, type, page);
        log.debug("page info >>> {}", pageInfo);
    }

}
