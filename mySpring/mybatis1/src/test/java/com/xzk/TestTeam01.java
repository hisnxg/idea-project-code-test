package com.xzk;

import com.xzk.pojo.Team1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class TestTeam01 {
    //mybatis的配置文件---相当于创建工厂的图纸
    private String resource = "mybatis.xml";
    private SqlSession sqlSession = null;

    /**
     * 删除
     */
    @Test
    public void del(){
        int num = sqlSession.delete("com.xzk.pojo.Team1.del", 1113);
        sqlSession.commit();
        System.out.println(num);
    }
    /**
     * 修改 更新数据
     */
    @Test
    public void testUpdate(){
        Team1 team1 = sqlSession.selectOne("com.xzk.pojo.Team1.queryById",1113);
        team1.setTeamName("李四1010");
        team1.setLocation("洛杉矶1010");
        int num = sqlSession.update("com.xzk.pojo.Team1.update", team1);
        sqlSession.commit();//手动提交事务
        System.out.println(num);
    }

    /**
     *增加一条数据
     */
    @Test
    public void testAdd(){
        Team1 team1 = new Team1();
        team1.setTeamName("张三");
        team1.setLocation("洛杉矶");
        team1.setCreateTime(new Date());
        int i = sqlSession.insert("com.xzk.pojo.Team1.add",team1);//增删改必须手动提交事务
        sqlSession.commit();//手动提交事务
        System.out.println(i);
    }

    /**
     * 通过id查询
     */
    @Test
    public void test02(){
        System.out.println("test02---------");
        Team1 team1 = sqlSession.selectOne("com.xzk.pojo.Team1.queryById", 1001);
        System.out.println(team1);
    }
    @Before //表示该方法在执行测试方法之前执行
    public void before(){
        //System.out.println("before--------");
        try {
            //1.    读取mybatis的配置文件
           Reader reader = Resources.getResourceAsReader(resource);
            //2.    创建SqlSessionFactory对象,目的是获取sqlSession --根据图纸创建工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //3.    创建可以执行SQL语句的sqlsession--工厂创建产品
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @After //表示该方法在执行测试方法之后执行
    public void after(){
        //System.out.println("after--------");
        //6.    关闭SqlSession.释放资源
        sqlSession.close();
    }

    @Test
    public void testFindAll(){

        try {
           /* //1.    读取mybatis的配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            //2.    创建SqlSessionFactory对象,目的是获取sqlSession --根据图纸创建工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //3.    创建可以执行SQL语句的sqlsession--工厂创建产品
            sqlSession = sqlSessionFactory.openSession();*/
            //4.    执行SQL语句
            List<Team1> teamList = sqlSession.selectList("com.xzk.pojo.Team1.queryAll");
            //5.    循环输出查询的结果
            for (Team1  team : teamList) {
                System.out.println(team);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.    关闭SqlSession.释放资源
            sqlSession.close();
        }
    }
}
