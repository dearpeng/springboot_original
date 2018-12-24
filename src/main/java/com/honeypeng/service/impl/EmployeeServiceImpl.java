package com.honeypeng.service.impl;

import com.honeypeng.dao.EmployeeDao;
import com.honeypeng.entity.Employee;
import com.honeypeng.mapper.EmployeeMapper;
import com.honeypeng.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by PengWX on 2018/12/24.
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Integer saveEmployee(Employee employee) {
        return employeeMapper.saveEmployee(employee);
    }

    @Override
    public Employee selectEmployee(Integer id) {
        return employeeMapper.selectEmployee(id);
    }
}
