package com.aking.netty.nio.buffer;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * @ClassName Demo01
 * @Description
 * @Author yk
 * @Date 2020/9/4 10:19
 * @Version 1.0
 **/
public class Demo01 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(2 * i);
        }
        // 读写切换
        intBuffer.flip();
        //     * Tells whether there are any elements between the current position and
        //     * the limit.
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

    }
}
