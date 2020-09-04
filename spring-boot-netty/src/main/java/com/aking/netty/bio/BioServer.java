package com.aking.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName BioServer
 * @Description 服务端
 * @Author aking
 * @Date 2020/9/3 23:46
 * @Version 1.0
 **/
public class BioServer {
    public static void main(String[] args) throws IOException {
        // 创建线程池
        final ExecutorService pool = Executors.newCachedThreadPool();
        // 创建 serverSocket，监听 6666 端口
        final ServerSocket server = new ServerSocket(6666);
        System.out.println("服务器启动！");
        while (true) {
            // 监听，等待客户端连接
            System.out.println("等待连接...");
            final Socket socket = server.accept();
            System.out.println("连接到一个客户端!");
            // 创建线程与之通讯
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    // 可以和客户端通信
                    handle(socket);
                }
            });
        }
    }

    /**
     * @param socket
     */
    public static void handle(Socket socket) {
        final byte[] bytes = new byte[1024];
        try {
            // 通过socket获取输入流
            final InputStream inputStream = socket.getInputStream();
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                // 输出客户端发送的数据
                System.out.println(new String(bytes, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭 client 的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
