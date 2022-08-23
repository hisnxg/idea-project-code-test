package com.nxg.spring;

import com.nxg.spring.pojo.User;
import com.nxg.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author nxg
 * date 2022/1/9
 * @apiNote
 */
public class ApplicationTest {
    @Test
    public void test02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        User user1 = (User) applicationContext.getBean("user1");
        System.out.println(user1);
        applicationContext.close();//关闭spring容器
    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application2.xml");
        UserService userServicer = (UserService) applicationContext.getBean("userService");
        userServicer.addUser();
//        System.out.println(user4);
    }
}