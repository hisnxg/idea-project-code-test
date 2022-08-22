package com.nxg.bean;

import java.util.List;

/**
 * @author nxg
 * date 2022/8/5 08 07
 * @apiNote 一方
 */
public class Grade {
    private int gId;
    private String gName;
    //一对多，  一方中有多方的集合信息
    private List<User> userList;

    public Grade() {
    }

    public Grade(int gId, String gName, List<User> userList) {
        this.gId = gId;
        this.gName = gName;
        this.userList = userList;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
