package com.example.listense;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/17 21:16
 */
public class MyListener2 implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取application
        ServletContext servletContext = sce.getServletContext();
        // 设置网站在线人数的初始值
        servletContext.setAttribute("count", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext被销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int count = (int)servletContext.getAttribute("count");
        servletContext.setAttribute("count", ++count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int count = (int)servletContext.getAttribute("count");
        servletContext.setAttribute("count", --count);
    }
}
