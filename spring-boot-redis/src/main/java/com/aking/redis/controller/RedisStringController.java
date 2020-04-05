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
@RequestMapping("string")
public class RedisStringController {
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
        Object obj = redisUtil.get(key);
        if (obj == null) {
            return "缓存为空";
        } else {
            return redisUtil.get(key);
        }
    }

    /**
     * 指定缓存失效时间
     * @param key
     * @return
     */
    @RequestMapping("expire.do")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

    /**
     * 指定缓存失效时间
     * @param key
     * @return
     */
    @RequestMapping("getExpire.do")
    public long getExpire(String key){
        return redisUtil.getExpire(key);
    }

    /**
     * 判断 key是否存在
     * @param key
     * @return
     */
    @RequestMapping("hasKey.do")
    public boolean hasKey(String key){
        return redisUtil.hasKey(key);
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    @RequestMapping("del.do")
    public String del(String key){
        try {
            redisUtil.del(key);
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }
    }
}
