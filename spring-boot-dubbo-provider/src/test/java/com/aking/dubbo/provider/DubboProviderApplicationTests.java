package com.aking.dubbo.provider;

import com.aking.dubbo.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DubboProviderApplication.class})// 指定启动类
@Slf4j
public class DubboProviderApplicationTests {
    @Reference(version = "${dubbo.service.version}",group = "${dubbo.provider.group}")
    private HelloService helloService;

    @Test
    public void sayHello() {
        String s = helloService.sayHello("Python大星");
        log.info("s = {}", s);
    }

}
