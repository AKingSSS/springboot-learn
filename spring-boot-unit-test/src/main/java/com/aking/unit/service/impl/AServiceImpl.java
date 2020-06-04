package com.aking.unit.service.impl;

import com.aking.unit.service.AService;
import com.aking.unit.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @ClassName AServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/6/2 14:51
 * @Version 1.0
 **/
@Service
@Slf4j
public class AServiceImpl implements AService {
    private BService bService;

    @Autowired
    public void setbService(BService bService) {
        this.bService = bService;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    @Override
    public Integer add(Integer a, Integer b) {
        log.info("a = [{}],b = [{}]", a, b);
        bService.multiply(a , b);
        return a + b;
    }
}
