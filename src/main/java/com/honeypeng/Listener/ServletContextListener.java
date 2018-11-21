package com.honeypeng.Listener;

import javax.servlet.ServletContextEvent;
import java.util.EventListener;

/**
 * Created by PengWX on 2018/11/21.
 */
public abstract interface ServletContextListener extends EventListener{

    public abstract void contextInitialized(ServletContextEvent servletContextEvent);

    public abstract void contextDestroyed(ServletContextEvent servletContextEvent);

}
