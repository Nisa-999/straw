package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.dto.QuestionDTO;
import cn.tedu.straw.portal.model.Question;
import cn.tedu.straw.portal.vo.QuestionListItemVO;
import cn.tedu.straw.portal.vo.QuestionVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-22
 */
public interface IQuestionService extends IService<Question> {

    /**
     * 发布问题
     *
     * @param questionDTO  从客户端提交过来的数据
     * @param userId       当前登录的用户id
     * @param userNickname 用户登录的用户昵称
     */
    void create(QuestionDTO questionDTO, Integer userId, String userNickname);

    /**
     * 根据提问的id查找问题详情
     *
     * @param id 问题的id
     * @return 匹配的问题的详情
     */
    QuestionVO getQuestionById(Integer id);

    /**
     * 查询点击数量最多的问题的列表，将从缓存中获取列表，如果缓存中没有数据，会从数据库中查询数据并更新缓存
     *
     * @return 点击数量最多的问题的列表
     */
    List<QuestionListItemVO> getMostHits();

    /**
     * 查询点击数量最多的问题的缓存列表，当缓存被清空后，可能获取到空的列表
     *
     * @return 点击数量最多的问题的缓存列表
     */
    List<QuestionListItemVO> getCachedMostHits();

    /**
     * 获取某用户某页的问题列表
     *
     * @param userId 用户的id
     * @param type   用户的账号类型，即“学生”或“老师”
     * @param page   页码
     * @return 匹配的问题列表
     */
    PageInfo<QuestionVO> getQuestionsByUserId(Integer userId, Integer type, Integer page);

}
