package com.nxg.test;

import com.nxg.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nxg
 * date 2022/8/4
 * @apiNote
 */
public class Test3 {
    public static void main(String[] args) {

        try {
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
            //3.sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4.操作sql
            Map map = new HashMap();
            map.put("uname","道友");
            map.put("pwd","likeId");
            map.put("age",22);

            int insert = sqlSession.insert("com.nxg.dao.UserDao.insertUser3",map);
            //添加成功后需要提交事务，才更新数据库数据
            sqlSession.commit();
            System.out.println("添加成功="+insert);
            //6.关闭资源
            sqlSession.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
