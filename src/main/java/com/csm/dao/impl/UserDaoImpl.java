package com.csm.dao.impl;

import com.csm.annotation.Transaction;
import com.csm.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("userDao save");
    }

    @Override
    public void car() {
        System.out.println("car...");
    }

}
