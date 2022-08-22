package com.nxg.test;

import com.nxg.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author nxg
 * date 2022/8/4
 * @apiNote
 */
public class Test2 {
    public static void main(String[] args) {

        /*try {
            //通过主键查询
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
            //3.sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4.操作sql
            //sqlSession.selectList("com.nxg.dao.UserDao.findById", "参数“);
            List<UserDao2> userList = sqlSession.selectList("com.nxg.dao.UserDao.findById", 5);
            //5.遍历
            for (UserDao2 user : userList) {
                System.out.println(user);
            }
            //6.关闭资源
            sqlSession.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
            //3.sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4.操作sql
            User user = new User();
            user.setUsername("李四33333333");
            user.setPassword("qeafsd");
            user.setAge(18);

            int insert = sqlSession.insert("com.nxg.dao.UserDao.insertUser",user);
            //添加成功后需要提交事务，才更新数据库数据
            sqlSession.commit();
            System.out.println("添加成功="+insert+",userId="+user.getUserId());
            //6.关闭资源
            sqlSession.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
