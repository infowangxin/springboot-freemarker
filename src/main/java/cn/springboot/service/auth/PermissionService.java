package cn.springboot.service.auth;

import cn.springboot.model.auth.Permission;
import cn.springboot.web.shiro.vo.PermissionVo;

import java.util.List;

public interface PermissionService {

    /**
     * 查询用户所能访问的所有菜单
     *
     * @param userId 用户ID
     * @return permissions 菜单
     */
    List<PermissionVo> getPermissions(String userId);

    /**
     * 添加 菜单
     *
     * @param permission 菜单项
     */
    void addPermission(Permission permission);
}
