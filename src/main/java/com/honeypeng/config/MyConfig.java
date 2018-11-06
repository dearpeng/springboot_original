package com.honeypeng.config;

import com.honeypeng.service.IHelloService;
import com.honeypeng.service.impl.HelloserviceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

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
}
