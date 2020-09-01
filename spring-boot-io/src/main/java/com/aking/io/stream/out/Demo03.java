package com.aking.io.stream.out;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Demo01ops
 * @Description
 * @Author aking
 * @Date 2020/8/31 23:30
 * @Version 1.0
 **/
public class Demo03 {

    public static void main(String[] args) throws IOException {
        /**
         * public FileOutputStream(String name,
         *                         boolean append)
         *                  throws FileNotFoundException
         * 创建文件输出流以指定的名称写入文件。 如果第二个参数是 true ，
         * 则字节将写入文件的末尾而不是开头。 创建一个新的 FileDescriptor 对象来表示此文件连接。
         *
         * 写换行：写换行符
         * Windows：\r\n
         * linux: /n
         * mac: /r
         */
        // create
        FileOutputStream fos = new FileOutputStream("a.txt", true);

        String separator = System.getProperty("line.separator");
        String name = "Python 大星" + separator;
        // 写入一个字节
        fos.write(name.getBytes());
        fos.close();
    }
}
