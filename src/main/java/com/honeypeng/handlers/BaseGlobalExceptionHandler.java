package com.honeypeng.handlers;


import com.honeypeng.utils.WebUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理基类
 */


@ControllerAdvice
public class BaseGlobalExceptionHandler {

    @ExceptionHandler(value =  Exception.class)
    @ResponseBody
    public String handleUnAuthenticationException( Exception ex) {
        return WebUtil.getFailureJson("垃圾没提示");
    }
}
