package com.csm.application;

import com.csm.annotation.SpringBootAnnotation;
import org.apache.catalina.LifecycleException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootAnnotation
public class SpringBootApplication {
    public static void main(String[] args) throws LifecycleException {
        SpringApplication.run(args);
    }
}
