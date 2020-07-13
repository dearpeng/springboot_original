package com.honeypeng.factory;

import com.honeypeng.entity.Employee;
import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Employee> {
    //获取到某个bean
    @Override
    public Employee getObject() throws Exception {
        return new Employee();
    }

    //获取到bean类型
    @Override
    public Class<?> getObjectType() {
        return Employee.class;
    }

    //是否单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
