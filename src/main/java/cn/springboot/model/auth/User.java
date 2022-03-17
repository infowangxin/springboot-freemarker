package cn.springboot.model.auth;

import cn.springboot.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 用户对象
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:13
 */
@TableName("t_sys_user")
public class User implements BaseEntity<String> {

    private static final long serialVersionUID = 1227495748732942139L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 登录账号
     */
    @TableField("username")
    private String username;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * salt
     */
    @TableField("salt")
    private String salt;

    /**
     * 真实姓名
     */
    @TableField("true_name")
    private String trueName;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 部门ID
     */
    @TableField("organize_id")
    private String organizeId;

    /**
     * 状态：0=有效，1=无效
     */
    @TableField("status")
    private Integer status;

    /**
     * 上将登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("modify_time")
    private Date modifyTime;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeID) {
        this.organizeId = organizeID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
