package com.aking.netty.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Demo01
 * @Description channel 双向
 * @Author yk
 * @Date 2020/9/4 10:42
 * @Version 1.0
 **/
public class Demo02 {
    public static void main(String[] args) throws Exception {
        // 创建一个输入流
        File file = new File("a.bxt");
        FileInputStream fis = new FileInputStream(file);
        // 通过 fis 获取对应的 filechannel
        FileChannel channel = fis.getChannel();
        // 创建一个缓冲区 bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate((int)(file.length()));
        // 将channel的数据读入到buffer
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        fis.close();
    }
}
