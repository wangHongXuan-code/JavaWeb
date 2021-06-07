package com.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/17 19:02
 */
public class EncodingFilter implements Filter {
    public void destroy() {
        System.out.println("编码过滤器被销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("编码过滤器的逻辑处理");
        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("gbk");
        chain.doFilter(req, resp);
        System.out.println("编码过滤器执行完成");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("编码过滤器的初始化");
    }

}
