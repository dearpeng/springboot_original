package com.honeypeng.component;

import com.honeypeng.annotation.UnAuthRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by xj on 2018/11/29.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        /*HandlerMethod handlerMethod = (HandlerMethod) handler;
//        handlerMethod.getMethodAnnotation(UnAuthRequest.class);
        Method method = handlerMethod.getMethod();
        UnAuthRequest annotation = method.getAnnotation(UnAuthRequest.class);
        if (Objects.nonNull(annotation)) {
            return true;
        }*/
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username) || !Objects.equals("123456",username)) {
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
