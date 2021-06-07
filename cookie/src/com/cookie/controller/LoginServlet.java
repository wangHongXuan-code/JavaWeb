package com.cookie.controller;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import com.cookie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/11 19:10
 */
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        // 封装对象
        User user = new User(name, pwd);

        // 调用 service 进行逻辑处理
        User u = userService.checkUser(user);
        System.out.println(u);

        if (u != null) {
            // response.getWriter().write("success");
            // request.getRequestDispatcher("hello").forward(request, response);
            // 此时如果采取请求转发的方式,用户如果频繁刷新,每次都会经过多个servlet的流转
            // 然而在用户登录成功的情况下,其实刷新欢迎页面就可以了
            // 重定向
            // 1.浏览器发送两次请求
            // 2.浏览器的地址发生变化
            // 3.请求过程产生两个request对象和两个response对象
            // 4.两个servlet不能共享同一个request和response对象

            // 创建cookie对象
            Cookie cookie = new Cookie("uid", u.getId()+"");
            // 设置cookie的过期时间
            cookie.setMaxAge(7 * 24 * 3600);
            // 将cookie信息设置到response对象中
            response.addCookie(cookie);

            response.sendRedirect("hello");
        }
        else {
            request.setCharacterEncoding("utf-8");
            // 设置多个servlet的共享参数
            request.setAttribute("str", "用户名或者密码错误");
            // 请求转发
            // 请求servlet的时候,写相对路径,同时后续不需要逻辑代码的处理
            // 1.客户端只发送一次请求
            // 2.浏览器的地址栏地址没有变化
            // 3.请求过程中只有一个request和response
            // 4.几个servlet共享一个request和response
            // 5.对客户端透明,客户端不需要知道用户做了哪些操作
            request.getRequestDispatcher("page").forward(request, response);
            return;
        }
    }
}
