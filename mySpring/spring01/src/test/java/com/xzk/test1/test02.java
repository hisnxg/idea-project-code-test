package com.xzk.test1;

import com.xzk.dao.TeamDao;
import com.xzk.pojo.Team;
import com.xzk.service.TeamService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test02 {
    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("DI.xml");
        TeamService teamService = (TeamService) ac.getBean("teamService");
        teamService.add();

        TeamService teamService2 = (TeamService) ac.getBean("teamService2");
        teamService2.add();

        TeamService teamService3 = (TeamService) ac.getBean("teamService3");
        teamService3.add();

        TeamService teamService4 = (TeamService) ac.getBean("teamService4");
        teamService4.add();
    }

    @Test
    public void test01(){
        TeamDao teamDao = new TeamDao();
        TeamService teamService = new TeamService();
        teamService.setTeamDao(teamDao);
        teamService.add();
    }
}
