package com.honeypeng.service;

import com.honeypeng.entity.Employee;
import org.springframework.stereotype.Service;

/**
 * Created by PengWX on 2018/12/24.
 */
public interface IEmployeeService {

    Integer saveEmployee(Employee employee);

    Employee selectEmployee(Integer id);
}
