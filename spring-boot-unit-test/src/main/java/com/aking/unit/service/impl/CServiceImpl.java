package com.aking.unit.service.impl;

import com.aking.unit.service.CService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName CService
 * @Description
 * @Author yk
 * @Date 2020/6/2 14:50
 * @Version 1.0
 **/
@Service
@Slf4j
public class CServiceImpl implements CService {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public Integer subtract(Integer a, Integer b) {
        log.info("a = [{}],b = [{}]", a, b);
        return a * b;
    }
}
