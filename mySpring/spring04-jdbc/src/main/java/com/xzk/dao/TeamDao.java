package com.xzk.dao;

import com.xzk.pojo.Team;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TeamDao extends JdbcDaoSupport {

    public int insert(Team team){
        //使用JDBCTemplete
        //JdbcTemplate template = new JdbcTemplate(dateSource);
        String sql = "insert into team(uname,location) value(?,?)";
        int update = this.getJdbcTemplate().update(sql, team.getName(), team.getLocation());
        return update;
    }
    public int del(int id){
        //使用JDBCTemplete
        //JdbcTemplate template = new JdbcTemplate(dateSource);
        String sql = "delete from team where id=?";
        int del = this.getJdbcTemplate().update(sql, id);
        return del;
    }
    public int update(Team team){
        //使用JDBCTemplete
        //JdbcTemplate template = new JdbcTemplate(dateSource);
        String sql = "update team set uname=?,location=? where id=?";
        int del = this.getJdbcTemplate().update(sql,team.getName(),team.getLocation(),team.getId());
        return del;
    }

    //查询  查询单个使用queryForObject
    public Team findById(int id){
        String sql = "select * from team where id=?";
       return this.getJdbcTemplate().queryForObject(sql,new Object[]{id},new RowMapper<Team>(){
          //把这个结果集映射到各个实体类的属性当中
           @Override //通过映射 到实体类  返回结果集
            public Team mapRow(ResultSet resultSet, int i) throws SQLException {
                /*Team team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("uname"));
                team.setLocation(resultSet.getString("location"));*/
                return handlerResult(resultSet);
            }
        });
    }
    //查询  查询多个使用query
    public List<Team> findAll(){
        String sql = "select * from team";
        return this.getJdbcTemplate().query(sql,new RowMapper<Team>(){
            @Override
            public Team mapRow(ResultSet resultSet, int i) throws SQLException {
                /*Team team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("uname"));
                team.setLocation(resultSet.getString("location"));*/
                return handlerResult(resultSet);
            }
        });
    }

    /**
     * 自己封装一个 处理结果 的方法
     * @param resultSet
     * @return
     */
    public Team handlerResult(ResultSet resultSet){
        Team team = new Team();
        try {
            team.setId(resultSet.getInt("id"));
            team.setName(resultSet.getString("uname"));
            team.setLocation(resultSet.getString("location"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return team;
    }

    /**
     * 查询表中有多少列,即多少条数据
     * @return
     */
    public int getCount(){
        String sql = "select count(id) from team";
        return this.getJdbcTemplate().queryForObject(sql,Integer.class);
    }

    /**
     * 查询最大id和最小id的数据 集合
     * @return
     */
    public Map<String, Object> getMaxAndMin(){
        String sql = "select max(id),min(id) from team";
        return this.getJdbcTemplate().queryForMap(sql);
    }
}
