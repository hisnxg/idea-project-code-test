package com.xzk;

import com.xzk.mapper.GameRecordMapper;
import com.xzk.pojo.GameRecord;
import com.xzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 测试类
 */
public class GameRecoredDaoTest {
   private SqlSession sqlSession = MybatisUtil.getSqlSession();

   @Test
    public void testInsert(){
       GameRecordMapper mapper = sqlSession.getMapper(GameRecordMapper.class);
       GameRecord recored = new GameRecord();
       recored.setHomeTeamId(1007);
       recored.setVisitingTeamId(1002);
       recored.setScore(91);
       int i = mapper.add(recored);
       sqlSession.commit();
       System.out.println(i);
       System.out.println(recored.getRecordId());
   }
}
