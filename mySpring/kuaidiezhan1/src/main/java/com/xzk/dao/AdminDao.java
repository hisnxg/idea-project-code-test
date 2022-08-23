package com.xzk.dao;

import com.xzk.pojo.Admin;
import com.xzk.util.DruidUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class AdminDao{
    private static final String SQL_UPDATE_LOGIN_TIME = "UPDATE EADMIN SET LOGINTIME=?,LOGINIP=? WHERE USERNAME=?";
    private static final String SQL_LOGIN = "SELECT ID FROM EADMIN WHERE USERNAME=? AND PASSWORD=?";

    /**
     * 根据用户名，更新登陆时间和登录ip
     *  @param username
     * @param date
     * @param ip
     * @return
     */

    public void updateLoginTime(String username, Date date, String ip) {
        /*return this.getJdbcTemplate().update(SQL_UPDATE_LOGIN_TIME, new Object[]{username, date, ip}, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
                return handlerResult(resultSet);
            }
        });*/
        //1.    获取连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_UPDATE_LOGIN_TIME);
            //3.    填充参数
            state.setDate(1,new java.sql.Date(date.getTime()));
            state.setString(2,ip);
            state.setString(3,username);
            //4.    执行
            state.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //5.    释放资源
            DruidUtil.close(conn,state,null);
        }
    }

    /**
     * 管理员根据账号密码登陆
     *
     * @param username 账号
     * @param password 密码
     * @return 登陆的结果， true表示登陆成功
     */

    public boolean login(String username, String password) {
        /*int i = (int) this.getJdbcTemplate().queryForObject(SQL_LOGIN, new Object[]{username, password}, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
                return handlerResult1(resultSet);
            }
        });
        return i;*/
        //1.    获取连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state = null;
        ResultSet rs = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_LOGIN);
            //3.    填充参数
            state.setString(1,username);
            state.setString(2,password);
            //4.    执行并获取结果
            rs = state.executeQuery();
            //5.    根据查询结果，返回
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6.    释放资源
            DruidUtil.close(conn,state,rs);
        }
        return false;
    }

    public Admin handlerResult(ResultSet resultSet){
        Admin admin = new Admin();
        try {
            //admin.setId(resultSet.getInt("id"));
            admin.setUsername(resultSet.getString("username"));
            admin.setLoginTime(resultSet.getTimestamp("date"));
            admin.setIp(resultSet.getString("ip"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }
    public Admin handlerResult1(ResultSet resultSet){
        Admin admin = new Admin();
        try {
            //admin.setId(resultSet.getInt("id"));
            admin.setUsername(resultSet.getString("username"));
            admin.setPassword(resultSet.getString("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }
}
