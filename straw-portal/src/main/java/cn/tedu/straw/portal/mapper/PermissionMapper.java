package cn.tedu.straw.portal.mapper;

import cn.tedu.straw.portal.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2020-07-18
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询某用户的权限
     * @param userId 用户的id
     * @return 该用户的权限的列表
     */
    List<Permission> selectByUserId(Integer userId);

}
