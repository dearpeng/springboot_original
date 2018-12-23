package com.honeypeng.controller;

import com.honeypeng.dao.DepartmentDao;
import com.honeypeng.dao.EmployeeDao;
import com.honeypeng.entity.Department;
import com.honeypeng.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    /**
     * 获取员工列表
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String getAllEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "list";
    }

    /**
     * 获取部门
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "add";
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //重定向到emps请求  /:表示当前地址
        return "redirect:/emps";
    }

    /**
     * 获取单个员工
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String getEmp(@PathVariable("id") Integer id,Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "/add";
    }
}
