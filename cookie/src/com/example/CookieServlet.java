package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie分类：
 *      1.临时cookie:默认是存储在内存中的,所以当浏览器关闭的时候,cookie自动失效
 *      2.持久化cookie:保存在浏览器的某个存储目录,当时间过期之后,才会失效
 *      3.临时cookie -> 持久化cookie: 设置过期时间
 * 注意:一个cookie对象只能储存一个键值对,如果有多组数据,要new多个cookie对象
 */
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        // 创建cookie对象
        // 注意:一个cookie对象只能储存一个键值对,如果有多组数据,要new多个cookie对象
        Cookie cookie = new Cookie("00001", "beijing");
        Cookie cookie1 = new Cookie("00002", "shanghai");
        // 给cookie对象添加时间有效期,单位是s
        cookie.setMaxAge(3 * 24 * 3600);
        // 可以给cookie设置固定路径值,只有符合该路由的请求才会发送该cookie
        cookie1.setPath("/cookie/abc");
        // 将cookie设置到response对象中
        response.addCookie(cookie);
        response.addCookie(cookie1);

        response.getWriter().write("学习cookie");
    }
}
