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
 * date 2022/7/31
 * @apiNote
 */
public class Test1_2 {
    public static void main(String[] args) {
        try {
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(reader,"m1");
            //3.得到sqlSession
            SqlSession sqlSession = build.openSession();
            //4.操作sql    方法参数是被调取的sql的完整路径=namespace+id
            List<User> list = sqlSession.selectList("com.nxg.dao.UserDao3.getAll");
            //5.遍历
            for (User user : list) {
                System.out.println(user);
            }
            //6.关闭资源
            sqlSession.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
