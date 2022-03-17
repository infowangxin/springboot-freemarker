package cn.springboot.model.auth;

import cn.springboot.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 用户与角色关系对象
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:11
 */
@TableName("t_sys_user_role")
public class UserRole implements BaseEntity<String> {

    private static final long serialVersionUID = -56720255622342923L;


    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 角色表主键
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 用户表主键
     */
    @TableField("user_id")
    private String userId;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
