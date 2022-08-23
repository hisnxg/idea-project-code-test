package com.xzk.controller;
import com.xzk.service.TeamService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TeamController {
    //@Resource(name = "teamService",type = TeamService.class)
    @Resource //JDK版本高于1.6 ,自动装配默认按照名称 但是如果名称没有相符的,就按照类型自动装配
    private TeamService teamService;
    public void add(){
        teamService.add();
        System.out.println("TeamController--add---");
    }
    public TeamController() {
        System.out.println("TeamController--默认的构造方法");
    }
}
