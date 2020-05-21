package com.aking.token.advice;

import com.aking.token.enums.ResponseEnums;
import com.aking.token.exception.NoLoginException;
import com.aking.token.util.APIResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AllExceptionHandler
 * @Description
 * @Author yk
 * @Date 2020/5/19 15:59
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class AllExceptionHandler {

    /**
     * 指定拦截异常的类型
     *
     * @param e
     * @return
     */
    @ExceptionHandler({NoLoginException.class})
    @ResponseBody
    public APIResult customExceptionHandler(Exception e) {
        log.info("全局异常捕获: {}", e);
        // 未登录
        if (e instanceof NoLoginException) {
            return APIResult.newFailResult(ResponseEnums.NO_LOGIN.code, ResponseEnums.NO_LOGIN.desc);
        }
        return APIResult.badRequest();
    }
}
