package com.csm.application;

import com.csm.controller.HelloController;
import com.csm.mvc.MvcConfig;
import com.csm.servlet.HelloServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringApplication {
    public static void main(String[] args) throws LifecycleException {

//        System.out.println(SingleTonUser.getInstance());
//        System.out.println(SingleTonUser.getInstance());

//        ApplicationContext context = new AnnotationConfigApplicationContext("com.csm");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(AppConfig.class);
//        context.addApplicationListener(new ApplicationStatedListener());
//        context.refresh();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item -> System.out.println(item));
//        UserService userService = (UserService) context.getBean("userService");
//        UserService userService1 = context.getBean(UserService.class);
//        System.out.println(userService);
//        System.out.println(userService1);
//        System.out.println(userService.getClass());
//        userService.save();

//        CarDao carDao = context.getBean(CarDao.class);
//        System.out.println(carDao.getClass());
//        System.out.println(CarDao.class.isAssignableFrom(carDao.getClass()));
//        System.out.println(carDao.getClass().getSuperclass());
//        carDao.drive();

//        CarDao carDao = context.getBean(CarDao.class);
//        carDao.drive();
//        carDao.stop();

//        dispatcherServlet.setApplicationContext();

        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8888);
        connector.setURIEncoding("UTF-8");
//        tomcat.setBaseDir();  // 设置工作目录，这个工作目录可以是任意目录，主要是tomcat需要这 个目录来记录一些东西，比如记录word信息，日志信息（如果配置了日志的话），以及临时文件存储等。
//        tomcat.getHost().setAppBase(); // 设置我们的项目程序所在的appbase，即放项目代码的地方。在通常的tomcat配置中，这个目录一般是webapps。
        tomcat.getService().addConnector(connector);

//        StandardServer server = (StandardServer) tomcat.getServer();
        StandardContext standardContext = new StandardContext();
        standardContext.addLifecycleListener(new Tomcat.FixContextListener()); // FixContextListener，这个主要是在项目 部署完后，将这个上下文设置为configured，表示已经配置好了（不然，tomcat启动时会报错，即相应上下文还未配置好）。
        standardContext.setPath("/mvc");

        tomcat.getHost().addChild(standardContext);
//        tomcat.addServlet("/mvc", "helloServlet", new HelloServlet());
//        standardContext.addServletMappingDecoded("/hello", "helloServlet");
        tomcat.start();

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MvcConfig.class);
        webApplicationContext.setServletContext(standardContext.getServletContext());
        webApplicationContext.refresh();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        tomcat.addServlet("/mvc", "dispatcher", dispatcherServlet);
        standardContext.addServletMappingDecoded("/", "dispatcher");

        tomcat.getServer().await(); // 维持tomcat服务，否则tomcat一启动就会关闭
    }
}
