package com.honeypeng.Listener;

import javax.servlet.*;

/**
 * Created by jx on 2019/11/23.
 */
public class MyListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("listener start...");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener stop");

    }
}
