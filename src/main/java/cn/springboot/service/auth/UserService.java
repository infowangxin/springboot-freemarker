package cn.springboot.service.auth;

import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.User;

import java.util.List;

/**
 * 用户相关接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:18
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param user 用户
     * @param role 角色
     */
    void addUser(User user, Role role);

    /**
     * 修改密码
     *
     * @param user 当前用户
     */
    void updatePassword(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return user 用户
     */
    User findUserByName(String username);

    /**
     * 更新用户登录时间
     *
     * @param user 用户
     */
    void updateUserLastLoginTime(User user);

    /**
     * 查询组织下所有客服员工
     *
     * @return
     */
    List<User> findUsers();

    /**
     * 根据条件（组织、名称）查询用户
     *
     * @param shopId  组织ID
     * @param empName 用户名称
     * @return
     */
    List<User> findEmp(String shopId, String empName);

}
