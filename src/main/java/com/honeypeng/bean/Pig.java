package com.honeypeng.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jx on 2018/9/16.
 */
@Component
public class Pig implements InitializingBean, DisposableBean, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
    private String name;

    private Integer Age;


//    @Autowired
    private Dog dog;

//    @Autowired
    public Pig( @Autowired Dog dog){
        this.dog = dog;
        System.out.println("pig的有参构造器");
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    /*public Pig(){
        System.out.println(this.getClass().getName()+"  Constructor ");
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    private void init() {
        System.out.println(this.getClass().getName() + "  +++++init()...");
    }

    private void destory() {
        System.out.println(this.getClass().getName() + "  +++++自定义的destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + " +++++afterPropertiesSet....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass() + " +++++ DisposableBean.destroy...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getName()+"  +++++postConstruct");
    }
    @PreDestroy
    public void preDestory() {
        System.out.println(this.getClass().getName()+"  +++++preDestory");
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                ", dog=" + dog +
                '}';
    }
}
