package com.aking.zookeeper.api;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.stereotype.Component;

/**
 * @ClassName WatcherApi
 * @Description
 * @Author yangkang
 * @Date 2020/4/14 10:10
 * @Version 1.0
 **/
@Component
public class WatcherApi implements Watcher {
    private static final Logger logger = LoggerFactory.getLogger(WatcherApi.class);

    @Override
    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】= " + event.getState());
        logger.info("【监听路径为】= " + event.getPath());
        //  三种监听类型： 创建，删除，更新
        logger.info("【监听的类型为】= " +event.getType());
    }
}
