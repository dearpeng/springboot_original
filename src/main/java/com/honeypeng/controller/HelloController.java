package com.honeypeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jx on 2018/9/16.
 */
/*@Controller
@ResponseBody*/


@RestController
public class HelloController {

    @RequestMapping
    public String helloTest(){
        return "SynchronizedTest quick springboot";
    }

}
