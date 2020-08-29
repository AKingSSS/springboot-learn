package com.aking.io.file;

import java.io.File;

/**
 * @ClassName Demo02File
 * @Description 常用方法
 * @Author yk
 * @Date 2020/8/29 16:18
 * @Version 1.0
 **/
public class Demo04File {
    /**
     * getAbsoluteFile()
     * 返回此抽象路径名的绝对形式。
     *
     * getName()
     * 返回由此抽象路径名表示的文件或目录的名称。
     *
     * getPath()
     * 将此抽象路径名转换为路径名字符串
     *
     * length()
     * 返回由此抽象路径名表示的文件的长度
     *
     */

    public static void main(String[] args) {

//        show01();
//        show02();
//        show03();
        show04();
    }

    /**
     * 获取绝对路径
     */
    private static void show01() {
        System.out.println("show01");
        File f1 = new File("D:\\ykDev\\bajProject\\springboot-learn\\a.txt");
        System.out.println(f1.getAbsolutePath());

        File f2 = new File("b.txt");
        System.out.println(f2.getAbsolutePath());
    }

    /**
     * 获取路径
     */
    private static void show02() {
        System.out.println("show02");
        File f1 = new File("D:\\ykDev\\bajProject\\springboot-learn\\a.txt");
        System.out.println(f1.getPath());

        File f2 = new File("b.txt");
        System.out.println(f2.getPath());
    }

    /**
     * 获取文件或目录名
     */
    private static void show03() {
        System.out.println("show03");
        File f1 = new File("D:\\ykDev\\bajProject\\springboot-learn\\a.txt");
        System.out.println(f1.getName());

        File f2 = new File("D:\\ykDev\\bajProject\\springboot-learn");
        System.out.println(f2.getName());
    }

    /**
     * 表示的文件的长度（以字节为单位），如果文件不存在， 0L
     *
     */
    private static void show04() {
        System.out.println("show04");
        File f1 = new File("D:\\ykDev\\bajProject\\springboot-learn\\a.txt");
        System.out.println(f1.length());

        File f2 = new File("D:\\ykDev\\bajProject\\springboot-learn");
        System.out.println(f2.length());
    }
}
