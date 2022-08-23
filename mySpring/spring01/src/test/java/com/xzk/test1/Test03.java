package com.xzk.test1;

import com.xzk.controller.TeamController;
import com.xzk.pojo.Team;
import com.xzk.service.TeamService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
/*        Team team = (Team) ac.getBean("team");
        System.out.println(team);*/

/*        TeamService teamService = (TeamService) ac.getBean("teamService");
        teamService.add();*/
        TeamController teamController = (TeamController) ac.getBean("teamController");
        teamController.add();

    }
}
