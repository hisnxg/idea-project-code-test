package com.nxg.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxg.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author nxg
 * date 2022/7/31
 * @apiNote
 */
public class TestPageHelper1_3 {
    public static void main(String[] args) {
        try {
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(reader,"m1");
            //3.得到sqlSession
            SqlSession sqlSession = build.openSession();

            //4.操作sql
            //4.1 指定分页参数
            PageHelper.startPage(3,5);
            //4.2 调用dao层    方法参数是被调取的sql的完整路径=namespace+id
            List<User> list = sqlSession.selectList("com.nxg.dao.UserDao3.getAll");
            //4.3 创建分页工具类对象
            PageInfo<User> pageInfo = new PageInfo<User>(list);

            //5.遍历 从分页数据中得到数据
            for (User user : pageInfo.getList()) {
                System.out.println(user);
            }
            System.out.println("当前页条数："+pageInfo.getSize());
            System.out.println("总条数："+pageInfo.getTotal());
            System.out.println("总页数："+pageInfo.getPages());
            System.out.println("上一页："+pageInfo.getPrePage());//如果没有上一页，则返回0
            System.out.println("下一页："+pageInfo.getNextPage());
            System.out.println("当前页："+pageInfo.getPageNum());
            System.out.println("显示条数："+pageInfo.getPageSize());


            //6.关闭资源
            sqlSession.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
