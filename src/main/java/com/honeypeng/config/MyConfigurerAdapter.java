package com.honeypeng.config;


import org.springframework.context.annotation.Bean;
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
        registry.addViewController("/index").setViewName("index");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用，所以自己定义一个adapter
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }
}
