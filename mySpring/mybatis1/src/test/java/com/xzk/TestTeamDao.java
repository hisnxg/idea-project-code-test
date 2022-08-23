package com.xzk;

import com.xzk.dao.TeamDao;
import com.xzk.dao.TeamDaoImpl;
import com.xzk.pojo.Team1;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestTeamDao {
    private TeamDao teamDao=new TeamDaoImpl();
    @Test
    public void testDel(){
        int num = teamDao.TeamDelete(1054);
        System.out.println(num);
    }
    @Test
    public void testUpdate(){
        Team1 team = teamDao.queryById(1054);
        team.setTeamName("zhansan");
        team.setLocation("las");
        int num = teamDao.TeamUpdate(team);
        System.out.println(num);
    }
    @Test
    public void testAdd(){
        Team1 team=new Team1();
        team.setTeamName("lina的球队");
        team.setLocation("北京");
        team.setCreateTime(new Date());
        int num = teamDao.TeamAdd(team);
        System.out.println(num);
    }
    @Test
    public void test02(){
        Team1 team = teamDao.queryById(1001);
        System.out.println(team);
    }
    @Test
    public void test01(){
        List<Team1> teams = teamDao.queryAll();
        teams.forEach(team -> System.out.println(team));
    }



}
