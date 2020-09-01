package com.honeypeng.service.impl;

import com.honeypeng.entity.Department;
import com.honeypeng.entity.DepartmentExample;
import com.honeypeng.mapper.DepartmentMapper;
import com.honeypeng.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PengWX on 2018/12/24.
 */
@Service(value = "departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartmentList() {
        return departmentMapper.selectByExample(new DepartmentExample());
    }
}
