package com.xzk.exceptions;

import java.security.PrivilegedActionException;

/**
 * 自定义的异常类
 */
public class TeamException extends Exception {
    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }

}
