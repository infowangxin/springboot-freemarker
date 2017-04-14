package cn.springboot.config.shiro.freemarker;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

@Configuration
@ConditionalOnNotWebApplication
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
    
   private static final Logger log = LoggerFactory.getLogger(ShiroTagFreeMarkerConfigurer.class);
 
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        log.info("# 激活shiro标签");
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
     
}