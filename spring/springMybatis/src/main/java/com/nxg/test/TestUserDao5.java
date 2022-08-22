package com.nxg.test;

import com.nxg.bean.User;
import com.nxg.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nxg
 * date 2022/8/4
 * @apiNote
 */
public class TestUserDao5 {
    public static void main(String[] args) {

        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(reader).openSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> all = mapper.getAll();
            for (User user : all) {
                System.out.println(user);
            }
            sqlSession.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
