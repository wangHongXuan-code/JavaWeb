package com.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 *      完成请求的拦截以及资源的统一管理功能
 *      使用方式
 *          定义普通Java类,实现Filter接口
 *          重写其中的方法
 *              init: 完成初始化功能   tomcat启动的时候执行一次
 *              doFilter: 进行处理    每次发送请求的时候都会执行
 *              destroy: 销毁功能     tomcat关闭的时候执行
 *
 *              <filter>
 *                  <filter-name>MyFilter</filter-name>     配置filter的别名
 *                  <filter-class>com.example.filter.MyFilter</filter-class>    配置filter指定的类名
 *              </filter>
 *              <filter-mapping>
 *                  <filter-name>MyFilter</filter-name>     配置filter的别名,跟filter标签中的name对应
 *                  <url-pattern>/*</url-pattern>           表示要匹配的请求
 *              </filter-mapping>
 *      生命周期
 *          从tomcat启动到tomcat关闭
 *      filterChain: 表示过滤器链
 *          在项目中可以定义多个过滤器链,当开始执行的时候,根据用户的请求把符合规则的过滤器挨个执行
 *          建议: 每个过滤器完成独立的功能,不要将所有的逻辑处理放置到同一个过滤器中,耦合性高,不利于维护
 *
 *          在过滤器的 web.xml配置文件中,可以指定过滤器过滤哪些请求:
 *              /*          匹配所有请求
 *              /*.do       匹配所有后缀为do的请求
 *              /filter.do  匹配请求为filter.do的请求
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter process");
        // 添加此语句之后才能调用到对应的servlet
        chain.doFilter(request, response);
        System.out.println("Filter process finish");
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}
