package com.aking.swagger.controller;

import com.aking.swagger.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Description
 * @Author yk
 * @Date 2020/5/7 15:44
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/apis/user")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
public class HelloController {

    /**
     *
     * 查找用户信息
     * @return
     */
    @PostMapping(value = "/getUserInfo.do")
    @ApiOperation(value = "查找用户信息（DONE）")
    public String getUserInfo(@RequestBody User user) {
        log.info("getUserInfo >>>");
        String msg = String.format("用户名：%s; 年龄：%d",
                user.getName(), user.getAge());
        return msg;
    }
}
