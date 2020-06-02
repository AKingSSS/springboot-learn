package com.aking.unit.service.impl;

import com.aking.unit.service.AService;
import com.aking.unit.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName BServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/6/2 14:51
 * @Version 1.0
 **/
@Service
@Slf4j
public class BServiceImpl implements BService {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public Integer multiply(Integer a, Integer b) {
        log.info("a = [{}],b = [{}]", a, b);
        return a * b;
    }
}
