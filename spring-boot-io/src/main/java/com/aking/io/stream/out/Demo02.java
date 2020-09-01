package com.aking.io.stream.out;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Demo01ops
 * @Description 写入多个字节
 * @Author aking
 * @Date 2020/8/31 23:30
 * @Version 1.0
 **/
public class Demo02 {

    public static void main(String[] args) throws IOException {
        // create
        FileOutputStream fos = new FileOutputStream("a.txt");
        String name = "Python大星";
        // 写入字节
        fos.write(name.getBytes());
        fos.close();
    }
}
