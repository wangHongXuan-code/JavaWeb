package com.cookie.dao;

import com.cookie.entity.User;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/11 19:26
 */
public interface UserDao {
    public User checkUser(User user);

    public User getUserById(int id);
}
