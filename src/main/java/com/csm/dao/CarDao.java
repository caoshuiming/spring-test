package com.csm.dao;

import com.csm.annotation.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao {

    @Transaction(propagate = "new")
    public void drive(){
        System.out.println("drive");
    }

    public void stop(){
        System.out.println("stop");
    }
}
