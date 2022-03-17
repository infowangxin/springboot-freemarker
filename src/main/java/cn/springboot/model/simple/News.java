package cn.springboot.model.simple;

import cn.springboot.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;


/**
 * 新闻对象
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:10
 */
@TableName("t_news")
public class News implements BaseEntity<String> {

    private static final long serialVersionUID = 3624947930970250778L;

    @TableId("id")
    private String id;

    /**
     * 新闻标题
     */
    @TableField("title")
    private String title;

    /**
     * 新闻内容
     */
    @TableField("description")
    private String description;

    /**
     * 新闻发生地址
     */
    @TableField("address")
    private String address;

    /**
     * 新闻发生时间
     */
    @TableField("news_time")
    private Date newsTime;

    /**
     * 新闻发布时间
     */
    @TableField("create_time")
    private Date createTime;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
