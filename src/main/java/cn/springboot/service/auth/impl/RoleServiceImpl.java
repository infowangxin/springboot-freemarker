package cn.springboot.service.auth.impl;

import cn.springboot.framework.exception.BusinessException;
import cn.springboot.framework.pk.FactoryAboutKey;
import cn.springboot.framework.pk.TableEnum;
import cn.springboot.mapper.auth.PermissionMapper;
import cn.springboot.mapper.auth.RoleMapper;
import cn.springboot.mapper.auth.RolePermissionMapper;
import cn.springboot.model.auth.Permission;
import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.RolePermission;
import cn.springboot.service.auth.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色相关接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:17
 */
@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public void addRole(Role role) {
        if (role == null || StringUtils.isBlank(role.getName())) {
            return;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("## 添加角色 : {}", role.getName());
        }
        Role r = findRoleByCode(role.getCode());
        if (r == null) {
            role.setId(FactoryAboutKey.getPK(TableEnum.T_SYS_ROLE));
            roleMapper.insert(role);
        }
    }

    @Override
    public Role findRoleByCode(String code) {
        LOG.debug("## 根据编码查询角色 {}", code);
        return roleMapper.findRoleByCode(code);
    }

    @Override
    public List<Role> findRoleByUserId(String userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public void addRolePermission(String roleCode, String permissionKey) {
        Role role = findRoleByCode(roleCode);
        if (role == null) {
            throw new BusinessException("role-fail", "## 给角色授权失败， 角色编码错误");
        }
        Permission permis = permissionMapper.findPermissionByKey(permissionKey);
        if (permis == null) {
            throw new BusinessException("role-fail", "## 给角色授权失败， 菜单KEY不存在，key=" + permissionKey);
        }

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getId());
        rolePermission.setPermissionId(permis.getId());

        RolePermission rp = rolePermissionMapper.findRolePermission(rolePermission);
        if (rp == null) {
            rolePermission.setId(FactoryAboutKey.getPK(TableEnum.T_SYS_ROLE_PERMISSION));
            rolePermissionMapper.insert(rolePermission);
        }

    }
}
