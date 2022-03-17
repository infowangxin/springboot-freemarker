package cn.springboot.mapper.simple;

import cn.springboot.framework.datasource.PageInfo;
import cn.springboot.model.simple.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 新闻对象 Mapper
 * @author 胡桃夹子
 * @Description 新闻mapper接口
 * @date Mar 16, 2017 3:35:19 PM
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    List<News> findNewsByKeywords(@Param("keywords") String keywords);

    PageInfo<News> findNewsByPage(PageInfo<News> page, @Param("keywords") String keywords);

}
