package com.aking.token.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.aking.token.annotations.Auth;
import com.aking.token.annotations.CurrentUser;
import com.aking.token.context.SessionContext;
import com.aking.token.dto.AuthSessionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class LoginTokenController {
    /**
     * 模拟登录，生成 token，前端保存到 header中
     *
     * @param mobile
     * @return
     */
    @PostMapping("/login.do")
    public String login(@RequestParam("username") String mobile, @RequestParam("password") String password) {
        String token = SecureUtil.md5(mobile + "Python大星" + DateUtil.formatLocalDateTime(LocalDateTime.now()));
        log.info("将 token = {}， 对应的用户信息保存到 Redis 中", token);
        return token;
    }

    /**
     * 购买
     *
     * @return
     */
    @Auth(requireLogin = true)
    @PostMapping("/buy.do")
    public String buy() {
        String name = SessionContext.getName();
        // 购买业务 省略......
        return "恭喜" + name + "下单成功";
    }

    /**
     * 保存用户信息
     *
     * @return
     */
    @Auth(requireLogin = true)
    @GetMapping("/saveInfo.do")
    public String saveInfo(@CurrentUser AuthSessionDTO authSessionDTO) {
        String mobile = authSessionDTO.getMobile();
        return mobile;
    }
}
