package cn.springboot.service.simple.impl;

import cn.springboot.framework.constant.Constants;
import cn.springboot.framework.datasource.DataSourceTagger;
import cn.springboot.framework.datasource.PageInfo;
import cn.springboot.framework.exception.BusinessException;
import cn.springboot.framework.pk.FactoryAboutKey;
import cn.springboot.framework.pk.TableEnum;
import cn.springboot.mapper.simple.NewsMapper;
import cn.springboot.model.simple.News;
import cn.springboot.service.simple.NewsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * @author 胡桃夹子
 * @Description 新闻接口实现类
 * @date Mar 16, 2017 5:19:24 PM
 */
@Service
public class NewsServiceImpl implements NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsMapper newsMapper;

    //@DS(DataSourceTagger.DB2)
    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public boolean addNews(News news) {
        if (news != null) {
            news.setId(FactoryAboutKey.getPK(TableEnum.T_NEWS));
            news.setCreateTime(Calendar.getInstance().getTime());
            int flag = newsMapper.insert(news);
            if (StringUtils.equals(news.getTitle(), "a")) {
                throw new BusinessException("001", "测试事务回溯");
            }
            return flag == 1;
        } else {
            return false;
        }
    }

    @Override
    public boolean editNews(News news) {
        if (news != null && StringUtils.isNotBlank(news.getId())) {
            int flag = newsMapper.updateById(news);
            return flag == 1;
        } else {
            return false;
        }
    }

    @Override
    public News findNewsById(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        } else {
            return newsMapper.selectById(id);
        }
    }

    @Override
    public List<News> findNewsByKeywords(String keywords) {
        //默认数据库
        log.info("# 查询默认数据库");
        return newsMapper.findNewsByKeywords(keywords);
    }

    @DS(DataSourceTagger.DB1)
    @Override
    public PageInfo<News> findNewsByPage1(Integer pageNum, String keywords) {
        // 数据库1
        PageInfo<News> resultPage = findByPage(pageNum, keywords);
        log.info("# 数据库1 resultPage={}", resultPage);
        return resultPage;
    }


    @DS(DataSourceTagger.DB2)
    @Override
    public PageInfo<News> findNewsByPage2(Integer pageNum, String keywords) {
        // 数据库2
        PageInfo<News> resultPage = findByPage(pageNum, keywords);
        log.info("# 数据库2 resultPage={}", resultPage);
        return resultPage;
    }

    @Override
    public PageInfo<News> findNewsByPage(Integer pageNum, String keywords) {
        PageInfo<News> resultPage = findByPage(pageNum, keywords);
        log.info("# 默认数据库 resultPage={}", resultPage);
        return resultPage;
    }

    private PageInfo<News> findByPage(Integer pageNum, String keywords) {
        log.debug("# pageNum={},keywords={}", pageNum, keywords);
        if (pageNum == null) {
            pageNum = 1;
        }
        PageInfo<News> page = new PageInfo<>(pageNum, Constants.PAGE_SIZE);
        return newsMapper.findNewsByPage(page, keywords);
    }

}
