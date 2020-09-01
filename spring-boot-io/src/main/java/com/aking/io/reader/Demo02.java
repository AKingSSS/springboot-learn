package com.aking.io.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName Demo01
 * @Description 字符输出流
 * @Author yk
 * @Date 2020/9/1 15:15
 * @Version 1.0
 **/
public class Demo02 {
    /**
     * Writer 字符输出流顶层父类
     */
    public static void main(String[] args) throws IOException {
        // 创建
        FileWriter fw = new FileWriter("d.txt");
        // 写入到了内存缓冲区
        fw.write(97);
        // flush 刷新缓冲区，流对象可以继续使用
        // close 刷新缓冲区，流对象不可以继续使用
        fw.flush();
        fw.close();

    }
}
