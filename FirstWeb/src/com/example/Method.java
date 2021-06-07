package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet类中可以有service方法,
 *      用来接收 get或者 post 请求
 *      如果有 service 就调用 service 方法,不会调用 doGet doPost
 *      没有 service 则调用 doGet doPost
 *      如果 service 中调用了 super.service() 注意父类中 service会去调用 doGet / doPost
 *      此时如果没有doGet doPost方法会跳转错误页面
 * doGet方法：
 *      用来接受 get 请求
 * doPost方法：
 *      用来接受 post 请求
 *
 * 总结：
 *      在编写servlet类的时候, 不需要重新实现service方法, 只需要重写 doGet 和 doPost 方法即可
 *      用来接受 post 或 get 请求
 *
 * servlet的常见错误:
 *      404: 访问资源不存在
 *      —— 请求路径跟 web.xml中填写的请求不一致
 *      —— 请求路径的项目虚拟名称填写错误
 *      405:
 *      —— 请求的方式跟 servlet 中支持的方式不一致
 *      500: 服务器内部错误
 *      —— web.xml 中 servlet类的完全限定名错误
 *      —— servlet 对应的处理方法中存在代码逻辑错误
 */
public class Method extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是Post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是service");
        super.service(req, resp);
    }
}
