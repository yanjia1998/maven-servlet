<%--
  Created by IntelliJ IDEA.
  User: 54110
  Date: 2020/11/9
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--使用el表达式 是否当作字符串来进行处理-->
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/update" method="post">
            <input type="hidden" name="id" value="${user.id}"><br>
            用户姓名:<input type="text" name="username" value="${user.username}"><br>
            用户住址：<input type="text" name="address" value="${user.address}"><br>
            用户性别:<input type="text" name="sex" value="${user.sex}"><br>
            <input type="submit" value="提交修改">
        </form>
    </div>
</body>
</html>
