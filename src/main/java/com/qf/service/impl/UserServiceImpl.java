package com.qf.service.impl;

import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.UserService;

import java.util.List;

/**
 * Created by 54110 on 2020/11/9.
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        //去dao层调用方法 进行查找
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {

        UserDaoImpl userDao = new UserDaoImpl();
        User byId = userDao.findById(id);
        return byId;
    }

    @Override
    public Boolean update(User user) {
        UserDaoImpl userDao = new UserDaoImpl();

        return userDao.update(user);
    }

    @Override
    public Boolean deleteById(Integer id) {
        UserDaoImpl userDao = new UserDaoImpl();

        return userDao.deleteById(id);
    }
}
