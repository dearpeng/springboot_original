package com.honeypeng.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jx on 2018/11/18.
 */
@Configuration
public class MyConfigurerAdapter extends WebMvcConfigurerAdapter {
    /* *
     * 将login请求隐射到index页面
     * @author pengWX
     * @date 2018/11/19 17:59
     * @param @param registry:
     * @return void
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("index");
    }
}
