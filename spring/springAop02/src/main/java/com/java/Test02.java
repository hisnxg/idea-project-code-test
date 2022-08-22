package com.java;

import com.java.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test02 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("application2.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.test1();
    }
}
