package com.bank.servlet;

import com.bank.dao.CustomerDAO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int customerId = Integer.parseInt(request.getParameter("customer_id"));

            boolean deleted = customerDAO.deleteCustomer(customerId);

            if (deleted) {
                response.sendRedirect("admin-dashboard.jsp?message=Customer deleted successfully");
            } else {
                response.sendRedirect("admin-dashboard.jsp?error=Failed to delete customer");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("admin-dashboard.jsp?error=Invalid customer ID format");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("admin-dashboard.jsp?error=Database connection problem");
        }
    }
}
