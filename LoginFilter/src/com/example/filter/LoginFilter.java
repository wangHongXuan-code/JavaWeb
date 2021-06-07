package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/17 19:06
 */
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("登录过滤器被销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("登录过滤器的逻辑处理");
        HttpSession session = ((HttpServletRequest)req).getSession();
        if (session.getAttribute("user") == null)
            ((HttpServletResponse)resp).sendRedirect("login.jsp");
        else
            chain.doFilter(req, resp);
        System.out.println("登录过滤器处理完成");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("登录过滤器初始化");
    }

}
