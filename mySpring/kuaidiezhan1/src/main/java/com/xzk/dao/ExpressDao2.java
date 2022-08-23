package com.xzk.dao;

import com.xzk.pojo.Express;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ExpressDao2 extends JdbcDaoSupport {

        public static final  String SQL_CONSOLE = "SELECT "+
                "COUNT(ID) data1_size," +
                "COUNT(TO_DAYS(INTIME)=TO_DAYS(NOW()) OR NULL) data1_day ,"+
                "COUNT(STATUS=0 OR NULL) data2_size,"+
                "COUNT(TO_DAYS(INTIME)=TO_DAYS(NOW()) AND STATUS=0 OR NULL) data2_day "+
                "FROM EXPRESS";
        //通过查询数据库中的所有快递信息
        public static final  String SQL_FIND_ALL = "SELECT * FROM EXPRESS";
        //用分页查询数据库中的快递信息
        public static final String SQL_FIND_LIMIT = "SELECT * FROM EXPRESS LIMIT ?,?";
        //通过快递单号查询快递信息
        public static final  String SQL_FIND_BY_NUMBER = "SELECT * FROM EXPRESS WHERE NUMBER=?";
        //通过取件码查询快递信息
        public static final  String SQL_FIND_BY_CODE = "SELECT * FROM EXPRESS WHERE CODE=?";
        //通过用户手机号查询用户所有快递
        public static final  String SQL_FIND_BY_USERPHONE = "SELECT * FROM EXPRESS WHERE USERPHONE=?";
        //通过用户手机号和状态查询用户所有快递
        public static final  String SQL_FIND_BY_USERPHONE_AND_STATUS = "SELECT * FROM EXPRESS WHERE USERPHONE=? AND STATUS=?";
        //通过录入人手机号查询快递信息
        public static final  String SQL_FIND_BY_SYSPHONE = "SELECT * FROM EXPRESS WHERE SYSPHONE=?";
        //快递录入
        public static final  String SQL_INSERT = "INSERT INTO EXPRESS (NUMBER,USERNAME,USERPHONE,COMPANY,CODE,INTIME,STATUS,SYSPHONE) VALUES(?,?,?,?,?,NOW(),0,?)";
        //快递修改
        public static final  String SQL_UPDATE= "UPDATE EXPRESS SET NUMBER=?,USERNAME=?,COMPANY=?,STATUS=? WHERE ID=?";
        //快递的状态码改变(取件)
        public static final  String SQL_UPDATE_STATUS = "UPDATE EXPRESS SET STATUS=1,OUTTIME=NOW(),CODE=NULL WHERE CODE=?";
        //快递的删除
        public static final  String SQL_DELETE = "DELETE FROM EXPRESS WHERE ID=?";


        /**
         * 用于查询数据库中的全部快递(总数+新增),待取件快递(总数+新增)
         *
         * @return [{size:总数,day:新增},{size:总数,day:新增}]
         */
        public List<List> console() {
            return  this.getJdbcTemplate().query(SQL_CONSOLE, new RowMapper<List>() {
                @Override
                public List mapRow(ResultSet resultSet, int i) throws SQLException {
                    return handlerResultConsole(resultSet);
                }
            });

       /* ArrayList<Map<String,Integer>> data = new ArrayList<>();
        //1.    获取数据库的连接
        Connection conn = DruidUtil.getConnection();
        PreparedStatement state =null;
        ResultSet resultSet = null;
        //2.    预编译SQL语句
        try {
            state = conn.prepareStatement(SQL_CONSOLE);
            //3.    填充参数(可选)
            //4.    执行SQL语句
            resultSet = state.executeQuery();
            //5.    获取执行的结果
            if (resultSet.next()){
                int data1_size = resultSet.getInt("data1_size");
                int data1_day = resultSet.getInt("data1_day");
                int data2_size = resultSet.getInt("data2_size");
                int data2_day = resultSet.getInt("data2_day");
                Map data1 = new HashMap();//集合
                data1.put("data1_size",data1_size);
                data1.put("data1_day",data1_day);
                Map data2 = new HashMap();
                data2.put("data2_size",data2_size);
                data2.put("data2_day",data2_day);
                data.add(data1);
                data.add(data2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6.    资源的释放
            DruidUtil.close(conn,state,resultSet);
        }
        return data;*/
        }
    public List<Map<String, Integer>> handlerResultConsole(ResultSet resultSet){
        ArrayList<Map<String,Integer>> data = new ArrayList<>();
        Express express = new Express();
        try {
            if (resultSet.next()){
                int data1_size = resultSet.getInt("data1_size");
                int data1_day = resultSet.getInt("data1_day");
                int data2_size = resultSet.getInt("data2_size");
                int data2_day = resultSet.getInt("data2_day");
                Map data1 = new HashMap();//集合
                data1.put("data1_size",data1_size);
                data1.put("data1_day",data1_day);
                Map data2 = new HashMap();
                data2.put("data2_size",data2_size);
                data2.put("data2_day",data2_day);
                data.add(data1);
                data.add(data2);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

        /**
         * 用于查询所有快递
         *
         * @param limit      是否分页的标记,true表示分页. false表示所有快递
         * @param offset     SQL语句的起始索引
         * @param pageNumber 页查询的数量
         * @return 快递的集合
         */
        public List<Express> findAll(boolean limit, int offset, int pageNumber) {
            List<Express> data = null;
            try {
                if (limit){
                    data = this.getJdbcTemplate().query(SQL_FIND_LIMIT, new Object[]{offset, pageNumber}, new RowMapper<Express>() {
                        @Override
                        public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                            return handlerResultFindBySysPhone(resultSet);
                        }
                    });
                }else{
                    data = this.getJdbcTemplate().query(SQL_FIND_ALL, new RowMapper<Express>() {
                        @Override
                        public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                            return handlerResultFindBySysPhone(resultSet);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return data;
        }

        /**
         * 根据快递单号,查询快递信息
         *
         * @param number 单号
         * @return 查询的快递信息, 单号不存在是返回null
         */
        public Express findByNumber(String number) {
            return this.getJdbcTemplate().queryForObject(SQL_FIND_BY_NUMBER, new Object[]{number}, new RowMapper<Express>() {
                @Override
                public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                    return handlerResultFindBySysPhone(resultSet);
                }
            });
        }

        /**
         * 根据快递取件码,查询快递所有信息
         *
         * @param code 取件码
         * @return 查询的快递信息 ,取件码不存在时返回null
         */
        public Express findBycode(String code) {
            return this.getJdbcTemplate().queryForObject(SQL_FIND_BY_CODE, new Object[]{code}, new RowMapper<Express>() {
                @Override
                public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                    return handlerResultFindBySysPhone(resultSet);
                }
            });
        }

        /**
         * 根据用户手机号码,查询所有的快递信息
         *
         * @param userPhone 手机号码
         * @return 查询的快递信息列表
         */
        public List<Express> findByUserPhone(String userPhone) {
            return this.getJdbcTemplate().query(SQL_FIND_BY_USERPHONE, new Object[]{userPhone}, new RowMapper<Express>() {
                @Override
                public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                    return handlerResultFindBySysPhone(resultSet);
                }
            });

        }

        /**
         * 根据用户手机号码,查询所有的快递信息
         *
         * @param userPhone 手机号码
         * @param status    状态码
         * @return 查询的快递信息列表
         */
        public List<Express> findByUserPhoneAndStatus(String userPhone, int status) {
            return this.getJdbcTemplate().query(SQL_FIND_BY_USERPHONE_AND_STATUS, new Object[]{userPhone,status}, new RowMapper<Express>() {
                @Override
                public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                    return handlerResultFindBySysPhone(resultSet);
                }
            });

        }

        /**
         * 根据录入人的手机号码.查询录入的所有记录
         *
         * @param sysPhone 手机号码
         * @return 查询的快递信息列表
         */
        public List<Express> findBySysPhone(String sysPhone) {

            return this.getJdbcTemplate().query(SQL_FIND_BY_SYSPHONE, new Object[]{sysPhone}, new RowMapper<Express>() {
                @Override
                public Express mapRow(ResultSet resultSet, int i) throws SQLException {
                    return handlerResultFindBySysPhone(resultSet);
                }
            });

        }

        public Express handlerResultFindBySysPhone(ResultSet resultSet){

            Express express = new Express();
            try {
                express.setId(resultSet.getInt("id"));
                express.setNumber(resultSet.getString("number"));
                express.setUsername(resultSet.getString("username"));
                express.setUserPhone(resultSet.getString("userPhone"));
                express.setCompany(resultSet.getString("company"));
                express.setCode(resultSet.getString("code"));
                express.setInTime(resultSet.getTimestamp("inTime"));
                express.setOutTime(resultSet.getTimestamp("outTime"));
                express.setStatus(resultSet.getInt("status"));
                express.setSysPhone(resultSet.getString("sysPhone"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return express;
        }
        /**
         * 快递的录入
         *INSERT INTO EXPRESS (NUMBER,USERNAME,USERPHONE,COMPANY,CODE,INTIME,STATUS,SYSPHONE) VALUES(?,?,?,?,?,NOW(),0,?)
         * @param e 要录入的跨地对象
         * @return 录入的结果, true表示成功, false表示失败
         */

        public int insert(Express e) {
            int update = this.getJdbcTemplate().update(SQL_INSERT, e.getNumber(),e.getUsername(),e.getUserPhone(),e.getCompany(),e.getCode(),e.getInTime(),e.getStatus(),e.getSysPhone());
            return update;
        }

        /**
         * 快递的修改
         * UPDATE EXPRESS SET NUMBER=?,USERNAME=?,COMPANY=?,STATUS=? WHERE ID=?
         *          要修改的快递id
         * @param newExpress 新的快递对象(number,company,username,userPhone)
         * @return
         */
        public int update(Express newExpress) {
            int update = this.getJdbcTemplate().update(SQL_UPDATE, newExpress.getNumber(),newExpress.getUsername(),newExpress.getCompany(),newExpress.getStatus(),newExpress.getId());
            return update;

        }

        /**
         * 更改快递的状态为1,表示取件完成
         *
         * @param code 要修改的快递取件码
         * @return 修改的结果, true表示成功, false表示失败
         */

        public int updateStatus(String code) {
            int update = this.getJdbcTemplate().update(SQL_UPDATE_STATUS, code);
            return update;
        }

        /**
         * 根据id，删除单个快递信息
         *
         * @param id 要删除的快递id
         * @return 删除的结果，true表示成功，false表示失败
         */

        public int delete(int id) {
            int del = this.getJdbcTemplate().update(SQL_DELETE, id);
            return del;
        }
    }

