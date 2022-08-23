package com.xzk.test;

import com.github.pagehelper.PageInfo;
import com.xzk.mapper.TeamMapper;
import com.xzk.pojo.Team;
import com.xzk.pojo.TeamExample;
import com.xzk.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestMapper{
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private TeamService teamService;
    @Test
    public void test01(){
        Team team = teamMapper.selectByPrimaryKey(1001);
        System.out.println(team);
    }
    @Test
    public void test02(){
        PageInfo<Team> teamPageInfo = teamService.queryBypage(1, 5, null);
        System.out.println(teamPageInfo);
    }

}
