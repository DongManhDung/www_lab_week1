<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/4/2024
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Account</title>
</head>
<body>
    <h1>Create New Account</h1>
    <form action="./controller" method="POST">
        <input type="text" name="accountId"  placeholder="AccountId">
        <input type="text" name="fullName" placeholder="FullName">
        <input type="text" name="email" placeholder="Email">
        <input type="text" name="phone" placeholder="Phone">
        <input type="password" name="password"  placeholder="Password">
        <input type="text" name="status"  placeholder="Status">
        <input type="submit" value="add" name="action">
    </form>
</body>
</html>
