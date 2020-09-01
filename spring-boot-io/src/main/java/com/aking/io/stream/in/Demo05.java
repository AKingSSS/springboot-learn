package com.aking.io.stream.in;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName Demo04
 * @Description 读取多个字节
 * @Author yk
 * @Date 2020/9/1 14:22
 * @Version 1.0
 **/
public class Demo05 {
    /**
     * inputStream：字节输入流的所有类的超类
     * 从硬盘读取到内存中
     */

    public static void main(String[] args) throws IOException {
        // 创建
        FileInputStream fis = new FileInputStream("a.txt");
/*        // 缓存多个数组，数组一般定义 1024 的整数倍
        byte[] bytes = new byte[2];
        // 每次读取的有效个数
        int read = fis.read(bytes);
        System.out.println(new String(bytes));*/
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            // 注意:new String(bytes) 后面会有1024-len个空格
            System.out.println(new String(bytes, 0, len));
        }

        fis.close();
    }
}
