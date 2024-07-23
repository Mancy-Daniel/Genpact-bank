package com.bank.servlet;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        String address = request.getParameter("address");
        String mobileNo = request.getParameter("mobile_no");
        String emailId = request.getParameter("email_id");
        String accountType = request.getParameter("account_type");
        double initialBalance = Double.parseDouble(request.getParameter("initial_balance"));
        String dob = request.getParameter("date_of_birth");
        String idProofType = request.getParameter("id_proof_type");
        String idProofNumber = request.getParameter("id_proof_number");

        // Generate account number and password
        String accountNo = generateAccountNumber();
        String password = generatePassword();

        // Create customer object
        Customer customer = new Customer(fullName, address, mobileNo, emailId, accountType, initialBalance, dob, idProofType, idProofNumber, accountNo, password);

        try {
            boolean isRegistered = customerDAO.registerCustomer(customer);
            if (isRegistered) {
                response.sendRedirect("admin-dashboard.jsp?message=Customer registered successfully");
            } else {
                response.sendRedirect("register-customer.jsp?error=Registration failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection problem");
        }
    }

    private String generateAccountNumber() {
    	 // Generate a random 10-digit account number
        Random random = new Random();
        int num = random.nextInt(900000000) + 100000000; // Generates a number between 100000000 and 999999999
        return String.valueOf(num);
    }

    private String generatePassword() {
    	// Generate a random 8-character password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }
}
