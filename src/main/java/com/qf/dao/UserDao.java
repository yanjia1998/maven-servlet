package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

/**
 * Created by 54110 on 2020/11/9.
 */
public interface UserDao {

    List<User> findAll();

    User findById(Integer id);

    Boolean update(User user);

    Boolean deleteById(Integer id);
}
