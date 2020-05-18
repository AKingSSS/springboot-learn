package com.aking.encry.util;

import cn.hutool.crypto.digest.MD5;

/**
 * @ClassName Md5Demo
 * @Description
 * @Author yk
 * @Date 2020/5/18 11:17
 * @Version 1.0
 **/
public class Md5Demo {
    public static void main(String[] args) {
        System.out.println(MD5.create().digestHex16("python1!2@3#4$5%"));
        System.out.println(MD5.create().digestHex16("123@qwe"));
        System.out.println(MD5.create().digestHex16("TFGfYB17rb"));
    }
}
