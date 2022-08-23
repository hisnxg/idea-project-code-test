package com.xzk.controller;

import com.github.pagehelper.PageInfo;
import com.xzk.pojo.Team;
import com.xzk.service.TeamService;
import com.xzk.vo.QueryVO;
import com.xzk.vo.ResultVO;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 球队的控制器层
 */
@Controller
@RequestMapping("team.do")
@ResponseBody
public class TeamController {
    @Resource   //自动注入
    //@Autowired
    private TeamService teamService;

    /**
     * 如果实体类中的日期类型需要从页面获取数据，避免NULL转换为Date类型出问题
     * 解决方案1：@InitBinder
     * 解决方案2：实体类的日期类型属性上添加注解@DateTimeFormat(pattern = "yyyy-MM-dd")
     * @param binder
     */
    @InitBinder
    protected void initDateFormatBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
    /**
     * 多条件分页查询
     * @param pageNum
     * @param pageSize
     * @param vo
     * @return
     */
    //  /team/list.do
    @RequestMapping(value = "list.do",method = {RequestMethod.GET})
    //@RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultVO<Team> queryByPage(Integer pageNum, Integer pageSize, QueryVO vo){
        if(pageNum==null || pageNum <=0){
            pageNum=1;
        }
        if (pageSize==null || pageSize<=0){
            pageSize=5;
        }
        PageInfo<Team> teamPageInfo = teamService.queryBypage(pageNum, pageSize, vo);
        return new ResultVO<>(teamPageInfo);
    }

    /**
     * 添加一个球队
     * @param team
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResultVO<Team> addTeam(Team team){
        System.out.println(team);
        int i = teamService.addTeam(team);
        if (i == 1){
            return new ResultVO<Team>();
        }
        return  new ResultVO<Team>(500,"添加失败，服务器内部异常，请稍后再试！");
    }

    /**
     * 根据主键查询
     * @param teamId
     * @return
     * @PathVariable 根据路径
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResultVO<Team> queryById(@PathVariable("id") Integer teamId){
        Team team = teamService.queryById(teamId);
        return new ResultVO<>(team);
    }

    /**
     * 根据主键动态更新 球队信息
     * @param teamId
     * @param team
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResultVO<Team> updateTeam(@PathVariable("id")Integer teamId,Team team){
        System.out.println("updateTeam-------------team"+team);
        team.setTeamId(teamId);
        int i = teamService.updateTeam(team);
        if (i == 1){
            return new ResultVO<>();
        }
        return new ResultVO<>(500,"添加失败，服务器内部异常，请稍后再试！");
    }

    /**
     * 根据主键删除信息
     * @param teamId
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResultVO<Team> deleteTeam(@PathVariable("id")Integer teamId){
        int i = teamService.deleteTeam(teamId);
        if (i == 1){
            return new ResultVO<>();
        }
        return new ResultVO<>(500,"添加失败，服务器内部异常，请稍后再试！");
    }
}
