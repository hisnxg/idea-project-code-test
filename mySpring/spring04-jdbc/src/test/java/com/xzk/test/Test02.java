package com.xzk.test;

import com.xzk.pojo.Team;
import com.xzk.service.TeamService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        TeamService teamService = (TeamService) ac.getBean("teamService");
        int num = teamService.insert(new Team("凯尔特人", "波士顿"));
        System.out.println(num);
    }
}
