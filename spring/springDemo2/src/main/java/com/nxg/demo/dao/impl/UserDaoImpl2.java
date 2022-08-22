package com.nxg.demo.dao.impl;

import com.nxg.demo.bean.User;
import com.nxg.demo.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
@Repository("udao2")
public class UserDaoImpl2 implements UserDao {

    public void insert(User user) {
        System.out.println("UserDaoImpl2 ----->22222222222");
    }
}
