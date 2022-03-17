package cn.springboot.web.controller;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping(value = {"/", "index"})
    public String home() {
        log.info("# 进入默认首页");
        return "index";
    }

    @GetMapping("leftnav")
    public String leftnav() {
        return "leftnav";
    }

    @GetMapping("topnav")
    public String topnav() {
        return "topnav";
    }

    @RequestMapping(value = "/error", method = {RequestMethod.POST, RequestMethod.GET})
    String error(HttpServletRequest request, ModelMap map) {
        Object err = request.getAttribute("err");
        if (err != null) {
            log.error("# err={}", err);
            map.put("err", err);
        }
        Object pageUrl = request.getAttribute("pageUrl");
        if (pageUrl != null) {
            log.error("# pageUrl={}", pageUrl);
            map.put("pageUrl", pageUrl);
        }
        Map<String, String[]> param = request.getParameterMap();
        if (MapUtils.isNotEmpty(param)) {
            for (Map.Entry<String, String[]> entry : param.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
                log.info("# error parameter.name=[{}],parameter.value=[{}]", entry.getKey(), entry.getValue());
            }
        }
        log.info("# 进入错误页面");
        return "common/error";
    }

}
