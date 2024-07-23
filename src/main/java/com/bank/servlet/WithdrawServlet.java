package com.bank.servlet;

import com.bank.dao.CustomerDAO;
import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;
    private TransactionDAO transactionDAO;

    public void init() {
        customerDAO = new CustomerDAO();
        transactionDAO = new TransactionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("account_no");
        double amount = Double.parseDouble(request.getParameter("amount"));

        try {
            double currentBalance = customerDAO.getBalanceByAccountNo(accountNo);

            if (currentBalance >= amount) {
                // Record the withdrawal transaction
                Transaction transaction = new Transaction(accountNo, amount, "Withdrawal");
                boolean transactionSuccess = transactionDAO.insertTransaction(transaction);

                // Update the customer's balance
                if (transactionSuccess) {
                    boolean balanceUpdated = customerDAO.updateBalance(accountNo, currentBalance - amount);
                    if (balanceUpdated) {
                        response.sendRedirect("withdraw-money.jsp?message=Withdrawal successful");
                    } else {
                        response.sendRedirect("withdraw-money.jsp?error=Failed to update balance");
                    }
                } else {
                    response.sendRedirect("withdraw-money.jsp?error=Failed to record transaction");
                }
            } else {
                response.sendRedirect("withdraw-money.jsp?error=Insufficient funds");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection problem");
        }
    }
}
