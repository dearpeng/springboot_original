package com.honeypeng.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jx on 2018/9/16.
 */
@ConfigurationProperties(prefix = "person")  //配置文件配置类注解
@PropertySource(value = {"classpath:person.properties"})
@Component  //加入到spring容器才能生效
//@Validated
public class Person {

//    @Value("${person.name}")
//    @Email
//@NotNull
    private String name;

//    @Value("#{11*3}")
    private Integer age;

//    @Value("false")
    private Boolean boss;

    private Date birth;

    private Map<String, Object> map;

//    @NotNull
//    @Valid
    private Dog dog;

    private List list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", map=" + map + ", dog=" + dog + ", list=" + list + '}';
    }
}
