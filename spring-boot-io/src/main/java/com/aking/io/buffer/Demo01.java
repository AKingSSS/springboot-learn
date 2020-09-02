package com.aking.io.buffer;

import java.io.*;

/**
 * @ClassName Demo01
 * @Description
 * @Author yk
 * @Date 2020/9/2 11:08
 * @Version 1.0
 **/
public class Demo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 字节缓冲流：BufferedInputStream,BufferedOutStream
         *
         * 字符缓冲流：BufferedReader,BufferedWriter
         */
        show01();

    }

    /**
     * 字节缓冲
     * BufferedOutputStream(OutputStream out)
     * 创建一个新的缓冲输出流，以将数据写入指定的底层输出流
     */
    private static void show01() throws IOException {
        FileOutputStream fos = new FileOutputStream("buffer.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("我把数据写到缓冲区".getBytes());
        bos.flush();
        bos.close();
    }
}
