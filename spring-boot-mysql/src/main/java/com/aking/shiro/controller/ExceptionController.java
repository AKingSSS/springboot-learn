package com.aking.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @ClassName ExceptionController
 * @Description 统一的异常类进行处理(把默认的异常返回信息改成自定义的异常返回信息
 * @Author aking
 * @Date 2020/5/15 00:29
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(value = ValidationException.class)
    public void defaultExceptionHandler(HttpServletRequest req, HttpSession session, ValidationException e) {
        //根据抓获的异常类型，做逻辑处理，并打印日志信息
        if (e instanceof ConstraintViolationException) {
            log.error("msg = {}", e);
        }
    }
}
