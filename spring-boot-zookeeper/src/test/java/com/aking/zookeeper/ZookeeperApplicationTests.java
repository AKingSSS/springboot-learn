package com.aking.zookeeper;

import com.aking.zookeeper.api.ZkApi;
import com.aking.zookeeper.watcher.ZkWatcher;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperApplicationTests {
    @Autowired
    private ZkApi zkApi;


    @Test
    public void contextLoads() throws KeeperException, InterruptedException {
/*       zkApi.exists("/watcher" ,true);
       Thread.sleep(50000);*/

/*        zkApi.exists("/watcher",new ZkWatcher());
        Thread.sleep(50000);*/

        String data = zkApi.getData("/watcher", new ZkWatcher());
        System.out.println("data = " + data);
        Thread.sleep(50000);

    }

}
