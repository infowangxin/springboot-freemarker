package cn.springboot.config.authority.filter;

import cn.springboot.config.authority.service.xss.XSSSecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author 胡桃夹子
 * @Description 防止SQL注入
 * @date Mar 24, 2017 7:42:29 PM
 */
@WebFilter(urlPatterns = "/*", filterName = "SQLInjection", initParams = {@WebInitParam(name = "regularExpression", value = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|" + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)")})
public class SQLInjectionFilterServlet implements Filter {

    private static final Logger log = LoggerFactory.getLogger(SQLInjectionFilterServlet.class);

    private String regularExpression;

    public SQLInjectionFilterServlet() {
        log.debug("# init ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        regularExpression = filterConfig.getInitParameter("regularExpression");
        log.info("######### regularExpression={}", regularExpression);
    }

    /**
     * 如果需要输入“'”、“;”、“--”这些字符 可以考虑将这些字符转义为html转义字符 “'”转义字符为：&#39; “;”转义字符为：&#59;
     * “--”转义字符为：&#45;&#45;
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        // 获取剥离contextPath的url路径
        requestUrl = requestUrl.substring(requestUrl.indexOf(contextPath) + contextPath.length());

        Map parametersMap = request.getParameterMap();
        for (Object o : parametersMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            String[] value = (String[]) entry.getValue();
            for (String msg : value) {
                if (null != msg && msg.matches(regularExpression)) {
                    log.info("#疑似SQL注入攻击！参数名称：{}；录入信息:{}", entry.getKey(), msg);
                    request.setAttribute("err", "您输入的参数有非法字符，请输入正确的参数！");
                    request.setAttribute("pageUrl", req.getRequestURI());
                    request.getRequestDispatcher(request.getServletContext().getContextPath() + XSSSecurityConstants.FILTER_ERROR_PAGE).forward(request, response);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.debug("# destroy ");
    }

}
