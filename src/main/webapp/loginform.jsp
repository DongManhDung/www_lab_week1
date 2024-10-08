<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/21/2024
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
        <form action="controller" method="POST">
            <input type="text" name="account_id" placeholder="Nhap id"><br>
            <input type="password" name="password" placeholder="Nhap password"><br>
            <input type="submit" value="Login" name="action">
            <input type="reset">
        </form>
</body>
</html>
