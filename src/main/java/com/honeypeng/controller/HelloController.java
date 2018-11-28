package com.honeypeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jx on 2018/9/16.
 */
/*@Controller
@ResponseBody*/


/*@RestController*/
@Controller
public class HelloController {

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
    public String login(@RequestParam("username") String username,@RequestParam("password") String password
       , Model model
    ){
        if (!StringUtils.isEmpty(username) && Objects.equals("123456",password)){

            return "dashboart";
        }else {
            model.addAttribute("msg", "用户名或密码为空");
            return "index.html";
        }
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
