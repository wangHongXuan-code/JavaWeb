package com.session.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/11 18:55
 */
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接受到客户端的请求,返回响应的登录页面");

        // 判断是否有别的servlet共享的数据，如果有则接受
        String str = (String) request.getAttribute("str") == null ? "" : (String) request.getAttribute("str");
        System.out.println(str);

        // 设置响应编码
        response.setContentType("text/html;charset=utf-8");
        // 获取响应的输出流对象
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html>");
        printWriter.write("<head>");
        printWriter.write("</head>");
        printWriter.write("<body>");
        printWriter.write("</body>");
        printWriter.write("<font color='red' size='20px'>" + str + "</font>");
        printWriter.write("<form action='login' method='get'>");
        printWriter.write("用户名：<input type='text' name='name' value=''><br/>");
        printWriter.write("密码：<input type='text' name='pwd' value=''><br/>");
        printWriter.write("<input type='submit' value='login'>");
        printWriter.write("</form>");
        printWriter.write("</body>");
        printWriter.write("</html>");

    }
}
