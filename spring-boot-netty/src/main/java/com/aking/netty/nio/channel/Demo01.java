package com.aking.netty.nio.channel;

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
public class Demo01 {
    public static void main(String[] args) throws Exception {
        String str = "Python大星";
        // 创建一个输出流
        FileOutputStream fos = new FileOutputStream("a.txt");
        // 通过 fos 获取对应的 filechannel
        FileChannel channel = fos.getChannel();
        // 创建一个缓冲区 bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将str写入buffer
        buffer.put(str.getBytes());
        // 对 buffer，进行
        buffer.flip();
        // 将buffer数据写入filechannel
        channel.write(buffer);
        fos.close();
    }
}
