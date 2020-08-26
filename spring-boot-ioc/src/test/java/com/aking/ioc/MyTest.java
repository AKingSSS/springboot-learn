package com.aking.ioc;

import com.aking.pojo.Person;
import org.junit.Test;

/**
 * @ClassName MyTest
 * @Description
 * @Author yk
 * @Date 2020/7/16 10:53
 * @Version 1.0
 **/
public class MyTest {
    @Test
    public void myTest() {
        Person person = new Person();
        person.setName("Python大星");
        person.setAge(100);
        System.out.println(person);
    }
}
