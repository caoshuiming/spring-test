package com.csm.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

@Configuration
@EnableAspectJAutoProxy
//@Import({UserDaoConfig.class, UserServiceConfig.class})
@ComponentScan("com.csm")
public class AppConfig {

    @EventListener
    public void refreshListener(ContextRefreshedEvent event){
//        System.out.println(event.getTimestamp());
//        ApplicationContext context = event.getApplicationContext();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item -> System.out.println(item));
    }

}
