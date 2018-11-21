package com.honeypeng.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PengWX on 2018/11/21.
 */
public class ListenerTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 在整个web应用销毁之前调用，将所有应用空间所设置的内容清空
        servletContext.removeAttribute("hashMap");
        System.out.println("销毁工作完成...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // 通过这个事件可以获取整个应用的空间
        // 在整个web应用下面启动的时候做一些初始化的内容添加工作
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 设置一些基本的内容；比如一些参数或者是一些固定的对象
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("driverClassName", "com.jdbc.Driver");
        hashMap.put("username", "root");
        hashMap.put("password", "root");
        servletContext.setAttribute("hashMap", hashMap);
        System.out.println("应用监听器初始化工作完成...");
        System.out.println("已经创建DataSource...");
    }
}
