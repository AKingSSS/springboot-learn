package com.aking.io.stream.in;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName Demo04
 * @Description
 * @Author yk
 * @Date 2020/9/1 14:22
 * @Version 1.0
 **/
public class Demo04 {
    /**
     * inputStream：字节输入流的所有类的超类
     * 从硬盘读取到内存中
     */

    public static void main(String[] args) throws IOException {
        // 创建
        FileInputStream fis = new FileInputStream("a.txt");
        // 读取
        // read 读取一个字节返回，读取文件末尾返回 -1
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.print((char)(len));
        }
        fis.close();
    }
}
