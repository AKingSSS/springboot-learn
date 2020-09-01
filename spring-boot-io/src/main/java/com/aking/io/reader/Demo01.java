package com.aking.io.reader;

import org.hibernate.validator.constraints.Length;

import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName Demo01
 * @Description 字符输入流
 * @Author yk
 * @Date 2020/9/1 15:15
 * @Version 1.0
 **/
public class Demo01 {
    /**
     * Reader 字符输入流顶层父类
     */
    public static void main(String[] args) throws IOException {
        // create
        FileReader fr = new FileReader("a.txt");
/*        // read
        int len = 0;
        while ((len=fr.read()) != -1) {
            System.out.println((char)(len));
        }*/

        // 记录有效读取字符个数
        int len = 0;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }

        fr.close();
    }
}
