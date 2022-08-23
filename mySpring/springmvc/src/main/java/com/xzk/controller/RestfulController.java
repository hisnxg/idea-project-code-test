package com.xzk.controller;

import com.xzk.pojo.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * restful风格的控制器
 */
//@Controller
public class RestfulController {

    private static List<Team> teamList;
    static {
        teamList = new ArrayList<>(3);
        for (int i=1;i<=3;i++){
            Team team = new Team();
            team.setTeamId(1000+i);
            team.setTeamName("湖人"+i);
            team.setLocation("洛杉矶"+i);
            teamList.add(team);
        }
    }
    /**
     * 更新数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/team/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id")int id){
        System.out.println(id);
        for (Team team1:teamList){
            if (team1.getTeamId() == id){
                teamList.remove(team1);
                return "204";
            }
        }
        return "404";
    }

    /**
     * 更新数据
     * @param id
     * @param newTeam
     * @return
     */
    @RequestMapping(value = "/team/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id")int id,Team newTeam){
        System.out.println(id);
        for (Team team:teamList){
            if (team.getTeamId() == id){
                team.setTeamName(newTeam.getTeamName());
                team.setLocation(newTeam.getLocation());
                return "204";
            }
        }
        return "404";
    }

    /**
     * 添加一个球队
     */
    @RequestMapping("team")
    @ResponseBody
    public String add(Team team){
        System.out.println("添加POST--发起的请求---------");
        teamList.add(team);
        return "201";
    }

    /**
     * 查询所有的球队
     * @return
     */
    @RequestMapping(value = "/teams",method = RequestMethod.GET)
    @ResponseBody
    public List<Team> getAll(){
        System.out.println("查询所有GET--发起的请求---------");
        return teamList;
    }

    /**
     * 根据id 查询单个的球队
     * @return
     */
    @RequestMapping(value = "/team/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Team getOne(@PathVariable("id")int id){
        System.out.println("查询单个GET--发起的请求---------");
        for (Team team:teamList){
            if (team.getTeamId() == id){
                return team;
            }
        }
        return null;
    }

    @RequestMapping("hello")
    public String hello(){
        return "restful";
    }
}
