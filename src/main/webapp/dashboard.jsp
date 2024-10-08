<%@ page import="java.util.List" %>
<%@ page import="iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/3/2024
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Admin information</title>
  </head>
  <body>
      <h1>List of user</h1>
        <p>Account ID: <%= request.getSession().getAttribute("accountId").toString()%></p>
        <p>Username: <%= request.getSession().getAttribute("accountName").toString()%></p>
        <p>Email: <%= request.getSession().getAttribute("accountEmail").toString()%>></p>
        <p>Phone: <%= request.getSession().getAttribute("accountPhone").toString()%>></p>
        <p>Status: <%= request.getSession().getAttribute("accountStatus").toString()%></p>
        <p>Role: <%= request.getSession().getAttribute("accountRole").toString()%></p>

      <%!
          String renderUser(HttpSession session) {
              StringBuilder result = new StringBuilder();
              List<Account> userAccounts = (List<Account>) session.getAttribute("listAccountByUser");
              for (Account account : userAccounts) {
                  StringBuilder sb = new StringBuilder();
                  String status = account.getStatus() == 1 ? "Active" : account.getStatus() == 0 ? "Inactive" : "Deleted";
                  sb.append("<tr>");
                  sb.append("<td>").append(account.getAccountId()).append("</td>");
                  sb.append("<td>").append(account.getFullName()).append("</td>");
                  sb.append("<td>").append(account.getEmail()).append("</td>");
                  sb.append("<td>").append(account.getPhone()).append("</td>");
                  sb.append("<td>").append(status).append("</td>");
                  sb.append("<td>" + "User role" + "</td>");
                  sb.append("<td>");
                  sb.append("<form action=\".\\controller\" method=\"POST\">");
//                  sb.append("<input type=\"submit\" value=\"add\" name=\"action\">");
                  sb.append("<input type=\"submit\" value=\"update\" name=\"action\">");
                  sb.append("<input type=\"submit\" value=\"delete\" name=\"action\">");
                  sb.append("<input type=\"hidden\" name=\"accountId\" value=\"").append(account.getAccountId()).append("\">");
                  sb.append("</form>");
                  sb.append("</td>");
                  sb.append("</tr>");
                  result.append(sb.toString());
              }
              return result.toString();
          }
      %>



        <h3>List of user role under the table</h3>
        <a href="createAccount.jsp">Add Account</a>
      <table border="1" style="width: 100%; height: auto; justify-content: center">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Status</th>
          <th>Role</th>
          <th>Option</th>
        </tr>
        <tbody style="text-align: center">
            <%=renderUser(session)%>
        </tbody>
      </table>
      <form action="./controller" method="POST">
          <input type="submit" name="action" value="logout">
          <input type="hidden" name="accountId" value=<%=request.getSession().getAttribute("accountId").toString()%> />
      </form>


  </body>
</html>
