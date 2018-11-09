package com.lmeng.config;

import com.lmeng.beetl.BeetlConfiguration;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;

@Configuration
//@PropertySource({"classpath:beetl.properties"})
public class BeetlConfig {

    /**
     *  @remark beetl 配置初始化
     * @function beetlConfiguration
     */
    @Bean(name = "BeetlConfig")
    public BeetlConfiguration beetlConfiguration() {
        BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        try {
            // WebAppResourceLoader 配置root路径是关键
           WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(patternResolver.getResource("classpath:/").getFile().getPath());
            beetlConfiguration.setResourceLoader(webAppResourceLoader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取配置文件信息
        beetlConfiguration.setConfigFileResource(patternResolver.getResource("classpath:beetl.properties"));
        beetlConfiguration.init();
        return beetlConfiguration;
    }

    /**
     *  @remark beetl 视图解析
     * @function getBeetlSpringViewResolver
     */
    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(
            @Qualifier("BeetlConfig") BeetlConfiguration beetlConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setPrefix("/templates/");
        //beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlConfiguration);
        return beetlSpringViewResolver;
    }
}
