package com.cartisan.spittr.spittle.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2016/10/12.
 */
@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle(){
        return "error/duplicate";
    }
}
