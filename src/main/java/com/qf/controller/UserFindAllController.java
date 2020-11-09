package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 54110 on 2020/11/9.
 */
@WebServlet("/findAll")
public class UserFindAllController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有用户
        UserServiceImpl userService = new UserServiceImpl();
        List<User> all = userService.findAll();
        //将数据设置到req中
        req.setAttribute("user",all);
        //设置跳转的页面
        req.getRequestDispatcher("/userlist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
