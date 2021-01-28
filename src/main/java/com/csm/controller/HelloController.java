package com.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
