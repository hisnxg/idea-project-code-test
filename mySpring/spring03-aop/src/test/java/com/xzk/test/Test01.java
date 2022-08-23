package com.xzk.test;

import com.xzk.service.NBAService;
import com.xzk.service.TeamService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        TeamService teamService = (TeamService)ac.getBean("teamService");
        teamService.add(10001,"湖人队");
        System.out.println("----------------------------------");
        boolean update = teamService.update(888);
        System.out.println("update的结果为:"+update+"~~~~~~~~~~~~~~~~~");
        NBAService nbaService = (NBAService)ac.getBean("nbaService");
        nbaService.add(10002,"湖人队2");
        System.out.println("---------");
        boolean update2 = nbaService.update(9999);
        System.out.println("update的结果为:"+update2+"++++++++++++++++");
    }
}
