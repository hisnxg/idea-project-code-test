package com.nxg;

/**
 * @author nxg
 * date 2022/7/7
 * @apiNote
 */

import com.nxg.Service.UsersService;
import com.nxg.Service.impl.UsersServiceImpl;
import com.nxg.bean.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 测试类
 */
public class Test01 {

    public static void main(String[] args) {
       /* UsersService usersService = new UsersServiceImpl();
        usersService.userDao();*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        usersService.insert(new Users());

        Object u2 = applicationContext.getBean("u2");
        System.out.println("u2---"+u2);


        Object u3 = applicationContext.getBean("u3");
        System.out.println("u3---"+u3);

        Object u4 = applicationContext.getBean("u4");
        System.out.println("u4---"+u4);
        Object u6 = applicationContext.getBean("u6");
        System.out.println("u6---非静态方法--"+u6);
    }
}
