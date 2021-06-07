package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/10 21:29
 */
@WebServlet(name = "ServletLife")
public class ServletLife extends HttpServlet {

    /**
     * 完成servlet对象的初始化工作
     * 在servlet接受到第一次请求的时候创建对象
     * 生命周期：从第一次接受请求开始到服务器关闭之后销毁
     * 可以通过在web.xml配置<load-on-startup>1</load-on-startup>让servlet在服务器启动时就初始化
     * 中间的数值表示多个servlet的优先级
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("servlet life");
        System.out.println("learn servlet life");
    }

    /**
     * 完成servlet对象的销毁工作
     * 服务器关闭之后销毁
     */
    @Override
    public void destroy() {
        System.out.println("我被销毁了");
    }
}
