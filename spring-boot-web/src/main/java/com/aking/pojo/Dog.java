package com.aking.pojo;

/**
 * @ClassName Dog
 * @Description
 * @Author yangkang
 * @Date 2020/4/2 21:59
 * @Version 1.0
 **/
public class Dog {
    private String name;
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
