package com.session.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/13 0:06
 */
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        // 获取session对象
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html>");
        printWriter.write("<head>");
        printWriter.write("</head>");
        printWriter.write("<body>");
        printWriter.write("<h1>欢迎" + name + "登录</h1>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}
