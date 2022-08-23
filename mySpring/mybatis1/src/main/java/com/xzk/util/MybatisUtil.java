package com.xzk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 连接操作的工具类
 * 工具类:获取连接和关闭连接
 */
public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 加载配置文件
     */
    static{
        Reader reader = null;
        try {
            //1.    读取mybatis的配置文件
             reader = Resources.getResourceAsReader("mybatis.xml");

        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
        //2.    创建SqlSessionFactory对象,目的是获取sqlSession --根据图纸创建工厂
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * 获取SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        //从当前线程获取
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null){
            //3.    创建可以执行SQL语句的sqlsession--工厂创建产品
            sqlSession = sqlSessionFactory.openSession();
            //将sqlSession与当前线程绑定
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭 SqlSession
     */
    public static void closeSqlSession(){
        //从当前线程获取
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null){
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
