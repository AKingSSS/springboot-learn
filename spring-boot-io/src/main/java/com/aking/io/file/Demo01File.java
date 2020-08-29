package com.aking.io.file;

import java.io.File;

/**
 * @ClassName Demo01File
 * @Description
 * @Author yk
 * @Date 2020/8/29 10:30
 * @Version 1.0
 **/
public class Demo01File {
    public static void main(String[] args) {
        /**
         * static String	pathSeparator
         * 与系统相关的路径分隔符字符，为方便起见，表示为字符串。
         *  ！！！！环境变量就是以;分割！！！！
         *
         * static char	pathSeparatorChar
         * 与系统相关的路径分隔符。
         * =======================================================
         *
         * static String	separator
         * 与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
         * \
         *
         * static char	separatorChar
         * 与系统相关的默认名称分隔符。
         * 操作路径不能写死
         * D:\other\Chrome\a.txt   windows
         * D:/other/Chrome/a.txt   linux
         *
         */
        System.out.println("pathSeparator = " + File.pathSeparator);
        System.out.println("pathSeparatorChar = " + File.pathSeparatorChar);
        System.out.println("separator = " + File.separator);
        System.out.println("separatorChar = " + File.separatorChar);
        // 应用
        System.out.println("D:" + File.separator +"other" + File.separator +"Chrome"+File.separator +"a.txt");

    }
}
