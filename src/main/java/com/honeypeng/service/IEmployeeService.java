package com.honeypeng.service;

import com.honeypeng.entity.Employee;
import com.honeypeng.entity.EmployeeExample;

import java.util.List;

/**
 * Created by PengWX on 2018/12/24.
 */
public interface IEmployeeService {

    Integer saveEmployee(Employee employee);

    Employee selectEmployee(Integer id);

    List<Employee> getAllEmployeeList();

    Integer deleteById(Integer id);

    Integer updateEmployee(Employee employee);

    List<Employee> selectByExample(EmployeeExample example);

    /**
     * 异步线程池测试
     */
    void asyncThreadPool();

}
