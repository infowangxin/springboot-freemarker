package cn.springboot.web.controller;

import cn.springboot.framework.datasource.PageInfo;
import cn.springboot.model.simple.News;
import cn.springboot.service.simple.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡桃夹子
 * @Description 新闻示例
 * @date Mar 16, 2017 3:58:01 PM
 */
@Controller
public class NewsController {

    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    /**
     * 表单提交日期绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * @return
     * @Description 进入新增页面
     */
    @GetMapping("/news/add")
    public String add() {
        log.info("# 进入发布新闻页面");
        return "view/news/add";
    }

    /**
     * ajax保存发布新闻
     *
     * @param news 新闻实体
     * @return 处理结果
     */
    @PostMapping("/news/add")
    @ResponseBody
    public Map<String, String> add(@ModelAttribute("newsForm") News news) {
        boolean flag = newsService.addNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    /**
     * @return
     * @Description ajax加载新闻对象
     * @author 胡桃夹子
     */
    @GetMapping("/news/load/{id}")
    public String load(@PathVariable String id, ModelMap map) {
        log.info("# ajax加载新闻对象");
        News news = newsService.findNewsById(id);
        map.addAttribute("news", news);
        return "view/news/edit_form";
    }

    /**
     * @param news
     * @return
     * @Description ajax保存更新重新发布新闻
     * @author 胡桃夹子
     */
    @PostMapping("/news/edit")
    @ResponseBody
    public Map<String, String> edit(@ModelAttribute("newsForm") News news) {
        boolean flag = newsService.editNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @GetMapping("/news/list")
    public String list(ModelMap map) {
        PageInfo<News> page = newsService.findNewsByPage(null, null);
        map.put("page", page);
        return "view/news/list";
    }

    @PostMapping("/news/list_page")
    public String list_page(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询新闻 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = newsService.findNewsByPage(pageNum, keywords);
        map.put("page", page);
        map.put("keywords", keywords);
        return "view/news/list_page";
    }

    @GetMapping("/news/list1")
    public String list1(ModelMap map) {
        log.info("#分页查询数据库1");
        PageInfo<News> page = newsService.findNewsByPage1(null, null);
        map.put("page", page);
        return "view/news/list1";
    }

    @PostMapping("/news/list_page1")
    public String list_page1(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询数据库2 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = newsService.findNewsByPage1(pageNum, keywords);
        map.put("page", page);
        map.put("keywords", keywords);
        return "view/news/list_page1";
    }

    @GetMapping("/news/list2")
    public String list2(ModelMap map) {
        log.info("#分页查询数据库2");
        PageInfo<News> page = newsService.findNewsByPage2(null, null);
        map.put("page", page);
        return "view/news/list2";
    }

    @PostMapping("/news/list_page2")
    public String list_page2(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询数据库2 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = newsService.findNewsByPage2(pageNum, keywords);
        map.put("page", page);
        map.put("keywords", keywords);
        return "view/news/list_page2";
    }

}
