package com.nxg.test;

import com.nxg.bean.User;
import com.nxg.dao.UserDao2;
import com.nxg.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nxg
 * date 2022/8/5 08 00
 * @apiNote
 */
public class TestBetween {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);
        Map map = new HashMap();
        map.put("begin",1);
        map.put("end",6);
        List<User> d = mapper.findF(map);
        for (User user : d) {
            System.out.println(user);
        }
        SqlSessionUtil.closeSqlSession();
    }
}
