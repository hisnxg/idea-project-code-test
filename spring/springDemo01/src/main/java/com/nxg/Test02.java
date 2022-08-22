package com.nxg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nxg
 * date 2022/7/15
 * @apiNote
 */
public class Test02 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application2.xml");
        Object stu1 = ac.getBean("stu1");
        System.out.println("stu1="+stu1.getClass().getName());

        Object stu2 = ac.getBean("stu2");
        System.out.println("stu1="+stu2);
    }
}
