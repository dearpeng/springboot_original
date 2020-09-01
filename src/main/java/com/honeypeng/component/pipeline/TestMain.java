package com.honeypeng.component.pipeline;

import com.honeypeng.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by PengWX on 2019/4/11.
 */
public class TestMain {
    public static void main(String[] args) {
       /* String handling="aabb1122zzyy";
        StandardPipeline pipeline = new StandardPipeline();
        BasicValve basicValve = new BasicValve();
        SecondValve secondValve = new SecondValve();
        ThirdValve thirdValve = new ThirdValve();
        FouthValve fouthValve = new FouthValve();
        pipeline.setBasic(basicValve);
        pipeline.addValve(secondValve);
        pipeline.addValve(thirdValve);
        pipeline.addValve(fouthValve);
        pipeline.getFirst().invoke(handling);*/

        Employee employee = new Employee();
        employee.setEmail("1234324");
        Class<Employee> employeeClass = Employee.class;
        try {
            Constructor constructors = employeeClass.getConstructor();
            Method getEmail = employeeClass.getMethod("getEmail", null);
            String invoke = (String)getEmail.invoke(constructors.newInstance(), null);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}