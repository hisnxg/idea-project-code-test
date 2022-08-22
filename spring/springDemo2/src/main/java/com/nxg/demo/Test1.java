package com.nxg.demo;

import com.nxg.demo.bean.User;
import com.nxg.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test1 {

    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("application.xml");
        UserService uservice = (UserService) ap.getBean("uservice");
        uservice.insert(new User());
    }
}
