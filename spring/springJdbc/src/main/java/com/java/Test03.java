package com.java;

import com.java.bean.User;
import com.java.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test03 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        UserDao dao = (UserDao) app.getBean("userDao");
        User byId = dao.findById(2);
        System.out.println(byId);
        List<User> all = dao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }
}
