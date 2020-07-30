package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.dto.CommentDTO;
import cn.tedu.straw.portal.model.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommentServiceTests {

    @Autowired
    ICommentService service;

    @Test
    void post() {
        CommentDTO commentDTO = new CommentDTO()
                .setAnswerId(4)
                .setContent("测试评论---1");
        Integer userId = 15;
        String userNickName = "机器猫";
        Comment comment = service.post(commentDTO, userId, userNickName);
        log.debug("OK, comment >>> {}", comment);
    }

}
