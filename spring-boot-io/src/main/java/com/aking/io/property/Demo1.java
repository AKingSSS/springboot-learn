package com.aking.io.property;

import sun.jvm.hotspot.ui.action.ShowAction;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName Demo1
 * @Description Properties 类表示一组持久的属性。
 * Properties 可以保存到流中或从流中加载。 属性列表中的每个键及其对应的值都是一个字符串。
 * Properties 继承 Hashtable
 * @Author aking
 * @Date 2020/9/1 23:15
 * @Version 1.0
 **/
public class Demo1 {

    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        final Properties prop = new Properties();
        prop.setProperty("name","Python大星");
        prop.setProperty("age","100");
        prop.setProperty("sex","boy");
        final Set<String> set = prop.stringPropertyNames();
        for (String s : set) {
            System.out.println(s + "=" + prop.getProperty(s));
        }
    }
}
