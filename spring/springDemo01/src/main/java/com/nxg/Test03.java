package com.nxg;

import com.nxg.bean.Teacher;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test03 {

    public static void main(String[] args) {
        //1. 加载配置文件
        ApplicationContext ap = new ClassPathXmlApplicationContext("application3.xml");
        Teacher t = (Teacher) ap.getBean("t1");
        //2. 得到对象类型的信息
        Object[] objects = t.getObjects();
        for (Object o : objects) {
            System.out.println("o="+o);
            
        }
        System.out.println("---------------------");
        List list = t.getList();
        for (Object o : list) {
            System.out.println(o+",");            
        }
        System.out.println("----------------------");
        Set set = t.getSet();
        for (Object o : set) {
            System.out.println(o+",");   
        }
        System.out.println("-------------");
        Map map = t.getMap();
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            System.out.println(key+",value="+map.get(key));
        }
        System.out.println("--------------");
        Properties properties = t.getProperties();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username="+username+",password="+password);
    }
}
