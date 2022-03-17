package cn.springboot.model.auth;

import cn.springboot.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色与菜单关系对象
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:14
 */
@TableName("t_sys_role_permission")
public class RolePermission implements BaseEntity<String> {

    private static final long serialVersionUID = -7948507636703811294L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 菜单表主键
     */
    @TableField("permission_id")
    private String permissionId;

    /**
     * 角色表主键
     */
    @TableField("role_id")
    private String roleId;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

}
