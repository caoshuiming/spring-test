package com.csm.test.dao;

import com.csm.dao.UserDao;

import java.util.Date;

public class ProxyUserDao implements UserDao {

    private UserDao userDao;

    public ProxyUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("执行前");
        Date start = new Date();
        userDao.save();
        Date end = new Date();
        System.out.println("执行后");
        System.out.println("执行时间：" + (end.getTime() - start.getTime()));
    }

    @Override
    public void car() {

    }
}
