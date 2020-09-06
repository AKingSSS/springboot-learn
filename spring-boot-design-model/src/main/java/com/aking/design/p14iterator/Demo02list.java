package com.aking.design.p14iterator;

import java.util.*;

/**
 * @ClassName Demo01
 * @Description
 * @Author yk
 * @Date 2020/9/5 11:49
 * @Version 1.0
 **/
public class Demo02list {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "C ", "Python", "Groovy");
        Iterator<String> iterator = languages.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
