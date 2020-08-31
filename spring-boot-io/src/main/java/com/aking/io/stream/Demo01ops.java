package com.aking.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName Demo01ops
 * @Description TODO
 * @Author aking
 * @Date 2020/8/31 23:30
 * @Version 1.0
 **/
public class Demo01ops {
    /**
     * OutputStream:输出字节流的所有类的超类
     * FileOutputStream：把内存中的数据写入到硬盘文件中
     *
     * FileOutputStream(String name)
     * 创建文件输出流以指定的名称写入文件。
     *
     * FileOutputStream(File file)
     * 创建文件输出流以写入由指定的 File 对象表示的文件。
     */
    public static void main(String[] args) throws IOException {
        // create
        FileOutputStream fos = new FileOutputStream("a.txt");
        // 写入一个字节
        fos.write(97);
        fos.close();
    }
}
