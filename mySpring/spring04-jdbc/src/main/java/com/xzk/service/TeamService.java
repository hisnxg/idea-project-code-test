package com.xzk.service;

import com.xzk.pojo.Team;
import com.xzk.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TeamService {

    @Autowired
    private TeamDao teamDao;

    /**
     * Transactional 关于 事务的注解
     * @param team
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int insert(Team team){
        int num1 = teamDao.insert(team);
        System.out.println("第一条执行结果:num1="+num1);
        //System.out.println(10/0);
        int num2 = teamDao.insert(team);
        System.out.println("第二条执行结果:num2="+num2);
        return num1+num2;
    }
}
