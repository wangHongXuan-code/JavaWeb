package com.session.service.impl;

import com.session.dao.UserDao;
import com.session.dao.impl.UserDaoImpl;
import com.session.entity.User;
import com.session.service.UserService;

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
