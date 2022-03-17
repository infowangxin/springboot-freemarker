package cn.springboot.service.auth;

import cn.springboot.model.auth.Role;

import java.util.List;

/**
 * 角色相关接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:17
 */
public interface RoleService {

    /**
     * 添加一个角色 ，若已经存在同名角色，则不创建
     *
     * @param role 角色对象
     */
    void addRole(Role role);

    /**
     * 根据编码查询角色
     *
     * @param code 角色编码
     * @return
     */
    Role findRoleByCode(String code);

    /**
     * 根据用户查询对应所有角色
     *
     * @param userId 用户Id
     * @return roles 所有角色
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 给角色授权
     *
     * @param roleCode      角色编码
     * @param permissionKey 授权对应的KEY
     */
    void addRolePermission(String roleCode, String permissionKey);

}
