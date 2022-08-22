package com.java;

import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test02 {
    public static void main(String[] args) {
       ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        UserDao dao = (UserDao) app.getBean("userDao");
        User user = new User();
        user.setUsername("刘非");
        user.setPassword("123ae");
        user.setAge(19);
        int i = dao.insertUser(user);
        System.out.println("添加成功，i="+i);
    }
}
