package com.aking.io.property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
public class Demo2 {

    public static void main(String[] args) throws IOException {
        show01();
    }

    private static void show01() throws IOException {
        /**
         * load(InputStream inStream)
         * 从输入字节流读取属性列表（键和元素对）
         *
         * load(Reader reader)
         * 以简单的线性格式从输入字符流读取属性列表（关键字和元素对）。
         */

        Properties prop = new Properties();
        prop.load(new FileReader("a.txt"));
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}
