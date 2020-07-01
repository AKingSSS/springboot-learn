package com.aking.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ValidController
 * @Description TODO
 * @Author aking
 * @Date 2020/5/14 23:24
 * @Version 1.0
 **/
@RestController
@Slf4j
@Validated
public class ValidController {
    /**
     * 登录
     * @return
     */
    @GetMapping("/userLogin.do")
    public String login(@NotNull(message = "username 不能为空") String username,
                        @Length(min = 6, message = "密码至少 6 位") String password, HttpSession session) {
        // 获得当前的方法名
        String thisMethodName = new Exception().getStackTrace()[0].getMethodName();
        // 获得当前的方法名
        String thisClassName = new Exception().getStackTrace()[0].getClassName();
        session.setAttribute("errorSource","方法名称->"+thisMethodName+"   |  "+"控制器名称->"+thisClassName);
        return "username: " + username + " ,age:" + password;
    }
}
