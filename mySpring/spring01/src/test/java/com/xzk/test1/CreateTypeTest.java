package com.xzk.test1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTypeTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("createType.xml");
    }
}
