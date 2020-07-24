package com.honeypeng.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义的事件
 * Created by PengWX on 2020/7/23.
 */
public class CustomizeEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomizeEvent(Object source) {
        super(source);
    }
}
