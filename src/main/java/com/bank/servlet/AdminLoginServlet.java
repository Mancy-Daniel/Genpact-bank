package com.bank.servlet;

import com.bank.dao.AdminDAO;
import com.bank.model.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;

    public void init() {
        adminDAO = new AdminDAO(null);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Admin admin = adminDAO.getByUsernameAndPassword(username, password);
            if (admin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin.getUsername());
                response.sendRedirect("admin-dashboard.jsp");
            } else {
                response.sendRedirect("admin-login.jsp?error=Invalid username or password");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.println("Database connection problem");
        }
    }
}
