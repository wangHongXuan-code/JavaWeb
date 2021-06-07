package com.example;

import java.util.HashMap;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/10 11:15
 */
public class MyMapping {
    public static HashMap<String, String> mapping = new HashMap<>();
    static {
        mapping.put("/mytomcat", "com.example.MyServlet");
    }

    public HashMap<String, String> getMapping() {
        return mapping;
    }
}
