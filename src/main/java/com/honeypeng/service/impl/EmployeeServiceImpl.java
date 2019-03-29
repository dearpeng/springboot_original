package com.honeypeng.service.impl;


import com.honeypeng.entity.Employee;
import com.honeypeng.entity.EmployeeExample;
import com.honeypeng.mapper.EmployeeMapper;
import com.honeypeng.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PengWX on 2018/12/24.
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Integer saveEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public Employee selectEmployee(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        return employeeMapper.selectByExample(new EmployeeExample());
    }

    @Override
    public Integer deleteById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public List<Employee> selectByExample(EmployeeExample example) {
        return employeeMapper.selectByExample(example);
    }
}
