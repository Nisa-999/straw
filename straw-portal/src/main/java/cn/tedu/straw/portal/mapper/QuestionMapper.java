package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.Question;
import cn.tedu.straw.portal.vo.QuestionListItemVO;
import cn.tedu.straw.portal.vo.QuestionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-22
 */
@Repository
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 根据问题id查询问题详情
     *
     * @param id 问题的id
     * @return 匹配的问题详情，如果没有匹配的数据，则返回null
     */
    QuestionVO findById(Integer id);

    /**
     * 查询点击量最多的问题的列表
     *
     * @return 点击量最多的问题的列表
     */
    List<QuestionListItemVO> findMostHits();

    /**
     * 查询某学生的问题列表
     *
     * @param studentId 学生的id
     * @return 该学生发表的问题列表
     */
    List<QuestionVO> findStudentQuestions(Integer studentId);

    /**
     * 查询老师的问题列表
     *
     * @param teacherId 老师的id
     * @return 老师发表的问题和希望该老师回复的问题的列表
     */
    List<QuestionVO> findTeacherQuestions(Integer teacherId);

}
