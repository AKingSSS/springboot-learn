package com.aking.io.stream.in;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Demo04
 * @Description 文件复制
 * @Author yk
 * @Date 2020/9/1 14:22
 * @Version 1.0
 **/
public class Demo06 {
    public static void main(String[] args) throws IOException {
        // 输入流
        FileInputStream fis = new FileInputStream("a.txt");
        // 输出流
        FileOutputStream fos = new FileOutputStream("c.txt");
/*        // 一次读一个字节写入一个字节
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }*/
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }
}
