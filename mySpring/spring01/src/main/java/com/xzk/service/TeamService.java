package com.xzk.service;

import com.xzk.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**该注解常用于service层
 * @Service
 */
@Service("teamService")
public class TeamService {
    //@Autowired(required = true)默认为true
    @Autowired //自动装配   默认按照类型装配
    @Qualifier("teamDao1") //按照名称自动装配 需要@Qualifier搭配使用
    private TeamDao teamDao;// =new TeamDao();
    public void add(){
        teamDao.add();
        System.out.println("TeamService---add--");
    }

    //有参构造方法
    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public TeamService() {
        System.out.println("TeamService--默认的构造方法");
    }

    public TeamDao getTeamDao() {
        return teamDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
}
