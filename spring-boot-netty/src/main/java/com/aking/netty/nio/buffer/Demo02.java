package com.aking.netty.nio.buffer;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Demo01
 * @Description
 * @Author yk
 * @Date 2020/9/4 10:19
 * @Version 1.0
 **/
public class Demo02 {
    public static void main(String[] args) throws Exception {
        /**
         * mappedByteBuffer: 可以让文件直接在在内存操作，操作系统不需要拷贝一次
         */
        final RandomAccessFile randomAccessFile = new RandomAccessFile("a.txt","rw");
        // 获取对应的通道
        final FileChannel channel = randomAccessFile.getChannel();
        /**
         * 读写模式
         * 起始位置
         * 映射到内存的大小，即将 a.txt 的多少字节映射到内存
         * ===>> 单独到文件夹打开，内容已经修改
         */
        final MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0,(byte)('a'));
        mappedByteBuffer.put(3,(byte)('9'));
        randomAccessFile.close();
        System.out.println("修改成功~~~~");
    }
}
