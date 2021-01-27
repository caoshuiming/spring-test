package com.csm.test.service;

import com.csm.dao.UserDao;
import com.csm.dao.impl.UserDaoImpl;
import com.csm.service.UserService;
import com.csm.service.impl.UserServiceImpl;
import com.csm.test.proxy.ProxyCglib;
import com.csm.test.proxy.ProxyJDK;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class ProxyUserServiceTest {

    @Test
    public void test(){
        ProxyUserService proxyUserService = new ProxyUserService(new UserServiceImpl());
        proxyUserService.save();
    }

    @Test
    public void testProxyUserServiceJDK(){
//        System.out.println(new UserServiceImpl().getClass());
        ProxyJDK proxyJDK = new ProxyJDK(new UserServiceImpl());
        UserService userService = (UserService) proxyJDK.getProxy();
//        System.out.println(userService.getClass());
        userService.save();
    }

    @Test
    public  void testCglibProxy(){
        System.out.println(new UserDaoImpl().getClass());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDaoImpl.class);
        enhancer.setCallback(new ProxyCglib());
        UserDao userDao = (UserDao) enhancer.create();
        System.out.println(new UserDaoImpl().getClass());
        userDao.save();
    }
}
