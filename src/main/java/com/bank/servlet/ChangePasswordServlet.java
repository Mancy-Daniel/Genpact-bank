package com.bank.servlet;

import com.bank.dao.AdminDAO;
import com.bank.model.Admin;
import com.bank.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;

    @Override
    public void init() throws ServletException {
        adminDAO = new AdminDAO(DBUtil.getConnection());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPassword = request.getParameter("current_password");
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

        Admin admin = (Admin) request.getSession().getAttribute("admin");

        if (admin == null) {
            response.sendRedirect("customer-login.jsp");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            response.sendRedirect("change-password.jsp?error=Passwords do not match");
            return;
        }

        boolean isPasswordChanged = adminDAO.changePassword(admin.getUsername(), currentPassword, newPassword);

        if (isPasswordChanged) {
            response.sendRedirect("change-password.jsp?message=Password changed successfully");
        } else {
            response.sendRedirect("change-password.jsp?error=Current password is incorrect");
        }
    }
}
