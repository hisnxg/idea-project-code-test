package com.dao.impl;


import org.springframework.stereotype.Repository;

import com.dao.UserDao;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
@Repository("udao")
public class UserDaoImpl implements UserDao {
    public void test1() {
        System.out.println("UserDaoImpl--------test1");
    }

    public void test2() {
        System.out.println("UserDaoImpl------------test2");
    }
}
