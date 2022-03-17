package cn.springboot;

import cn.springboot.model.auth.Permission;
import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.User;
import cn.springboot.service.auth.PermissionService;
import cn.springboot.service.auth.RoleService;
import cn.springboot.service.auth.UserService;
import cn.springboot.web.shiro.vo.PermissionEnumUtil;
import cn.springboot.web.shiro.vo.RoleEnumUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class InitServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 创建角色
     */
    private void addRoles() {
        try {
            roleService.addRole(RoleEnumUtil.ADMIN_ROLE.getRole());
            roleService.addRole(RoleEnumUtil.COMMON_ROLE.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建菜单
     */
    private void addPermission() {
        try {
            List<Permission> permis = PermissionEnumUtil.getPermissions();
            for (Permission permission : permis) {
                permissionService.addPermission(permission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建用户
     */
    private void addUsers() {
        try {
            Role adminRole = roleService.findRoleByCode(RoleEnumUtil.ADMIN_ROLE.getRoleCode());
            Role commonRole = roleService.findRoleByCode(RoleEnumUtil.COMMON_ROLE.getRoleCode());

            String password = "123456";

            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("infowangxin@163.com");
            admin.setTrueName("管理员");
            admin.setPassword(password);
            admin.setOrganizeId(adminRole.getId());
            userService.addUser(admin, adminRole);

            User nutcracker = new User();
            nutcracker.setUsername("nutcracker");
            nutcracker.setTrueName("胡桃夹子");
            nutcracker.setEmail("infowangxin@139.com");
            nutcracker.setPassword(password);
            nutcracker.setOrganizeId(commonRole.getId());
            userService.addUser(nutcracker, commonRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 给角色授权
    private void bindRolePermission() {
        try {
            Role adminRole = roleService.findRoleByCode(RoleEnumUtil.ADMIN_ROLE.getRoleCode());
            Role commonRole = roleService.findRoleByCode(RoleEnumUtil.COMMON_ROLE.getRoleCode());

            List<Permission> permissionList = PermissionEnumUtil.getPermissions();
            for (Permission permission : permissionList) {
                roleService.addRolePermission(adminRole.getCode(), permission.getSkey());
                roleService.addRolePermission(commonRole.getCode(), permission.getSkey());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void importTestData() {
        try {
            addRoles();
            addPermission();
            addUsers();
            bindRolePermission();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
