package com.aking.shiro.controller;

import com.aking.pojo.DateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName DateController
 * @Description
 * @Author yk
 * @Date 2020/7/1 10:13
 * @Version 1.0
 **/
@RestController
@RequestMapping("/date")
@Slf4j
public class DateController {

    /**
     * 测试
     *
     * @param vo
     * @return
     */
    @GetMapping("/test.do")
    public DateVO getDate(DateVO vo) {
        // 入参参数
        log.info("入参参数：[{}]", vo.getPayTime());
        return vo;
    }

    /**
     * 测试
     *
     * @param vo
     * @return
     */
    @PostMapping("/test2.do")
    public DateVO getDate2(@RequestBody DateVO vo) {
        // 入参参数
        log.info("入参参数：[{}]", vo.getPayTime());
        return vo;
    }
}
