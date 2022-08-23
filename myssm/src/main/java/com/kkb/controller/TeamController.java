package com.kkb.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Team;
import com.kkb.service.TeamService;
import com.kkb.vo.QueryVO;
import com.kkb.vo.ResultVO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * ClassName: TeamController
 * 球队的控制器层
 * @author wanglina
 * @version 1.0
 */
@Controller
@RequestMapping("team")
@ResponseBody
public class TeamController {
    @Resource
    private TeamService teamService;

    //如果实体类中的日期类型需要从页面获取数据，避免NULL转换为Date类型出问题
    //解决方案1：@InitBinder
    //解决方案2：实体类的日期类型属性上添加注解@DateTimeFormat(pattern = "yyyy-MM-dd")
    @InitBinder
    protected void initDateFormatBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //多条件分页查询
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultVO<Team> queryByPage(Integer pageNum, Integer pageSize, QueryVO vo){
        if(pageNum==null || pageNum<=0){
            pageNum=1;
        }
        if(pageSize==null || pageSize<=0){
            pageSize=5;
        }
        PageInfo<Team> teamPageInfo = teamService.queryByPage(pageNum, pageSize, vo);
        return new ResultVO<>(teamPageInfo);
    }
    //添加一个球队
    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResultVO<Team> addTeam(Team team){
        System.out.println(team);
        int i = teamService.addTeam(team);
        if(i==1){
            return new ResultVO<Team>();
        }
        return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
    }
    //根据主键查询
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResultVO<Team> queryById(@PathVariable("id") Integer teamId){
        Team team = teamService.queryById(teamId);
        return new ResultVO<>(team);
    }
    //根据主键更新
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResultVO<Team> updateTeam(@PathVariable("id") Integer teamId,Team team){
        System.out.println("updateTeam--team-------------"+team);
        team.setTeamId(teamId);
        int i = teamService.updateTeam(team);
        if(i==1){
            return new ResultVO<Team>();
        }
        return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
    }
    //根据主键删除
    @RequestMapping(value ="{id}",method = RequestMethod.DELETE)
    public ResultVO<Team> deleteTeam(@PathVariable("id") Integer teamId){
        int i = teamService.deleteTeam(teamId);
        if(i==1){
            return new ResultVO<Team>();
        }
        return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
    }
    //文件上传
    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public ResultVO<Team> uploadLogo(@RequestParam("logo")MultipartFile myFile, HttpServletRequest request,
                                     @PathVariable("id") Integer teamId){
        //文件上传到指定服务器位置
        String path=request.getServletContext().getRealPath("/img/uploadFile/");
        //获取原始文件的名称
        String originalFilename = myFile.getOriginalFilename();
        //定义文件的新名词：随机生成的名称+原有文件的后缀名
        String randomName=UUID.randomUUID().toString().replace("-","");
        int index=originalFilename.lastIndexOf(".");
        String hz=originalFilename.substring(index);
        String logoName=randomName+hz;
        int num=0;
        try {
            myFile.transferTo(new File(path+"/"+logoName));
            System.out.println("上传成功！"+path+"/"+logoName);
            //将图片的名称更新到数据库中
            Team team=new Team();
            team.setTeamId(teamId);
            team.setTeamLogo(logoName);
            num=teamService.updateTeam(team);
            if(num==1){
                return new ResultVO<Team>();
            }else{
                return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultVO<>(500,"图片上传出现问题！"+e.getMessage());
        }

    }
}
