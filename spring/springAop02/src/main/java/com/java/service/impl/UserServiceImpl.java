package com.java.service.impl;

import com.java.dao.UserDao;
import com.java.service.UserService;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test1() {
//        System.out.println(8/0);
        System.out.println("UserServiceImpl-----------");
        userDao.test1();
    }

    public void test2() {
        System.out.println("UserServiceImpl-----------test2");
        userDao.test2();
    }
}
