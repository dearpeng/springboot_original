package com.honeypeng.controller;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jx on 2019/3/10.
 */
@Controller("/upload")
public class UploadController {



    @RequestMapping("/downloadFromRomate")
    @ResponseBody
    public String downloadFromRomate(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
//        File file = saveUrlAs("http://img.zahuiyin.com/zahy/cls/secondhand_car/2019/1/7/92aa5bca-abef-4307-8c5a-c601126858c1.pdf", servletContext.getRealPath("/uploadfile"), null);
//        System.out.println(file);

        return "111";
    }





}
