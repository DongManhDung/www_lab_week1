package iuh.edu.week1_lab01_dongmanhdung_21099401.controllers;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.*;
import iuh.edu.week1_lab01_dongmanhdung_21099401.services.AccountServices;
import iuh.edu.week1_lab01_dongmanhdung_21099401.services.LogService;
import iuh.edu.week1_lab01_dongmanhdung_21099401.services.RoleService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.time.Instant;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action").toLowerCase();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        AccountServices accountServices = new AccountServices();
        RoleService roleService = new RoleService();
        LogService logService = new LogService();

        switch (action) {
            case "login":
            {
                String account_id = req.getParameter("account_id");
                String password = req.getParameter("password");
                if (account_id != null && password != null) {
                    Account account = accountServices.getUsernameAndPassword(account_id, password);
                    Role role = roleService.getRoleOfAccount(account_id);
                    if (account != null && role != null) {
                        session.setAttribute("accountId", account.getAccountId());
                        session.setAttribute("accountName", account.getFullName());
                        session.setAttribute("accountEmail", account.getEmail());
                        session.setAttribute("accountPhone", account.getPhone());
                        session.setAttribute("accountStatus", account.getStatus() == 1 ? "active" : account.getStatus() == 0 ? "inactive" : "delete");
                        session.setAttribute("accountRole", role.getDescription());
                        Log log = new Log(account.getAccountId(), Instant.now(), null, "");
                        logService.addNewLog(log);
                        if (role.getRoleId().equalsIgnoreCase("admin")) {
                            List<Account> listAccountByUser = roleService.getAccountByRoleId("user");
                            session.setAttribute("listAccountByUser", listAccountByUser);
                            resp.sendRedirect("dashboard.jsp");
                        }
                        else {
                            resp.sendRedirect("user.jsp");
                        }
                    } else {
                        out.println("Username or password is incorrect");
                    }
                } else {
                    out.println("Login failed! Please enter information");
                }
                break;
            }
            case "add":
            {
                String accountId = req.getParameter("accountId");
                String fullName = req.getParameter("fullName");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String password = req.getParameter("password");
                String status = req.getParameter("status");
                if (accountId != null && fullName != null && email != null && phone != null && password != null && status  != null) {
                    Account account = new Account(accountId, fullName, password,email, phone, Byte.parseByte(status));
                    Role role = roleService.getRole("user");
                    GrantAccessId id = new GrantAccessId(role.getRoleId(), account.getAccountId());
                    GrantAccess grantAccess = new GrantAccess(id, role, account, true, "");
                    if (accountServices.createAccount(account, grantAccess)) {
                        session.setAttribute("listAccountByUser", roleService.getAccountByRoleId("user"));
                        resp.sendRedirect("dashboard.jsp");
                    } else {
                        out.println("Add account failed");
                    }
                } else {
                    out.println("Add account failed! Please enter information");
                }
                break;
            }
            case "delete": {
                String accountId = req.getParameter("accountId");
                if (accountId != null) {
                    if (accountServices.deleteAccount(accountId)) {
                        session.setAttribute("listAccountByUser", roleService.getAccountByRoleId("user"));
                        resp.sendRedirect("dashboard.jsp");
                        out.println("Delete account successfully");
                    } else {
                        out.println("Delete account failed");
                    }
                } else {
                    out.println("Delete account failed! Please enter information");
                }
                break;
            }

            case "update":{
                String accountId = req.getParameter("accountId");
                if(accountId != null){
                    Account account = accountServices.getAccountById(accountId);
                    if(account != null){
                        session.setAttribute("account", account);
                        resp.sendRedirect("updateAccount.jsp");
                    } else {
                        out.println("Account not exist");
                    }
                } else {
                    out.println("Update account failed! Please enter information");
                }
                break;
            }

            case "save": {
                String accountId = req.getParameter("accountId");
                String fullName = req.getParameter("fullName");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String password = req.getParameter("password");
                String status = req.getParameter("status");
                if (accountId != null && fullName != null && email != null && phone != null && password != null && status  != null) {
                    Account account = new Account(accountId, fullName, password,email, phone, Byte.parseByte(status));
                    if (accountServices.updateAccount(account)) {
                        session.setAttribute("listAccountByUser", roleService.getAccountByRoleId("user"));
                        resp.sendRedirect("dashboard.jsp");
                    } else {
                        out.println("Update account failed");
                    }
                } else {
                    out.println("Please enter information");
                }
                break;
            }

            case "logout": {
                String accountId = req.getParameter("accountId");
                Log log = logService.getLog(accountId);
                log.setLogoutTime(Instant.now());
                logService.updateLog(log);
                resp.sendRedirect("index.jsp");
                break;
            }
        }
    }
}
