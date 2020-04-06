package com.aking.dubbo.provider;

import com.aking.dubbo.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboProviderApplicationTests {
    @Reference(version = "${dubbo.service.version}")
    private HelloService helloService;

    @Test
    public void sayHello() {
        String s = helloService.sayHello("Python大星");
        System.out.println(s);
    }

}
