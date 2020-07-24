package com.honeypeng.event;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

/**
 * 自定义的事件广播器
 * Created by PengWX on 2020/7/23.
 */
@Component
public class CustomizeEventPublisher implements ApplicationEventPublisherAware , ApplicationContextAware {

    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        System.out.println("spring的事件广播器" + applicationEventPublisher);
    }
    /**
     * 发送一条广播
     */
    public void publishEvent(){
        applicationEventPublisher.publishEvent(new CustomizeEvent(applicationContext));
        System.out.println("自定义事件广播器已经广播消息出去了.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
