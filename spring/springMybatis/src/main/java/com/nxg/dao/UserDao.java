package com.nxg.dao;

import com.nxg.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author nxg
 * date 2022/7/31
 * @apiNote
 */
public interface UserDao {

     //增删改查的方法
     List<User> getAll();
     //主键查询
     User findById(int id);
     //新增
     int insertUser(User user);
     //新增2
     //int insertUser2(String username,String password,int age);//错误

     //新增3
     int insertUser3(Map map);//map

     //查询userid的max，min，avg查询
     Map find();

}
