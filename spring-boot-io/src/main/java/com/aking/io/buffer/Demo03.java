package com.aking.io.buffer;

import java.io.*;

/**
 * @ClassName Demo03
 * @Description 字符缓冲流
 * @Author yk
 * @Date 2020/9/2 14:33
 * @Version 1.0
 **/
public class Demo03 {
    public static void main(String[] args) throws IOException {
        show02();
    }

    private static void show01() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        for (int i = 0; i < 10; i++) {
            bw.write("hello world");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void show02() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        String s;
        while ((s = br.readLine())!=null){
            System.out.println(s);
        }
        br.close();
    }
}
