package com.honeypeng.config;

import com.honeypeng.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by PengWX on 2019/11/21.
 */
@Configuration
public class MyServletConfig {
    /**
     * 嵌入式的servlet容器,修改servlet设置
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            //通过代码的方式配置servlet容器的相关参数,代替server.port等配置文件的方式配置容器参数
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8111);
            }
        };
    }

    /**
     * 之前springmvc的时候,三大组件(servlet,listener,filter)都是注册在web.xml文件中,现在使用ServletRegistrationBeam来注册
     * @return
     */
    @Bean
    public ServletRegistrationBean myServletRegistionBean(){
        return new ServletRegistrationBean(new MyServlet(), "/myServlet");
    }
}
