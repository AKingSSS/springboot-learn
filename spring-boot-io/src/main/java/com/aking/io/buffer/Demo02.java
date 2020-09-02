package com.aking.io.buffer;

import java.io.*;

/**
 * @ClassName Demo01
 * @Description
 * @Author yk
 * @Date 2020/9/2 11:08
 * @Version 1.0
 **/
public class Demo02 {
    public static void main(String[] args) throws IOException {
        show01();
    }

    /**
     * 复制文件
     *
     * @throws IOException
     */
    private static void show01() throws IOException {
        // 创建字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
        // 创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.txt"));
        // 一次读取一个字节
/*        int len = 0;
        while ((len=bis.read())!=-1){
            bos.write(len);
        }*/
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }
}
