package com.honeypeng.config;

import com.honeypeng.component.MyLocalResolver;
import com.honeypeng.service.IHelloService;
import com.honeypeng.service.impl.HelloserviceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;

import javax.jms.ConnectionFactory;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by 08754 on 2018/9/19.
 */
@Configuration
public class MyConfig {

    @Bean
    public IHelloService helloService(){
        HelloserviceImpl helloservice = new HelloserviceImpl();
        System.out.println("使用注解的方式加入配置");
        return helloservice;
    }

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    /**
     * 覆盖默认国际化设置
     * @author pengWX
     * @date 2018/11/27 17:25
     * @param @param :
     * @return org.springframework.web.servlet.LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    /***
     * 线程池
     * @return
     */
    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor  taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setKeepAliveSeconds(200);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
