package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54110 on 2020/11/9.
 */
public class UserDaoImpl implements UserDao{


    @Override
    public List<User> findAll() {
        //进行数据库连接操作数据库
        //
        Connection connection =null;
        //执行sql
        ResultSet resultSet=null;
        Statement statement =null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "59852369");
            //创建连接对象
            statement  = connection.createStatement();
            //sql的编写
            String sql = "select * from user where 1=1";
            resultSet = statement.executeQuery(sql);
            //声明返回的list
            List userlist = new ArrayList();
            //解析返回值

            while (resultSet.next()){
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                user.setAddress(resultSet.getString("address"));
                user.setSex(resultSet.getString("sex"));
                userlist.add(user);
            }
            return userlist;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        //进行数据库连接操作数据库
        //
        Connection connection =null;
        //执行sql
        ResultSet resultSet=null;
        Statement statement =null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "59852369");
            //创建连接对象
            statement  = connection.createStatement();
            //sql的编写
            String sql = "select * from user where id="+id;

            resultSet = statement.executeQuery(sql);

            //声明返回的对象
            User user = new User();
            //解析返回值

            while (resultSet.next()){

                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                user.setAddress(resultSet.getString("address"));
                user.setSex(resultSet.getString("sex"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean update(User user) {
        //进行数据库连接操作数据库
        //
        Connection connection =null;
        //执行sql
        PreparedStatement preparedStatement =null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "59852369");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "update user set username =? , address = ? , sex =?  where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            //给占位符进行赋值
            preparedStatement.setObject(1,user.getUsername());
            preparedStatement.setObject(2,user.getAddress());
            preparedStatement.setObject(3,user.getSex());
            preparedStatement.setObject(4,user.getId());
            //执行sql
            int i = preparedStatement.executeUpdate();
            //解析返回值
            if (i>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        //进行数据库连接操作数据库
        //
        Connection connection =null;
        //执行sql
        PreparedStatement preparedStatement =null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "59852369");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "delete from user where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            //给占位符进行赋值
            preparedStatement.setObject(1,id);

            //执行sql
            int i = preparedStatement.executeUpdate();
            //解析返回值
            if (i>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
