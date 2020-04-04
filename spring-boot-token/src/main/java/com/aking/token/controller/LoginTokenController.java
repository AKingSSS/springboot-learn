package com.aking.token.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.aking.token.annotations.CAuth;
import com.aking.token.context.SessionContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName LoginTokenController
 * @Description
 * @Author yangkang
 * @Date 2020/4/4 16:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("/token")
public class LoginTokenController {
    /**
     * 模拟登录，生成 token，前端保存到 header中
     * token 里加密用户 id
     *
     * @param username
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username) {
        String token = SecureUtil.md5(username + "aKing" + DateUtil.formatLocalDateTime(LocalDateTime.now()));
        return token;
    }

    /**
     * 购买
     *
     * @return
     */
    @CAuth
    @RequestMapping("/buy")
    public String buy() {
        String name = SessionContext.getName();
        return name;
    }


}
