package com.bank.servlet;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyCustomerServlet")
public class ModifyCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        String fullName = request.getParameter("full_name");
        String address = request.getParameter("address");
        String mobileNo = request.getParameter("mobile_no");
        String emailId = request.getParameter("email_id");
        String accountType = request.getParameter("account_type");
        double initialBalance = Double.parseDouble(request.getParameter("initial_balance"));
        String dob = request.getParameter("date_of_birth");
        String idProofType = request.getParameter("id_proof_type");
        String idProofNumber = request.getParameter("id_proof_number");

        // Create customer object
        Customer customer = new Customer(customerId, fullName, address, mobileNo, emailId, accountType, initialBalance, dob, idProofType, idProofNumber);

        try {
            boolean isUpdated = customerDAO.updateCustomer(customer);
            if (isUpdated) {
                response.sendRedirect("admin-dashboard.jsp?message=Customer details updated successfully");
            } else {
                response.sendRedirect("modify-customer.jsp?error=Failed to update customer details");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection problem");
        }
    }
}
