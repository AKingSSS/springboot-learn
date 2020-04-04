package com.aking.token.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description HttpSession 测试
 * @Author yangkang
 * @Date 2020/4/4 16:03
 * @Version 1.0
 **/
@RestController
@RequestMapping("/session")
public class LoginSessionController {

    /**
     * 模拟登录
     * @param session
     * @param username
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam("username") String username) {
        session.setAttribute("username",username);
        return "success";
    }

    /**
     * 购买
     * @param session
     * @return
     */
    @RequestMapping("/buy")
    public String buy(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "username is " + username;
    }
}
