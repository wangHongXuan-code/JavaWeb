package com.example;

import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/10 11:20
 */
public abstract class MyHttpServlet {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest request, MyResponse response) throws IOException;
    public abstract void doPost(MyRequest request, MyResponse response) throws IOException;

    /**
     * 根据请求方式来判断调用哪种处理方法
     * @param request
     * @param response
     */
    public void service(MyRequest request, MyResponse response) throws IOException {
        if (METHOD_GET.equals(request.getRequestMethod())) {
            doGet(request, response);
        } else if (METHOD_POST.equals(request.getRequestMethod())) {
            doPost(request, response);
        }
    }
}
