package com.xzk.exceptions;

/**
 * 自定义的异常类
 */
public class TeamIdException  extends TeamException{

    public TeamIdException() {
    }

    public TeamIdException(String message) {
        super(message);
    }
}
