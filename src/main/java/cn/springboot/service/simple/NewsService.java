package cn.springboot.service.simple;

import cn.springboot.framework.datasource.PageInfo;
import cn.springboot.model.simple.News;

import java.util.List;

/**
 * @author 胡桃夹子
 * @Description 新闻接口类
 * @date Mar 16, 2017 5:19:14 PM
 */
public interface NewsService {

    boolean addNews(News news);

    boolean editNews(News news);

    News findNewsById(String newsId);

    List<News> findNewsByKeywords(String keywords);

    PageInfo<News> findNewsByPage(Integer pageNum, String keywords);

    PageInfo<News> findNewsByPage1(Integer pageNum, String keywords);

    PageInfo<News> findNewsByPage2(Integer pageNum, String keywords);

}
