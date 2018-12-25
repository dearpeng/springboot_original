package com.honeypeng.controller;

import com.honeypeng.entity.Employee;
import com.honeypeng.entity.EmployeeExample;
import com.honeypeng.service.IEmployeeService;
import com.honeypeng.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by jx on 2018/9/16.
 */
/*@Controller
@ResponseBody*/


/*@RestController*/
@Controller
public class HelloController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/helloTest")
    @ResponseBody
    public String helloTest() {
        return "SynchronizedTest quick springboot";
    }

    @RequestMapping("/toViewData")
    public String toViewData(Map<String, Object> map) {
        map.put("hello", "<h1>hello View Data</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "/hello";
    }

    @PostMapping(value ="/user/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password, Model model,HttpSession session){

        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            EmployeeExample example = new EmployeeExample();
            example.or().andLastNameEqualTo(username);
            List<Employee> emps = employeeService.selectByExample(example);
            if (CollectionUtils.isEmpty(emps)) {
                model.addAttribute("msg", "用户名不存在");
                return "index.html";
            }else {
                Employee emp = emps.get(0);
                String md5Hex = MD5.md5Hex(password, emp.getSalt());
                if (Objects.equals(md5Hex, emp.getPassword())) {
                    //防止表单重复提交,采用重定向
                    session.setAttribute("user",emp);
                    return "redirect:/main.html";
                }else {
                    model.addAttribute("msg", "用户名或密码为空或错误");
                    return "index.html";
                }
            }
        }else {
            model.addAttribute("msg", "用户名或密码为空");
            return "index.html";
        }
    }

    @RequestMapping("signOut")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "index";
    }

    /* *
    * 将/请求隐射到index页面,另外一种写法是MyConfigurerAdapter中的addViewControllers
    * @author pengWX
    * @date 2018/11/19 17:59
    */
   /* @RequestMapping("/")
    public String index() {
        return "index";
    }*/


}
