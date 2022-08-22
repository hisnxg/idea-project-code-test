package com.nxg.demo;

import com.nxg.demo.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        User u1 = (User) app.getBean("u1");
        System.out.println(u1.getUsername());

        User u2 = (User) app.getBean("u1");
        System.out.println(u2);
    }
}
