package com.xzk;

import com.xzk.mapper.UserMapper;
import com.xzk.pojo.Users;
import com.xzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    private SqlSession sqlSession = MybatisUtil.getSqlSession();

    @Test
    public void test01(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users users = mapper.queryById(1);
        System.out.println(users);
    }
    @Test
    public void test02(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users users = mapper.queryById2(1);
        System.out.println(users);
    }
}
