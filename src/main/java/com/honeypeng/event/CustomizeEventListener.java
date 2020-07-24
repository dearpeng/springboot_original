package com.honeypeng.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * Created by PengWX on 2020/7/23.
 */
@Component
public class CustomizeEventListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("自定义监听器监听到事件"+  event.toString());
    }
}
