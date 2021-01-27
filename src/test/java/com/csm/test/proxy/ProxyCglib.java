package com.csm.test.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class ProxyCglib implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前");
        Date start = new Date();
        Object result = methodProxy.invokeSuper(target, args);
        Date end = new Date();
        System.out.println("执行后");
        System.out.println("执行时间为：" + (end.getTime() - start.getTime()));
        return result;
    }
}
