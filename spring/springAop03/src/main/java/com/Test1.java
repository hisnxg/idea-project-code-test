package com;

import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("application1.xml");
        UserService userService = (UserService) app.getBean("uservice");
        //userService.test1();
        userService.test2();
    }
}
