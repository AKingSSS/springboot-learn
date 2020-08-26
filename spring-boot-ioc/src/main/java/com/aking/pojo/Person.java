package com.aking.pojo;

/**
 * @ClassName Person
 * @Description
 * @Author yk
 * @Date 2020/7/16 10:50
 * @Version 1.0
 **/
public class Person {
    private  String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
