package com.nxg.dao;

import com.nxg.bean.Grade;
import com.nxg.bean.User;

import java.util.List;

/**
 * @author nxg
 * date 2022/8/5 08 06
 * @apiNote
 */
public interface GradeDao {
    //根据年级id查询用户信息
    Grade findByGId(int id);
    //查询用户信息以及对应的年级信息
    List<User> findAllUser();
}
