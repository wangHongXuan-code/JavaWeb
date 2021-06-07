package com.example;

import java.io.IOException;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/10 11:25
 */
public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws IOException {
        response.write("get tomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws IOException {
        response.write("post tomcat");
    }
}
