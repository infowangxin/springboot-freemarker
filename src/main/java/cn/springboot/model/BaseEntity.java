package cn.springboot.model;

import java.io.Serializable;


/**
 * @param <E>
 * @author 胡桃夹子
 * @Description 实体基类
 * @date Mar 16, 2017 3:25:15 PM
 */
public interface BaseEntity<E extends Serializable> extends Serializable {

    /**
     * 主键
     *
     * @return 主键数据类型
     */
    E getId();

}
