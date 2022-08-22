package com.nxg.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author nxg
 * date 2022/7/28
 * @apiNote 全局异常处理
 */
@ControllerAdvice
public class GlobalException {

    //异常处理
   /* @ExceptionHandler(Exception.class)
    public String error(){
        System.out.println("error----------");
        return "error";
    }*/
}
