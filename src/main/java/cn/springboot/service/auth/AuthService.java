package cn.springboot.service.auth;

import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.User;

import java.util.List;

/**
 * 组装权限接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:09
 */
public interface AuthService {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return user 用户
     */
    User findUserByName(String username);

    /**
     * 根据角色编码查询角色
     *
     * @param roleCode 角色编码
     * @return 角色对象
     */
    Role findRoleByRoleCode(String roleCode);

    /**
     * 根据角色编码查询用户
     *
     * @param roleCode 角色编码
     * @return user 用户
     */
    List<User> findUserByRoleCode(String roleCode);

}
