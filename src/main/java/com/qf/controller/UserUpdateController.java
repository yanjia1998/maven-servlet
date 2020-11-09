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
@WebServlet("/update")
public class UserUpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //获取到前端传输的修改的数据
        Integer id = Integer.valueOf(req.getParameter("id"));
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String sex = req.getParameter("sex");
        //声明对象，封装参数
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setAddress(address);
        user.setSex(sex);
        //将user对象传输到userDaoimpl 进行修改
        UserServiceImpl userService = new UserServiceImpl();
        Boolean update = userService.update(user);
        //如果update为true代表修改成功
        if (update){
            resp.sendRedirect("/findAll");
        }
    }
}
