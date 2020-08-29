package com.aking.io.file;

import java.io.File;

/**
 * @ClassName Demo02File
 * @Description 常用方法
 * @Author yk
 * @Date 2020/8/29 16:18
 * @Version 1.0
 **/
public class Demo05File {
    /**
     * exists()
     * 测试此抽象路径名表示的文件或目录是否存在。
     *
     * 	isDirectory()
     * 测试此抽象路径名表示的文件是否为目录。
     *
     * 	isFile()
     * 测试此抽象路径名表示的文件是否为普通文件
     *
     *
     */

    public static void main(String[] args) {
        show01();
    }

    /**
     * 功能判断
     */
    private static void show01() {
        System.out.println("show01");
        File f1 = new File("D:\\ykDev\\bajProject\\springboot-learn\\spring-boot-io\\src\\main\\java\\com\\aking\\io\\file\\Demo05File.java");
        System.out.println(f1.exists());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());

    }
}
