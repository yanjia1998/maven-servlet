package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 54110 on 2020/11/9.
 */
@WebServlet("/findById")
public class UserFindByIdController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到前端传输的id
        Integer id = Integer.valueOf(req.getParameter("id"));
        //通过id查询出这一条数据
        UserServiceImpl userService = new UserServiceImpl();

        User user =  userService.findById(id);
        //将user放置到req中，进行页面的展示
        req.setAttribute("user",user);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);

    }
}
