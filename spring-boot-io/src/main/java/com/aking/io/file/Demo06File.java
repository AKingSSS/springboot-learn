package com.aking.io.file;

import java.io.File;

/**
 * @ClassName Demo02File
 * @Description 创建删除
 * @Author yk
 * @Date 2020/8/29 16:18
 * @Version 1.0
 **/
public class Demo06File {
    /**
     * 	createNewFile()
     * 当且仅当具有该名称的文件尚不存在时，原子地创建一个由该抽象路径名命名的新的空文件。
     *
     * mkdir()
     * 创建由此抽象路径名命名的目录，创建的是单级文件夹
     *
     * mkdirs()
     * 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录，单级或多级文件夹
     * 当文件夹存在，不会创建，当构造方法中的路径不存在，返回false
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
