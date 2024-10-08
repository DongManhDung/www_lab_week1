<%@ page import="iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/8/2024
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Account</title>
</head>
<body>
    <% Account account = (Account) request.getSession().getAttribute("account");%>
    <h1>Update Account</h1>
    <form action="./controller" method="POST">
        <span>AccountId: </span> <input type="text" name="accountId" value="<%=account.getAccountId()%>"> <br>
        <span>Full name: </span> <input type="text" name="fullName" value="<%=account.getFullName()%>"> <br>
        <span>Email: </span> <input type="text" name="email" value="<%=account.getEmail()%>"> <br>
        <span>Phone: </span> <input type="text" name="phone" value="<%=account.getPhone()%>"> <br>
        <span>Password: </span> <input type="text" name="password" value="<%=account.getPassword()%>"> <br>
        <span>Status: </span> <input type="text" name="status" value="<%=account.getStatus()%>"> <br>

        <input type="submit" value="save" name="action">
    </form>
</body>
</html>
