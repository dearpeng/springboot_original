package com.honeypeng.service;

import com.honeypeng.entity.Employee;

import java.util.List;

/**
 * Created by PengWX on 2018/12/24.
 */
public interface IEmployeeService {

    Integer saveEmployee(Employee employee);

    Employee selectEmployee(Integer id);

    List<Employee> getAllEmployeeList();

    Integer deleteById(Integer id);
}
