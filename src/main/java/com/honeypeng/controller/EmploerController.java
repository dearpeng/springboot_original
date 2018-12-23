package com.honeypeng.controller;

import com.honeypeng.dao.DepartmentDao;
import com.honeypeng.dao.EmployeeDao;
import com.honeypeng.entity.Department;
import com.honeypeng.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created by PengWX on 2018/12/7.
 */
@Controller
public class EmploerController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getAllEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "add";
    }
}
