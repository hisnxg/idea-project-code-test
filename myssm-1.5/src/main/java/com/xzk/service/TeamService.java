package com.xzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzk.vo.QueryVO;
import com.xzk.mapper.TeamMapper;
import com.xzk.pojo.Team;
import com.xzk.pojo.TeamExample;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * 球队的  业务逻辑层
 */
@Service
public class TeamService {
    @Resource
    private TeamMapper teamMapper;

    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     * readOnly只读
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public PageInfo<Team> queryBypage(Integer pageNum, Integer pageSize, QueryVO vo){
        //多条件
        TeamExample example = new TeamExample();
        //创建条件的容器
        TeamExample.Criteria criteria = example.createCriteria();
        if(vo!=null){//trim()去除前后空格
            if (vo.getTeamName()!=null && !"".equals(vo.getTeamName().trim())){
                criteria.andTeamNameLike("%"+vo.getTeamName().trim()+"%");
            }
            if (vo.getChineseName()!=null && "".equals(vo.getChineseName().trim())){
                criteria.andChineseNameLike("%"+vo.getChineseName().trim()+"%");
            }
            if (vo.getCoach()!=null && "".equals(vo.getCoach().trim())){
                criteria.andCoachLike("%"+vo.getCoach().trim()+"%");
            }
            if (vo.getBeginDate()!=null){
                criteria.andCreateTimeGreaterThanOrEqualTo(vo.getBeginDate());
            }
            if (vo.getEndDate()!=null){
                criteria.andCreateTimeLessThanOrEqualTo(vo.getEndDate());
            }
            if (vo.getArea()!=null && vo.getArea()!=-1){
                criteria.andAreaEqualTo(vo.getArea());
            }
        }
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Team> list = teamMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    /**
     * 添加一个球队
     * @param team
     * @return
     * Transactional事务 ，如果有异常还需要rollbackFor回滚
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int addTeam(Team team){
        return teamMapper.insertSelective(team);
    }

    /**
     * 根据主键查询
     * @param teamId
     * @return
     */
    @Transactional(propagation =Propagation.REQUIRED,readOnly=true)
    public Team queryById(Integer teamId){
        return teamMapper.selectByPrimaryKey(teamId);
    }

    /**
     * 根据主键更新球队信息
     * @param team
     * @return
     * updateByPrimaryKeySelective 动态更新
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int updateTeam(Team team){
        return teamMapper.updateByPrimaryKeySelective(team);
    }

    /**
     * 根据主键删除球队信息
     * @param teamId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int deleteTeam(int teamId){
        Team team = teamMapper.selectByPrimaryKey(teamId);
        team.setIsDel(1);//将删除的标识为1
        return teamMapper.updateByPrimaryKey(team);
    }
}
