package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

/**
 * Created by 54110 on 2020/11/9.
 */
public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    Boolean update(User user);

    Boolean deleteById(Integer id);
}
