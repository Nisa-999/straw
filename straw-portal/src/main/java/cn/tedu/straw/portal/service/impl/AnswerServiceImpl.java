package cn.tedu.straw.portal.service.impl;

import cn.tedu.straw.portal.dto.AnswerDTO;
import cn.tedu.straw.portal.model.Answer;
import cn.tedu.straw.portal.mapper.AnswerMapper;
import cn.tedu.straw.portal.service.IAnswerService;
import cn.tedu.straw.portal.service.ex.InsertException;
import cn.tedu.straw.portal.vo.AnswerVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-28
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Answer post(AnswerDTO answerDTO, Integer userId, String userNickName) {
        // 创建Answer对象
        Answer answer = new Answer();
        // 补全answer对象的属性值：content			<<< 参数answerDTO中的content
        answer.setContent(answerDTO.getContent());
        // 补全answer对象的属性值：count_of_likes	<<< 0
        answer.setCountOfLikes(0);
        // 补全answer对象的属性值：user_id			<<< 参数userId
        answer.setUserId(userId);
        // 补全answer对象的属性值：user_nick_name	<<< 参数userNickName
        answer.setUserNickName(userNickName);
        // 补全answer对象的属性值：question_id		<<< 参数answerDTO中的questionId
        answer.setQuestionId(answerDTO.getQuestionId());
        // 补全answer对象的属性值：created_time		<<< 当前时间
        answer.setCreatedTime(LocalDateTime.now());
        // 补全answer对象的属性值：status_of_accept	<<< 0
        answer.setStatusOfAccept(0);
        // 调用int answerMapper.insert(Answer answer)方法插入“回复”的数据，并获取返回结果
        int rows = answerMapper.insert(answer);
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出InsertException
            throw new InsertException("回复问题失败！服务器忙，请稍后再次尝试！");
        }
        // 返回
        return answer;
    }

    @Override
    public List<AnswerVO> getListByQuestionId(Integer questionId) {
        return answerMapper.findListByQuestionId(questionId);
    }

}
