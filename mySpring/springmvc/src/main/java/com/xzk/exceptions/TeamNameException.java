package com.xzk.exceptions;

/**
 * 自定义的异常类
 */
public class TeamNameException extends TeamException {
    public TeamNameException() {
    }

    public TeamNameException(String message) {
        super(message);
    }
}
