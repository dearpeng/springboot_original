package com.honeypeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 因为不是web项目,所以没有了webapp目录下面的web.xml,那么我们之前在web.xml里面注册的servlet就没地方写了
 * 写好自定义servlet然后现在使用ServletRegistrationBean注册
 * Created by xj on 2019/8/11.
 * 标准的自定义的servlet
 */
public class MyServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("自定义servlet");
    }
}
