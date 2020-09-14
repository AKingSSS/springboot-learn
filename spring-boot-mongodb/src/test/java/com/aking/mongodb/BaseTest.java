package com.aking.mongodb;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@ClassName BaseTest
 *@Description
 *@Author yk
 *@Date 2020/9/14 17:51
 *@Version 1.0
 **/
@SpringBootTest(classes = MongodbApplication.class)
@Slf4j
@RunWith(SpringRunner.class)
public class BaseTest {
}
