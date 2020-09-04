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
public class Demo03 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("a.txt");
        FileChannel channelIn = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("out.txt");
        FileChannel channelOut = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(5);
        while (true) {
            // buffer 需要清空，否则 position==limit，读取的read=0
            buffer.clear();
            int read = channelIn.read(buffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }
            buffer.flip();
            channelOut.write(buffer);
        }
        // 关闭
        fis.close();
        fos.close();
    }
}
