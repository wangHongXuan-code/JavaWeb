package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * HttpServletRequest 用来存放客户端请求的参数
 * 请求行
 * 请求头
 * 请求体
 */
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post请求");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get请求");


        /**
         * 获取请求行中的参数
         */

        // 获取请求中的请求方式
        String method = request.getMethod();
        System.out.println(method);
        // 获取请求的完整地址
        StringBuffer url = request.getRequestURL();
        System.out.println(url);
        // 获取请求中的资源路径
        String uri = request.getRequestURI();
        System.out.println(uri);
        // 获取请求的协议
        String scheme = request.getScheme();
        System.out.println();


        /**
         * 获取请求头中的参数
         * 根据 key 获取 value 的值
         */

        // 获取请求头信息中的所有 key 的枚举对象
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
            // 获取请求头中的所有数据
            // String key = headerNames.nextElement();
            // String value = request.getHeader(key);
            // System.out.println(key+":"+value);
        }
        // 获取请求头中的 user-agent (浏览器信息)
        String userAgent = request.getHeader("user-agent");
        System.out.println(userAgent);


        /**
         * 获取请求体中的用户请求数据
         * 无论请求方式是 post 还是 get,获取用户数据的方式不变
         */
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        // 对于相同 key有多个数据值,例如 checkbox,request.getParameter默认获取第一个
        String fav = request.getParameter("fav");
        System.out.println(name + ":" + pwd+":" + fav);
        // request.getParameterValues 可以获取相同 key的所有数据值
        String[] parameterValues = request.getParameterValues("fav");
        System.out.println(Arrays.toString(parameterValues));
        // 获取用户数据中的所有 key
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }


        /**
         * 其他常用API
         */

        // 获取远程客户端的地址
        String remoteAddress = request.getRemoteAddr();
        // 获取远程客户端的主机名称
        String remoteHost = request.getRemoteHost();
        // 获取远程客户端的端口号
        int remotePort = request.getRemotePort();

        System.out.println(remoteAddress + ":" + remoteHost + ":" + remotePort);

        // 获取本地的地址
        String localAddr = request.getLocalAddr();
        // 获取本地主机名称
        String localName = request.getLocalName();
        System.out.println(localAddr + ":" + localName);
    }
}
