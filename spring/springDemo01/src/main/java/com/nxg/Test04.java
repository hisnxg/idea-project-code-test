package com.nxg;

import com.nxg.Service.UsersService;
import com.nxg.bean.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test04 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationioc4.xml");
        UsersService userService = (UsersService) app.getBean("uService");
        userService.insert(new Users());

    }
}
