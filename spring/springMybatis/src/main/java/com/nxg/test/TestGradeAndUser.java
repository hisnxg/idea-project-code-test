package com.nxg.test;

import com.nxg.bean.Grade;
import com.nxg.bean.User;
import com.nxg.dao.GradeDao;
import com.nxg.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author nxg
 * date 2022/8/5 08 23
 * @apiNote  一对多
 */
public class TestGradeAndUser {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        GradeDao mapper = sqlSession.getMapper(GradeDao.class);
/*      //一对多
        Grade grade = mapper.findByGId(2);
        System.out.println(grade.getgName());
        List<User> userList = grade.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }*/
        //多对一
        List<User> allUser = mapper.findAllUser();
        for (User user : allUser) {
            System.out.println(user+",年级信息："+user.getGrade().getgName());
        }
        SqlSessionUtil.closeSqlSession();
    }
}
