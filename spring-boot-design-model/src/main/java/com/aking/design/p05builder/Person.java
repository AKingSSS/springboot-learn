package com.aking.design.p05builder;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Person
 * @Description
 * @Author yk
 * @Date 2020/9/1 10:17
 * @Version 1.0
 **/
@Getter
@Setter
@Builder
public class Person {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        Person person = Person.builder().name("Python大星").age(10).build();
    }
}
