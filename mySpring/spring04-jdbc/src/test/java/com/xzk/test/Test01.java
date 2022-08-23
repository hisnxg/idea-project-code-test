package com.xzk.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xzk.pojo.Team;
import com.xzk.dao.TeamDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test01 {
    ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");

    @Test//查询条数
    public void testGetCount(){
        TeamDao dao = (TeamDao) ac.getBean("teamDao");
        int count = dao.getCount();
        System.out.println("team表中有"+count+"条数据");

        Map<String, Object> maxAndMin = dao.getMaxAndMin();
        Set<Map.Entry<String, Object>> entries = maxAndMin.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }

    }

    @Test//查询所有
    public void testFindAll(){
        TeamDao dao = (TeamDao) ac.getBean("teamDao");
        List<Team> all = dao.findAll();
        for (Team team : all) {
            System.out.println(team);
        }
    }

    @Test//查询
    public void testFindById(){
        TeamDao dao = (TeamDao) ac.getBean("teamDao");
        Team t = dao.findById(4);
        System.out.println(t);

    }
    @Test//改
    public void test04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        TeamDao dao = (TeamDao) ac.getBean("teamDao");
        Team team = new Team();
        team.setName("快船1");
        team.setLocation("洛杉矶1");
        team.setId(3);
        int res = dao.update(team);
        System.out.println("更新数据的结果:"+res);

    }
    @Test//删
    public void test03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        TeamDao dao = (TeamDao) ac.getBean("teamDao");
        Team team = new Team();

        int res = dao.del(3);
        System.out.println("删除数据的结果:"+res);

    }
    @Test//增
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        TeamDao dao = (TeamDao) ac.getBean("teamDao");
        Team team = new Team();
        team.setName("小牛");
        team.setLocation("米达斯");
        int res = dao.insert(team);
        System.out.println("插入数据的结果:"+res);

    }

    @Test
    public void test01() throws PropertyVetoException {
        //创建数据源
        ComboPooledDataSource dateSource = new ComboPooledDataSource();
        dateSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dateSource.setJdbcUrl("jdbc:mysql://localhost/team?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        dateSource.setUser("root");
        dateSource.setPassword("123456");
        //使用JDBCTeamplete
        JdbcTemplate template = new JdbcTemplate(dateSource);
        String sql = "insert into team(uname,location) value(?,?)";
        int update = template.update(sql, "勇士", "金州");
        System.out.println("插入数据的结果为:"+update);
    }
}
