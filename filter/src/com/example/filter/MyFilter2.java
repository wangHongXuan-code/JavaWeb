package com.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/17 18:20
 */
public class MyFilter2 implements Filter {
    public void destroy() {
        System.out.println("第二个过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("第二个过滤器开始执行");
        chain.doFilter(req, resp);
        System.out.println("第二个过滤器执行结束");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("第二个过滤器初始化");
    }

}
