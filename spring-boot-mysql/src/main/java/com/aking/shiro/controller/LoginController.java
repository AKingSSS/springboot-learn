package com.aking.shiro.controller;

import com.aking.domain.Customer;
import com.aking.domain.CustomerList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName LoginController
 * @Description
 * @Author yk
 * @Date 2020/5/14 15:40
 * @Version 1.0
 **/
@RestController
@Slf4j
public class LoginController {

    /**
     * 登录
     * @param customer
     * @param bindingResult
     * @return
     */
    @PostMapping("/login.do")
    public String login(@RequestBody @Validated Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "success";
    }

    /**
     * 注册
     * @param customer
     * @param bindingResult
     * @return
     */
    @PostMapping("/register.do")
    public String register(@RequestBody @Validated(value = { Customer.UserRegisterValidView.class, Default.class})
                                       Customer customer,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().stream().
                    map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
            return message;
        }
        return "success";
    }

    /**
     * 登录
     * @param customers
     * @param bindingResult
     * @return
     */
    @PostMapping("/login2.do")
    public String login2(@RequestBody @Validated List<Customer> customers, BindingResult bindingResult) {
        /**
         * @Validated 无法校验，不生效
         *
         */
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "success";
    }

    /**
     * 登录
     * @param customers
     * @param bindingResult
     * @return
     */
    @PostMapping("/login3.do")
    public String login3(@RequestBody @Validated CustomerList customers, BindingResult bindingResult) {
        /**
         * @Validated 可以校验
         *
         */
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "success";
    }


}
