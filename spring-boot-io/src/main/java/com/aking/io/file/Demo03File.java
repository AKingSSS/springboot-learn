package com.aking.io.file;

import java.io.File;

/**
 * @ClassName Demo02File
 * @Description 构造方法
 * @Author yk
 * @Date 2020/8/29 16:18
 * @Version 1.0
 **/
public class Demo03File {
    /**
     *  File(String pathname)
     * 通过将给定的路径名字符串转换为抽象路径名来创建新的 File 实例
     * 路径可以是文件结尾，也可以是文件夹结尾
     * 路径可以是绝对路径，也可以是相对路径
     * 路径可以是存在，也可以是不存在
     * 创建file对象，只是把字符串路径封装为File对象，不考虑路径的真假
     *
     */


    public static void main(String[] args) {
//        show01();
        show03();
    }

    private static void show01() {
        File f1 = new File("D:\\other\\Chrome\\a.txt");
        // 重写了 Object类的 toString 方法
        System.out.println(f1);

        File f2 = new File("D:\\other\\Chrome");
        System.out.println(f2);

        File f3 = new File("b.txt");
        System.out.println(f3);
    }

    private static void show02() {
        // File(String parent, String child)
    }

    private static void show03() {
        // File(String parent, String child)
        File parent = new File("c:\\");
        File file = new File(parent, "hello.java");
        System.out.println(file);
    }
}
