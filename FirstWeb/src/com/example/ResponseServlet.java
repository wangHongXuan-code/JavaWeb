package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletResponse: 表示服务端返回数据的响应对象
 * 响应行
 * 响应头
 * 响应体
 */
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post请求");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get请求");
        // 设置响应头,按照 key-value 键值对的方式来设置,如果存在相同的 key ,会把 value 的值覆盖
        response.setHeader("hehe", "haha");
        response.setHeader("hehe", "heihei");
        // 设置响应头,按照 key-value 键值对的方式来设置,如果存在相同的 key ,不会覆盖值
        response.addHeader("beijing", "shanghai");
        response.addHeader("beijing", "guangzhou");
        // 设置响应头中的 Content-Type, 两种方式等效
        // 服务端返回的对象数据要按照一定的格式要求进行渲染,只有是html格式才会识别标签
        response.setHeader("Content-Type", "text/html");
        response.setContentType("text/html");
        
        response.setCharacterEncoding("utf-8");

        // 设置响应状态码
        response.sendError(404, "not found");

        // 设置响应体中的返回数据
        response.getWriter().write("<b>java is easy</b>");
    }
}
