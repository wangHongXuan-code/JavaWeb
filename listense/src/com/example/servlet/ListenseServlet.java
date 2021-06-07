package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/17 19:34
 */
public class ListenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        request.setAttribute("listense", "listense");
        request.removeAttribute("listense");
        // 向ServletContext中添加属性
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("servletContext", "servletContext--value");
        // 向Session作用域中添加属性
        HttpSession session = request.getSession();
        session.setAttribute("session", "session--value");
        session.invalidate(); //使session失效

        response.getWriter().write("listense study");
    }
}
