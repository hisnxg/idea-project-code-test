package com.xzk;

import com.xzk.mapper.PlayerMapper;
import com.xzk.mapper.TeamMapper;
import com.xzk.pojo.Player;
import com.xzk.pojo.Team1;
import com.xzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestPlayerMapper {
    private SqlSession sqlSession = MybatisUtil.getSqlSession();

    TeamMapper teamMapper=MybatisUtil.getSqlSession().getMapper(TeamMapper.class);
    @Test
    public void test06(){
        Team1 team = teamMapper.queryById1(1025);
        System.out.println(team);
        List<Player> playerList = team.getPlayerList1();
        System.out.println("该球队的球员个数:"+playerList.size());
        playerList.forEach(player -> System.out.println(player));
    }
    @Test
    public void test05(){
        Team1 team = teamMapper.queryById2(1025);
        System.out.println(team);
        List<Player> playerList = team.getPlayerList2();
        System.out.println("该球队的球员个数:"+playerList.size());
        playerList.forEach(player -> System.out.println(player));
    }
    @Test
    public void test07(){
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryById(1);
        System.out.println(player);
    }




    @Test
    public void test01(){
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryById(1);
        System.out.println(player);
    }
    @Test
    public void test02(){
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryById1(1);
        System.out.println(player);
    }
    @Test
    public void test03(){
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryById2(1);
        System.out.println(player);
    }
    @Test
    public void test04(){
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.queryById3(1);
        System.out.println(player);
    }
}
