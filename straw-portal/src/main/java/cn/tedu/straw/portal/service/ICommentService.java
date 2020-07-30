package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.dto.CommentDTO;
import cn.tedu.straw.portal.model.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-29
 */
public interface ICommentService extends IService<Comment> {

    /**
     * 发表评论
     *
     * @param commentDTO   评论的数据
     * @param userId       当前登录的用户的id
     * @param userNickName 当前登录的用户的昵称
     * @return 成功发表的评论数据
     */
    Comment post(CommentDTO commentDTO, Integer userId, String userNickName);

}
