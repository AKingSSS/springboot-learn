package com.aking.token.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description HttpServletRequest 测试
 * @Author yangkang
 * @Date 2020/4/4 16:03
 * @Version 1.0
 **/
@RestController
@RequestMapping("/request")
public class LoginRequestController {

    /**
     * 模拟登录
     * @param request
     * @param username
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("username") String username) {
        request.setAttribute("username",username);
        return "success";
    }

    /**
     * 购买
     * @param request
     * @return
     */
    @RequestMapping("/buy")
    public String buy(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return "username is " + username;
    }
}
