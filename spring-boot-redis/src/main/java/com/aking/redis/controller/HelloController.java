package com.aking.redis.controller;

import com.aking.redis.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HelloController
 * @Description
 * @Author yangkang
 * @Date 2020/4/5 17:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("redis")
public class HelloController {
    @Resource
    private RedisUtil redisUtil;

    /**
     * redis中存储的过期时间60s
     */
    private static int ExpireTime = 60;

    /**
     * 设置缓存
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("set.do")
    public boolean redisSet(String key, String value){

        return redisUtil.set(key,value);
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    @RequestMapping("get.do")
    public Object redisGet(String key){
        return redisUtil.get(key);
    }

    /**
     * 设置过期时间
     * @param key
     * @return
     */
    @RequestMapping("expire.do")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
}
