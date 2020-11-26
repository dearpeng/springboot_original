package com.honeypeng.config.dataSourceConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by PengWX on 2020/11/26.
 */

@Aspect
@Component
public class MapperAnnotationAspect {

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(* com.honeypeng.mapper..*.*(..))")
    public void MapperAnnotationAspect() {
    }

    /**
     * @description 在连接点执行之前执行的通知
     */
    @Before("MapperAnnotationAspect()")
    public void doBeforeGame(JoinPoint pjp) {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        TargetDataSource methodAnnotation = AnnotationUtils.getAnnotation(targetMethod, TargetDataSource.class);
        if (methodAnnotation != null) {
            DataSourceHolder.setDataSource(methodAnnotation.name());
        }
    }

}
