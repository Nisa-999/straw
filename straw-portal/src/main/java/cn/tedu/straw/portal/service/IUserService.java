package cn.tedu.straw.portal.service;

import cn.tedu.straw.portal.model.User;
import cn.tedu.straw.portal.vo.TeacherVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-14
 */
public interface IUserService extends IService<User> {

    /**
     * 注册学生账号
     *
     * @param user       学生的基本信息
     * @param inviteCode 邀请码
     */
    void registerStudent(User user, String inviteCode);

    /**
     * 根据用户名获取用户详情，将应用于Spring-Security验证登录
     *
     * @param username 用户名
     * @return 匹配的用户详情，如果没有匹配的数据，则返回null
     */
    UserDetails login(String username);

    /**
     * 获取缓存的老师的列表，如果列表为空，还会尝试从数据库查询列表数据，避免因为缓存为空导致无法获取到数据
     *
     * @return 缓存的老师的列表
     */
    List<TeacherVO> findTeachers();

    /**
     * 获取缓存的老师的列表，由于存在清空缓存机制，获取到的数据将不可靠
     *
     * @return 缓存的老师的列表
     */
    List<TeacherVO> findCachedTeachers();

}
