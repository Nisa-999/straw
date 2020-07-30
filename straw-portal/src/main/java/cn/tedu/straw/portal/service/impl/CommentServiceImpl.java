package cn.tedu.straw.portal.service.impl;

import cn.tedu.straw.portal.dto.CommentDTO;
import cn.tedu.straw.portal.model.Comment;
import cn.tedu.straw.portal.mapper.CommentMapper;
import cn.tedu.straw.portal.service.ICommentService;
import cn.tedu.straw.portal.service.ex.InsertException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-29
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment post(CommentDTO commentDTO, Integer userId, String userNickName) {
        // 创建Comment对象
        // 向Comment对象中封装数据：user_id			>>> 参数userId
        // 向Comment对象中封装数据：user_nick_name	    >>> 参数userNickName
        // 向Comment对象中封装数据：answer_id		    >>> commentDTO
        // 向Comment对象中封装数据：content			>>> commentDTO
        // 向Comment对象中封装数据：created_time		>>> 创建当前时间对象
        Comment comment = new Comment()
                .setUserId(userId)
                .setUserNickName(userNickName)
                .setAnswerId(commentDTO.getAnswerId())
                .setContent(commentDTO.getContent())
                .setCreatedTime(LocalDateTime.now());
        // 调用int commentMapper.insert(Comment comment)方法插入评论数据，获取返回的受影响行数
        int rows = commentMapper.insert(comment);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出InsertException
            throw new InsertException("发表评论失败！服务器忙，请稍后再次尝试！");
        }
        // 返回Comment对象
        return comment;
    }
}
