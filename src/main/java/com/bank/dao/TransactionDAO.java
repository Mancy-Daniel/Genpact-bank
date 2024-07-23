package com.bank.dao;

import com.bank.model.Transaction;

import com.bank.util.DBUtil;

//import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
	
	
	public boolean insertTransaction(Transaction transaction) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO Transactions (account_no, amount, transaction_type) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, transaction.getAccountNo());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getTransactionType());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        }
    }
    
	 public boolean addTransaction(Transaction transaction) throws SQLException, ClassNotFoundException {
	        String insertQuery = "INSERT INTO Transactions (account_no, amount, transaction_type) VALUES (?, ?, ?)";
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            preparedStatement.setString(1, transaction.getAccountNo());
	            preparedStatement.setDouble(2, transaction.getAmount());
	            preparedStatement.setString(3, transaction.getTransactionType());

	            int rowsInserted = preparedStatement.executeUpdate();
	            return rowsInserted > 0;
	        }
	    }

	    public boolean updateCustomerBalance(String accountNo, double amount) throws SQLException, ClassNotFoundException {
	        String updateQuery = "UPDATE Customers SET initial_balance = initial_balance + ? WHERE account_no = ?";
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	            preparedStatement.setDouble(1, amount);
	            preparedStatement.setString(2, accountNo);

	            int rowsUpdated = preparedStatement.executeUpdate();
	            return rowsUpdated > 0;
	        }
	    }
	    
	    public List<Transaction> getTransactionsByAccountNo(String accountNo) throws SQLException, ClassNotFoundException {
	        String selectQuery = "SELECT * FROM Transactions WHERE account_no=?";
	        List<Transaction> transactions = new ArrayList<>();

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setString(1, accountNo);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Transaction transaction = new Transaction(
	                        resultSet.getInt("id"),
	                        resultSet.getString("account_no"),
	                        resultSet.getTimestamp("transaction_date"),
	                        resultSet.getDouble("amount"),
	                        resultSet.getString("transaction_type")
	                );
	                transactions.add(transaction);
	            }
	        }
	        return transactions;
	    }
    // Add methods for withdrawal, transaction history, etc. as needed
}
