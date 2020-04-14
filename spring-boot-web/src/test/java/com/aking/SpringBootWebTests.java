package com.aking;

import com.aking.pojo.Girl;
import com.aking.pojo.Person;
import com.aking.pojo.Son;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName SpringBootWebTests
 * @Description 单元测试 可以自动注入
 *
 * @Author yangkang
 * @Date 2020/4/2 22:15
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebTests {
    @Autowired
    private Person person;
    @Autowired
    private Son son;
    @Autowired
    private Girl girl;
    @Autowired
    private ApplicationContext ioc;

    @Test
    public void contextLoads() {
/*        System.out.println(person);
        System.out.println(son);*/
        System.out.println(girl);
    }

    @Test
    public void contextLoads2() {
        // 判断 ioc 容器中是否有这个Bean
        System.out.println(ioc.containsBean("helloService"));
    }

}
