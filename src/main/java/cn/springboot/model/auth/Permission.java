package cn.springboot.model.auth;

import cn.springboot.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 菜单对象
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:13
 */
@TableName("t_sys_permission")
public class Permission implements BaseEntity<String> {

    private static final long serialVersionUID = -7141829387338999544L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 菜单名
     */
    @TableField("name")
    private String name;

    /**
     * 菜单样式图标名
     */
    @TableField("css_class")
    private String cssClass;

    /**
     * 菜单相对URL
     */
    @TableField("url")
    private String url;

    /**
     * 菜单KEY
     */
    @TableField("skey")
    private String skey;

    /**
     * 父菜单KEY
     */
    @TableField("parent_key")
    private String parentKey;

    /**
     * 是否显示：1=有效，0=无效
     */
    @TableField("hide")
    private Integer hide;

    /**
     * 菜单级别，最多只能有3级
     */
    @TableField("lev")
    private Integer lev;

    /**
     * 菜单排序
     */
    @TableField("sort")
    private Integer sort;

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

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

}
