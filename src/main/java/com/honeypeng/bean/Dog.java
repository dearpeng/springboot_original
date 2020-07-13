package com.honeypeng.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by jx on 2018/9/16.
 */
public class Dog {

    private String name;

    private Integer Age;

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", Age=" + Age + '}';
    }

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

}
