package com.honeypeng.controller;

import com.honeypeng.entity.Department;
import com.honeypeng.entity.Employee;
import com.honeypeng.service.IEmployeeService;
import com.honeypeng.service.impl.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by PengWX on 2018/12/7.
 */
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService  employeeService;

    @Autowired
    private IDepartmentService departmentService;



    /**
     * 获取员工列表
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String getAllEmps(Model model) throws Exception{
//        int a = 1/0;
        Collection<Employee> all = employeeService.getAllEmployeeList();
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
        List<Department> departments = departmentService.getAllDepartmentList();
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
        employeeService.saveEmployee(employee);
        //重定向到emps请求  /:表示当前地址
        return "redirect:/emps";
    }

    /**
     * 跳转编辑页面
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String getEmp(@PathVariable("id") Integer id,Model model){
        Collection<Department> departments = departmentService.getAllDepartmentList();
        model.addAttribute("depts", departments);
        Employee employee = employeeService.selectEmployee(id);
        model.addAttribute("emp", employee);
        return "/add";
    }

    /**
     * 员工修改
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    /**
     * 删除emp
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeService.deleteById(id);
        return "redirect:/emps";
    }

    /**
     * 测试新增
     * @param employee
     * @return
     */
    @RequestMapping("insertEmp")
    public String saveEmp(Employee employee) {
        Integer empId = employeeService.saveEmployee(employee);
        return "redirect:/emps";
    }

    @PostMapping("getEmp")
    @ResponseBody
    public Employee getEmp(Integer id){
        Employee employee = employeeService.selectEmployee(id);
        return employee;
    }
}
