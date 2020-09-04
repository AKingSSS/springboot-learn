package com.aking.netty.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Demo01
 * @Description channel 双向 拷贝文件
 * @Author yk
 * @Date 2020/9/4 10:42
 * @Version 1.0
 **/
public class Demo04 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("out.txt");
        FileChannel channelIn = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("out1.txt");
        FileChannel channelOut = fos.getChannel();
        // 使用 transform完成拷贝
        channelOut.transferFrom(channelIn,0,channelIn.size());
        // 关闭
        channelOut.close();
        channelIn.close();
        fis.close();
        fos.close();
    }
}
