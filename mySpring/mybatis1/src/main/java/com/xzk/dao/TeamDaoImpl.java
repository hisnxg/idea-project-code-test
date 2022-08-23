package com.xzk.dao;

import com.xzk.pojo.Team1;
import com.xzk.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 *Team的数据访问层
 */
public class TeamDaoImpl implements TeamDao {

    /**
     * 查询所有球队
     * @return
     */
    @Override
    public List<Team1> queryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Team1> team1List = sqlSession.selectList("com.xzk.pojo.Team1.queryAll");
        return team1List;
    }

    /**
     * 根据id查询单个球队
     * @param teamId
     * @return
     */
    @Override
    public Team1 queryById(Integer teamId) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Team1 team1 = sqlSession.selectOne("com.xzk.pojo.Team1.queryById",teamId);
        return team1;
    }

    /**
     * 添加球队
     * @param team1
     * @return
     */
    @Override
    public int TeamAdd(Team1 team1) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int num = sqlSession.insert("com.xzk.pojo.Team1.add",team1);
        sqlSession.commit();//必须提交才能让增删改生效
        return num;
    }

    /**
     * 更新球队信息
     * @param team1
     * @return
     */
    @Override
    public int TeamUpdate(Team1 team1) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int num = sqlSession.update("com.xzk.pojo.Team1.update", team1);
        sqlSession.commit();//必须提交才能让增删改生效
        return num;
    }

    /**
     * 根据Id删除球队
     * @param teamId
     * @return
     */
    @Override
    public int TeamDelete(Integer teamId) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int num = sqlSession.delete("com.xzk.pojo.Team1.del", teamId);
        sqlSession.commit();//必须提交才能让增删改生效
        return num;
    }
}
