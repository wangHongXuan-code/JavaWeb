package com.cookie.service;

import com.cookie.entity.User;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/11 19:25
 */
public interface UserService {
    public User checkUser(User user);

    public User getUserById(int id);
}
