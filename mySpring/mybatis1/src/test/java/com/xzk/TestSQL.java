package com.xzk;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzk.mapper.TeamMapper;
import com.xzk.pojo.QueryTeamVO;
import com.xzk.pojo.Team1;
import com.xzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试类
 */
public class TestSQL {
    private SqlSession sqlSession = MybatisUtil.getSqlSession();

    @Test
    public void testSQL1() {
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        QueryTeamVO vo = new QueryTeamVO();
        vo.setName("人");//依次添加查询条件观察控制台的SQL语句
        //vo.setBeginTime(new Date());//依次添加查询条件观察控制台的SQL语句
        //vo.setLocation("马赛诸萨州波士顿");//依次添加查询条件观察控制台的SQL语句
        List<Team1> team1List = mapper.queryByVO(vo);
        for (Team1 team1 : team1List) {
            System.out.println(team1);
        }
    }

        /**
         * 更新
         */
        @Test
        public void testSQL2 () {
            TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
            Team1 team = new Team1();
            team.setTeamId(1114);
            team.setTeamName("lina");
            int update = mapper.teamUpdate1(team);
            sqlSession.commit();
            System.out.println(update);
        }
    @Test
    public void testSQL3 () {
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> list = new ArrayList<>();
        for (int i=1;i<=3;i++){
            Team1 team = new Team1();
            team.setTeamName("lisi"+i);
            team.setLocation("las"+i);
            list.add(team);
        }
        mapper.addList(list);
        sqlSession.commit();
    }
    @Test
    public void testSQL4(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1113);
        list.add(1113);
        mapper.delList(list);
        sqlSession.commit();
    }
    @Test void testPage(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        // PageHelper.startPage 必须紧邻查询语句，而且只对第一条查询语句生效
        PageHelper.startPage(2,5);
        List<Team1> teams = mapper.queryAll();//查询语句结尾不能有分号
        teams.forEach(team-> System.out.println(team));
        PageInfo<Team1> info=new PageInfo<>(teams);
        System.out.println("分页信息如下：");
        System.out.println("当前页:"+info.getPageNum());
        System.out.println("总页数:"+info.getPages());
        System.out.println("前一页:"+info.getPrePage());
        System.out.println("后一页:"+info.getNextPage());
        System.out.println("navigatepageNums:"+info.getNavigatepageNums());
        for (int num : info.getNavigatepageNums()) {
            System.out.println(num);
        }

    }
}