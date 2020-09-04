package com.aking.netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName BioClient
 * @Description 客户端
 * @Author aking
 * @Date 2020/9/4 00:04
 * @Version 1.0
 **/
public class BioClient {
    public static void main(String[] args) {
        int port = 6666;
        String host = "127.0.0.1";
        try {
            Socket socket = new Socket(host, port);
            System.out.println("客户端启动");
            final OutputStream os = socket.getOutputStream();
            String name = "Python大星，您好！";
            os.write(name.getBytes());
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
