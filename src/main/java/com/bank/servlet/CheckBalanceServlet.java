package com.bank.servlet;

import com.bank.dao.CustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CheckBalanceServlet")
public class CheckBalanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("account_no");

        try {
            double balance = customerDAO.getBalanceByAccountNo(accountNo);
            request.setAttribute("balance", balance);
            request.setAttribute("accountNo", accountNo);
            request.getRequestDispatcher("check-balance.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection problem");
        }
    }
}
