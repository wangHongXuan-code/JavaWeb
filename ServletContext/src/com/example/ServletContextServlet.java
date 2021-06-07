package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/13 20:46
 */
public class ServletContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 三种获取ServletContext对象的方法
        ServletContext context = this.getServletContext();
        // ServletContext context1 = this.getServletConfig().getServletContext();
        // ServletContext context2 = request.getSession().getServletContext();

        // 向ServletContext对象中设置属性值
        context.setAttribute("111", "zhangSan");

        // ServletContext的其他用途：
        // 1.获取web.xml中配置的公共属性(在<context-param></context-param>中配置公共属性)
        String value = context.getInitParameter("beijing");
        System.out.println(value);
        // 2.获取某个文件的绝对路径
        String path = context.getRealPath("web.xml");
        System.out.println(path);
        // 3.获取web项目的上下文路径(虚拟目录路径)
        String path1 = context.getContextPath();
        System.out.println(path1);
    }
}
