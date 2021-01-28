package com.csm.controller;

import com.csm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//@RestController
@Controller
public class HelloController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    WebApplicationContext webApplicationContext;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        System.out.println(applicationContext.getBean("commonsMultipartResolver"));
        CollectionUtils.arrayToList(applicationContext.getBeanDefinitionNames()).forEach(item -> System.out.println(item));
        return "hello";
    }

    @RequestMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("E:\\a" + File.separator + file.getOriginalFilename()));
        return "success";
    }

    @RequestMapping("user")
    @ResponseBody
    public User user(){
        User user = new User();
        user.setAge(18);
        user.setName("csm");
        user.setNo(1);
        return user;
    }
}
