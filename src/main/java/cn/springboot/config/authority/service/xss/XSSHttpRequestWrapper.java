package cn.springboot.config.authority.service.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author 胡桃夹子
 * @Description request信息封装类，用于判断、处理request请求中特殊字符
 * @date Mar 24, 2017 7:44:32 PM
 */
public class XSSHttpRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 封装http请求
     *
     * @param request HttpServletRequest
     */
    public XSSHttpRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {

        String value = super.getHeader(name);
        // 若开启特殊字符替换，对特殊字符进行替换
        if (XSSSecurityConfig.REPLACE) {
            value = XSSSecurityManager.securityReplace(value);
        }
        return value;
    }

    @Override
    public String getParameter(String name) {

        String value = super.getParameter(name);
        // 若开启特殊字符替换，对特殊字符进行替换
        if (XSSSecurityConfig.REPLACE) {
            value = XSSSecurityManager.securityReplace(value);
        }
        return value;
    }

    /**
     * 没有违规的数据，就返回false;
     *
     * @return true=校验通过，false=校验失败
     */
    private boolean checkHeader() {

        Enumeration<String> headerParams = this.getHeaderNames();
        while (headerParams.hasMoreElements()) {
            String headerName = headerParams.nextElement();
            String headerValue = this.getHeader(headerName);
            if (XSSSecurityManager.matches(headerValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 没有违规的数据，就返回false;
     *
     * @return true=校验通过，false=校验失败
     */
    @SuppressWarnings("rawtypes")
    private boolean checkParameter() {

        // 特殊url校验，不使用通用url正则校验
        if (XSSSecurityConfig.IS_CHECK_URL) {
            List<Map<String, Object>> checkUrlList = XSSSecurityManager.checkUrlMatcherList;
            for (Map matchMap : checkUrlList) {
                String requesturl = super.getRequestURL().toString();
                String matcherurl = matchMap.keySet().iterator().next().toString();
                //请求url匹配配置的特殊url
                if (requesturl.contains(matcherurl)) {
                    return this.matches(matchMap.get(matcherurl).toString());
                }
            }
        }

        // 通用url进行校验
        Map<String, String[]> submitParams = this.getParameterMap();
        Set<String> submitNames = submitParams.keySet();
        for (String submitName : submitNames) {
            String[] submitValues = submitParams.get(submitName);

            for (String submitValue : submitValues) {
                if (XSSSecurityManager.matches(submitValue)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 特殊url匹配请求参数中是否含特殊字符
     *
     * @param regex 正则
     * @return true=匹配成功，false=匹配失败
     */
    private boolean matches(String regex) {

        Pattern checkUrlPattern = Pattern.compile(regex);

        Map<String, String[]> submitParams = this.getParameterMap();
        Set<String> submitNames = submitParams.keySet();
        for (String submitName : submitNames) {
            String[] submitValues = submitParams.get(submitName);
            for (String submitValue : submitValues) {
                if (submitValue != null) {
                    if ("".equals(submitValue.trim()) || !checkUrlPattern.matcher(submitValue).matches()) {
                        continue;
                    }
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 没有违规的数据，就返回false;
     * 若存在违规数据，根据配置信息判断是否跳转到错误页面
     *
     * @param response HttpServletResponse
     * @return true=有违规数据，false=违规数据
     */
    public boolean validateParameter(HttpServletResponse response) {

        // 开始header校验，对header信息进行校验
        if (XSSSecurityConfig.IS_CHECK_HEADER) {
            if (this.checkHeader()) {
                return true;
            }
        }
        // 开始parameter校验，对parameter信息进行校验
        if (XSSSecurityConfig.IS_CHECK_PARAMETER) {
            return this.checkParameter();
        }

        return false;
    }

}
