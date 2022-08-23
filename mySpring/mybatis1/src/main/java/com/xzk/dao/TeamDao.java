package com.xzk.dao;

import com.xzk.pojo.Team1;

import java.util.List;

/**
 * 原有的dao写法
 */
public interface TeamDao {
    List<Team1> queryAll();
    Team1 queryById(Integer teamId);
    int TeamAdd(Team1 team1);
    int TeamUpdate(Team1 team1);
    int TeamDelete(Integer teamId);
}
