package com.nxg.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author nxg
 * date 2022/8/4 08 22
 * @apiNote
 */
public class SqlSessionUtil {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static  SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            //将sqlSession与当前线程绑定
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession!=null){
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
