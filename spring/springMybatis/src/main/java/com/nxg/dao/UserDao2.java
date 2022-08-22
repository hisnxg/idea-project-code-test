package com.nxg.dao;

import com.nxg.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author nxg
 * date 2022/8/4 08 42
 * @apiNote
 */
public interface UserDao2 {
    //复杂查询
    public List<User> findA(List list);
    public List<User> findB(int[] array);
    public List<User> findC(Map map);

    //模糊查询
    //根据用户的姓名和编号进行查询
    List<User> findD(Map map);//map存的是键值对，在xml中操作时，key值名称与之对应
    //List<User> findE(User user);//实体类中与其属性对应
    //范围查询
    List<User> findF(Map map);

}
