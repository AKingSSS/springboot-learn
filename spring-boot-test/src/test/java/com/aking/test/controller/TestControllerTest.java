package com.aking.test.controller;

import com.aking.test.TestApplication;
import com.aking.test.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestControllerTest {
   @Autowired
   private HelloService helloService;

    @Test
    public void testSayHello()   {
        Boolean b = helloService.sayHello("Python 大星");
        Assert.assertTrue(b);
    }

    @Test
    public void testSayHello2()   {
        Boolean b = helloService.sayHello("Python 小星");
        Assert.assertTrue(b);
    }
}