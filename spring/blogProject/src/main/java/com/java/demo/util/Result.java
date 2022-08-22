package com.java.demo.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private String code;
    private String msg;
    private Object data;
    public static  Result success(Object data){
        Result res = new Result();
        res.setCode("200");
        res.setData(data);
        res.setMsg("操作成功");
        return res;
    }
    public static  Result success(String message,Object data){
        Result res = new Result();
        res.setCode("200");
        res.setData(data);
        res.setMsg(message);
        return res;
    }
    public static  Result fail(String message){
        Result res = new Result();
        res.setCode("400");
        res.setData(null);
        res.setMsg(message);
        return res;
    }
    public static  Result fail(String message,Object data){
        Result res = new Result();
        res.setCode("400");
        res.setData(data);
        res.setMsg(message);
        return res;
    }
}
