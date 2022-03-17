package cn.springboot.model.auth;

import cn.springboot.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 角色对象
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:12
 */
@TableName("t_sys_role")
public class Role implements BaseEntity<String> {

    private static final long serialVersionUID = -6982490361440305761L;


    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 角色名
     */
    @TableField("name")
    private String name;

    /**
     * 角色编码
     */
    @TableField("code")
    private String code;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
