package com.bank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        customerDAO = new CustomerDAO(); // Initialize your DAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountNo");
        String password = request.getParameter("password");

        Customer customer = customerDAO.login(accountNo, password);
        if (customer != null) {
            // Customer authenticated successfully
            HttpSession session = request.getSession();
            session.setAttribute("customerId", customer.getCustomerId());
            
            // Redirect to dashboard or other secure page
            response.sendRedirect("customer-dashboard.jsp");
        } else {
            // Authentication failed, redirect back to login page with error message
            response.sendRedirect("customer-login.jsp?error=Invalid credentials");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
