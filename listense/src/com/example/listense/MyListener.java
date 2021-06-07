package com.example.listense;
/**
 * 监听器：
 *      监听作用域对象的创建和销毁以及属性的相关配置：可以添加一些公共的属性配置,做逻辑判断
 *      主要监听三种作用域
 *          ServletContext(application)
 *              接口：
 *                  ServletContextListener：监听ServletContext对象的创建和销毁
 *                      public void contextInitialized(ServletContextEvent sce) 创建对象,当启动tomcat服务器的时候创建
 *                      public void contextDestroyed(ServletContextEvent sce)   销毁对象,关闭tomcat服务器的时候销毁
 *                  ServletContextAttributeListener：监听ServletContext对象属性的添加、删除和修改
 *                      public void attributeAdded(ServletContextAttributeEvent scae)       属性添加时的逻辑代码
 *                      public void attributeRemoved(ServletContextAttributeEvent scae)     属性删除时的逻辑代码
 *                      public void attributeReplaced(ServletContextAttributeEvent scae)    属性修改时的逻辑代码
 *          session
 *              接口：
 *                  HttpSessionListener：监听session对象的创建和销毁
 *                      public void sessionCreated(HttpSessionEvent se)     session对象创建的时候执行
 *                      public void sessionDestroyed(HttpSessionEvent se)   session对象销毁的时候执行
 *                  HttpSessionAttributeListener：监听session对象属性的添加、删除和修改
 *                      public void attributeAdded(HttpSessionBindingEvent se)      属性添加时的逻辑代码
 *                      public void attributeRemoved(HttpSessionBindingEvent se)    属性删除时的逻辑代码
 *                      public void attributeReplaced(HttpSessionBindingEvent se)   属性修改时的逻辑代码
 *          request
 *              接口：
 *                  ServletRequestListener：监听request对象的创建和销毁
 *                      public void requestDestroyed(ServletRequestEvent sre)   request对象销毁时添加的逻辑代码
 *                      public void requestInitialized(ServletRequestEvent sre) request对象创建时添加的逻辑代码
 *                  ServletRequestAttributeListener：监听request作用域属性的添加、删除和修改
 *                      public void attributeAdded(ServletRequestAttributeEvent srae)       属性添加时的逻辑代码
 *                      public void attributeRemoved(ServletRequestAttributeEvent srae)     属性删除时的逻辑代码
 *                      public void attributeReplaced(ServletRequestAttributeEvent srae)    属性修改时的逻辑代码
 *
 */

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class MyListener implements ServletRequestListener, ServletRequestAttributeListener, ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象被销毁" + new Date());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象被创建" + new Date());
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("向request作用域添加数据");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("从request作用域删除数据");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("更改request作用域的数据");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext销毁");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("ServletContext添加属性");
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("ServletContext删除属性");
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("ServletContext修改属性");
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("Session添加属性");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("Session删除属性");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("Session修改属性");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session对象被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session对象被销毁");
    }
}
