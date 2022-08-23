package com.xzk.mapper;

import com.xzk.pojo.QueryTeamVO;
import com.xzk.pojo.QueryVo;
import com.xzk.pojo.Team1;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TeamMapper接口
 *
 * 常用的方式; @Param注解 和 QueryVo 放入对象的方式
 */
public interface TeamMapper {
    List<Team1> queryByVO(QueryTeamVO vo);
    int teamUpdate1(Team1 team1);
    void addList(List<Team1> list);
    void delList(List<Integer> list);

    Team1 queryById1(int teamId);
    Team1 queryById2(int teamId);


    List<Team1> queryAll2();

    Map<String,Object> getTwoColumn(int teamId);
    List<Map<String,Object>> getTwoColumnList();
    int getCount();//获取总行数

    List<Team1> queryByName(String teamName);
    List<Team1> queryByLocation(String location);
    List<Team1> queryByFiled(@Param("colmn") String colmn,@Param("colmnValue") String colmnValue);


    List<Team1> queryByRange1(Integer min,Integer max);
    List<Team1> queryByRange2(@Param("min") Integer min,@Param("max") Integer max);
    List<Team1> queryByRange3(Map<String,Object> map);
    List<Team1> queryCondition(QueryVo vo);


    List<Team1> queryAll();
    Team1 queryById(Integer teamId);
    int teamAdd(Team1 team1);
    int teamUpdate(Team1 team1);
    int teamDelete(Integer teamId);
}
