package cn.tedu.straw.portal.controller;


import cn.tedu.straw.portal.dto.CommentDTO;
import cn.tedu.straw.portal.model.Comment;
import cn.tedu.straw.portal.security.UserInfo;
import cn.tedu.straw.portal.service.ICommentService;
import cn.tedu.straw.portal.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-29
 */
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    // http://localhost:8080/api/v1/comments/post?answerId=4&content=Comment---2
    @RequestMapping("/post")
    public R<Comment> post(CommentDTO commentDTO,
        @AuthenticationPrincipal UserInfo userInfo) {
        Comment comment = commentService.post(commentDTO, userInfo.getId(), userInfo.getNickname());
        return R.ok(comment);
    }

}
