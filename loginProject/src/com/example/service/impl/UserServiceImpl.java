package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.entity.User;
import com.example.service.UserService;

/**
 * @author 王鸿轩
 * @description
 * @since 2021/5/11 19:25
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
