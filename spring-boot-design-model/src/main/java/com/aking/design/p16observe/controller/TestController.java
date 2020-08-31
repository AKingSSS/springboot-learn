package com.aking.design.p16observe.controller;

import com.aking.design.p16observe.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestControllere
 * @Description
 * @Author yk
 * @Date 2020/8/31 18:07
 * @Version 1.0
 **/
@RestController
@Slf4j
public class TestController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/saveOrder")
    public void saveOrder() {
        orderService.saveOrder();
    }
}
