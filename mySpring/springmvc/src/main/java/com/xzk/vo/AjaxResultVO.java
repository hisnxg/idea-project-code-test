package com.xzk.vo;

import java.util.List;

/**
 * 自己封装响应结果
 * 封装的实体类
 * @param <T>
 */
public class AjaxResultVO<T> {
    private Integer code;//返回的状态码
    private String msg;//返回的信息（一般错误的信息或者异常的信息）
    private List<T> list; //返回的数据有可能是集合
    private T obj;//返回的数据有可能是对象

    public AjaxResultVO() {
        code = 200;
        msg = "OK";
        list = null;
        obj = null;
    }

    public AjaxResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public AjaxResultVO(Integer code, String msg, List<T> list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }
    public AjaxResultVO(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
