package com.qf.controller;

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
@WebServlet("/deleteById")
public class UserDeleteController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到前端传输的id
        Integer id = Integer.valueOf(req.getParameter("id"));
        //使用id进行删除
        UserServiceImpl userService = new UserServiceImpl();
        Boolean status = userService.deleteById(id);
        if (status){
            //跳转查询所有
            resp.sendRedirect("/findAll");
        }
    }
}
