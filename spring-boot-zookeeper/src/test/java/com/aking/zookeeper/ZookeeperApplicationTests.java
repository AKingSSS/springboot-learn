package com.aking.zookeeper;

import com.aking.zookeeper.api.ZkApi;
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
    public void contextLoads() {
        zkApi.createNode("/node1","node1");
    }

}
