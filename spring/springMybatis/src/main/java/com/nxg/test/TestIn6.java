package com.nxg.test;

import com.nxg.bean.User;
import com.nxg.dao.UserDao2;
import com.nxg.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nxg
 * date 2022/8/4 08 42
 * @apiNote
 */
public class TestIn6 {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);
        /*List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(9);
        List<User> a = mapper.findA(list);
        for (User user : a) {
            System.out.println(user);
        }*/
        /*int[] array = new int[]{1,2,3,7,9};
        List<User> b = mapper.findB(array);
        for (User user : b) {
            System.out.println(user);
        }*/
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(9);
        Map map = new HashMap();
        map.put("sid",list);
        List<User> c = mapper.findC(map);
        for (User user : c) {
            System.out.println(user);
        }

        SqlSessionUtil.closeSqlSession();
    }

}
