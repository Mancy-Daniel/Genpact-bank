package com.bank.servlet;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("account_no");
        double amount = Double.parseDouble(request.getParameter("amount"));

        Transaction transaction = new Transaction(0, accountNo, null, amount, "Deposit");
        TransactionDAO transactionDAO = new TransactionDAO();

        try {
            boolean transactionAdded = transactionDAO.addTransaction(transaction);
            boolean balanceUpdated = transactionDAO.updateCustomerBalance(accountNo, amount);

            if (transactionAdded && balanceUpdated) {
                response.sendRedirect("customer-dashboard.jsp?message=Deposit successful");
            } else {
                response.sendRedirect("deposit.jsp?error=Failed to process deposit");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection problem");
        }
    }
}
