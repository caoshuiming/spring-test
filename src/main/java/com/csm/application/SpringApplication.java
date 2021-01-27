package com.csm.application;

import com.csm.dao.CarDao;
import com.csm.service.UserService;
import com.csm.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {

//        System.out.println(SingleTonUser.getInstance());
//        System.out.println(SingleTonUser.getInstance());

//        ApplicationContext context = new AnnotationConfigApplicationContext("com.csm");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.addApplicationListener(new ApplicationStatedListener());
        context.refresh();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item -> System.out.println(item));
//        UserService userService = (UserService) context.getBean("userService");
//        UserService userService1 = context.getBean(UserService.class);
//        System.out.println(userService);
//        System.out.println(userService1);
//        System.out.println(userService.getClass());
//        userService.save();

        CarDao carDao = context.getBean(CarDao.class);
        System.out.println(carDao.getClass());
        carDao.drive();
    }
}
