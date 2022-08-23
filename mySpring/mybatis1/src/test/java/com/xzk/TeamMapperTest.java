package com.xzk;

import com.xzk.mapper.TeamMapper;
import com.xzk.pojo.QueryVo;
import com.xzk.pojo.Team1;
import com.xzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class TeamMapperTest {
    //通过动态代理的方式产生实现类
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    //private TeamMapper teamMapper = MybatisUtil.getSqlSession().getMapper(TeamMapper.class);

    @Test
    public void testFindByAll(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryAll();
        for (Team1 team1 : team1List) {
            System.out.println(team1);
        }


    }
    @Test
    public void testAdd(){
        TeamMapper teamDao = sqlSession.getMapper(TeamMapper.class);
        //添加
        Team1 team1 = new Team1();
        team1.setTeamName("zhansan66");
        team1.setLocation("las666");
        team1.setCreateTime(new Date());
        int num = teamDao.teamAdd(team1);
        sqlSession.commit();
        System.out.println(num);
        System.out.println("id值:"+team1.getTeamId());
    }

    @Test
    public void test02(){
        TeamMapper teamDao = sqlSession.getMapper(TeamMapper.class);
        Team1 team1 = teamDao.queryById(1001);
        sqlSession.commit();
        System.out.println(team1);
    }

    @Test
    public void test03(){

        TeamMapper teamDao = sqlSession.getMapper(TeamMapper.class);
        int num = teamDao.teamDelete(1115);
        sqlSession.commit();
        System.out.println(num);
    }

    /**
     * 4种方式
     *
     */
    @Test //1
    public void queryRandom1(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryByRange1(1001,1010);
        team1List.forEach(team1 -> System.out.println(team1));
    }
    @Test //2 注解方式
    public void queryRandom2(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryByRange2(1001,1010);
        team1List.forEach(team1 -> System.out.println(team1));
    }
    @Test //3 Map集合方式
    public void queryRandom3(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("min",1001);
        map.put("max",1010);
        List<Team1> team1List = mapper.queryByRange3(map);
        team1List.forEach(team1 -> System.out.println(team1));
    }
    @Test //4 对象方式
    public void queryCondition4(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        QueryVo queryVo = new QueryVo();
        queryVo.setMin(1001);
        queryVo.setMax(1111);
        queryVo.setName("%球队%");
        queryVo.setLocation("洛杉矶");
        List<Team1> team1List = mapper.queryCondition(queryVo);
        team1List.forEach(team1 -> System.out.println(team1));
    }
    @Test //5 queryByTeamName5
    public void queryByTeamName5(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryByName("lina的球队");
        team1List.forEach(team1 -> System.out.println(team1));
    }
    @Test //4 queryByLocation6
    public void queryByLocation6(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryByLocation("洛杉矶");
        team1List.forEach(team1 -> System.out.println(team1));
    }
    @Test //7 queryByFailed7
    public void queryByFailed7(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryByFiled("teamName", "lina的球队");
        List<Team1> team1List2 = mapper.queryByFiled("location", "洛杉矶");
        team1List.forEach(team1 -> System.out.println(team1));
        System.out.println("通过替换为location进行查询--------");
        for (Team1 team2 : team1List2) {
            System.out.println(team2);
        }
    }
    @Test//获取数据 总行数
    public void getColumn8(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        int count = mapper.getCount();
        System.out.println("总行数:"+count);
    }
    @Test
    public void getTwoColumn8(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        Map<String, Object> map = mapper.getTwoColumn(1001);
        System.out.println(map);
    }
    @Test
    public void getTwoColumnList8(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Map<String, Object>> list = mapper.getTwoColumnList();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void test10(){
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);
        List<Team1> team1List = mapper.queryAll2();
        team1List.forEach(team-> System.out.println(team));
    }
}
