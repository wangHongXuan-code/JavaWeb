package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/10 11:29
 */
public class MyServer {

    /**
     * 定义服务端的接受程序,接受socket请求
     * @param port
     */
    public static void startServer(int port) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // 定义服务端套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 定义客户端套接字
        Socket socket = null;

        while (true) {
            socket = serverSocket.accept();

            // 获取输入流和输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // 定义请求对象
            MyRequest request = new MyRequest(inputStream);
            // 定义响应对象
            MyResponse response = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if (clazz != null) {
                System.out.println(clazz);
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                // 根据 myServletClass 创建对象
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(request, response);
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        startServer(10086);
    }
}
