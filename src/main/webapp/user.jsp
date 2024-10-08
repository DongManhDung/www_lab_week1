<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/8/2024
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
    <h1>User Information</h1>
    <p>Account ID: <%= request.getSession().getAttribute("accountId").toString()%></p>
    <p>Username: <%= request.getSession().getAttribute("accountName").toString()%></p>
    <p>Email: <%= request.getSession().getAttribute("accountEmail").toString()%>></p>
    <p>Phone: <%= request.getSession().getAttribute("accountPhone").toString()%>></p>
    <p>Status: <%= request.getSession().getAttribute("accountStatus").toString()%></p>
    <p>Role: <%= request.getSession().getAttribute("accountRole").toString()%></p>
    <a href="./index.jsp">LOGOUT</a>
</body>
</html>
