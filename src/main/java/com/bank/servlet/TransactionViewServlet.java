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
import java.util.List;

@WebServlet("/TransactionViewServlet")
public class TransactionViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TransactionDAO transactionDAO;

    public void init() {
        transactionDAO = new TransactionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("account_no");

        try {
            List<Transaction> transactions = transactionDAO.getTransactionsByAccountNo(accountNo);
            request.setAttribute("transactions", transactions);
            request.setAttribute("accountNo", accountNo);
            request.getRequestDispatcher("view-transaction.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection problem");
        }
    }
}
