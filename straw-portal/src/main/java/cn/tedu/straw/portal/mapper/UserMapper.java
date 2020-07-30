package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.vo.TeacherVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-14
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询老师的列表
     *
     * @return 老师的列表
     */
    List<TeacherVO> findTeachers();

}
