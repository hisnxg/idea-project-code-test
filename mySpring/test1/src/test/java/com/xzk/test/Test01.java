package com.xzk.test;

import com.xzk.dao.BaseExpressDao;
import com.xzk.pojo.Express;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {
    ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
    @Test
    public void findByUserPhone(){
        BaseExpressDao dao = (BaseExpressDao) ac.getBean("baseExpressDao");
        List<Express> byUserPhone = dao.findByUserPhone("16607259654");
        System.out.println("-------------------");
        for (Express express : byUserPhone) {
            System.out.println(express);
        }
    }

    @Test
    public void findBySysPhone(){
        BaseExpressDao dao = (BaseExpressDao) ac.getBean("baseExpressDao");
        List<Express> byUserPhone = dao.findBySysPhone("16607259654");
        System.out.println("-------------------");
        for (Express express : byUserPhone) {
            System.out.println(express);
        }
    }

    @Test
    public void update(){
        BaseExpressDao dao = (BaseExpressDao) ac.getBean("baseExpressDao");
        Express newExpress = new Express();
        newExpress.setNumber("4965969");
        newExpress.setUsername("李四15666");
        newExpress.setCompany("顺丰");
        newExpress.setStatus(1);
        newExpress.setId(5);
        int update = dao.update(newExpress);
        System.out.println("-------------------"+update);

    }


    @Test
    public void del(){
        BaseExpressDao dao = (BaseExpressDao) ac.getBean("baseExpressDao");
        int delete = dao.delete(5);
        System.out.println("-------------------"+delete);

    }



    public void insert(){
        BaseExpressDao dao = (BaseExpressDao) ac.getBean("baseExpressDao");
        Express newExpress = new Express("451544","张三","16607259654","顺丰","787845","16607259654");
        newExpress.setNumber("454515");
        newExpress.setUsername("李四");
        newExpress.setUserPhone("16607259654");
        newExpress.setCompany("顺丰");
        newExpress.setCode("166600");
        newExpress.setStatus(0);
        newExpress.setSysPhone("16607259654");
        int insert = dao.insert(newExpress);
        System.out.println("-------------------"+insert);

    }
}
