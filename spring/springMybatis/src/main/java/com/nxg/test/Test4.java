package com.nxg.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author nxg
 * date 2022/8/4
 * @apiNote
 */
public class Test4 {
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
            Map map = sqlSession.selectOne("com.nxg.dao.UserDao.find");
            //遍历
            Set<Map.Entry> entrySet = map.entrySet();
            for (Map.Entry entry : entrySet) {
                System.out.println(entry);
            }
            //6.关闭资源
            sqlSession.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
