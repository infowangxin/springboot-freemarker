package cn.springboot.mapper.auth;

import cn.springboot.model.auth.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 菜单  Mapper
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:12
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询用户所能访问的所有菜单
     *
     * @param userId 用户
     * @return permissions 菜单
     */
    List<Permission> findPermissionByUserId(String userId);

    /**
     * 根据菜单KEY查询菜单
     *
     * @param permissionKey 菜单KEY
     * @return
     */
    Permission findPermissionByKey(String permissionKey);
}
