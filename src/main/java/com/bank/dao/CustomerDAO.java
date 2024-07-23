package com.bank.dao;

import com.bank.model.Customer;


import com.bank.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	
	 public Customer login(String accountNo, String password) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Customer customer = null;
	        
	        try {
	            conn = DBUtil.getConnection();
	            String sql = "SELECT * FROM Customers WHERE account_no = ? AND password = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, accountNo);
	            stmt.setString(2, password);
	            rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                customer = new Customer();
	                customer.setCustomerId(rs.getInt("customerId")); // Make sure the method names match those in the Customer class
	                customer.setAccountNo(rs.getString("accountNo"));
	                customer.setFullName(rs.getString("fullName"));
	                customer.setEmailId(rs.getString("emailId"));
	                customer.setMobileNo(rs.getString("mobileNo"));
	                customer.setAddress(rs.getString("address"));
	                customer.setInitialBalance(rs.getDouble("initialBalance"));   
	            }
	        } 
	        catch (SQLException ex) {
	            ex.printStackTrace();
	            // Handle exception (log or throw runtime exception)
	        } finally {
	            DBUtil.closeConnection(conn, stmt, rs);
	        }
	        
	        return customer;
	    }
	
	
	
    public boolean registerCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO Customers (full_name, address, mobile_no, email_id, account_type, initial_balance, date_of_birth, id_proof_type, id_proof_number, account_no, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getMobileNo());
            preparedStatement.setString(4, customer.getEmailId());
            preparedStatement.setString(5, customer.getAccountType());
            preparedStatement.setDouble(6, customer.getInitialBalance());
            preparedStatement.setString(7, customer.getDob());
            preparedStatement.setString(8, customer.getIdProofType());
            preparedStatement.setString(9, customer.getIdProofNumber());
            preparedStatement.setString(10, customer.getAccountNo());
            preparedStatement.setString(11, customer.getPassword());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        }
    }
    
    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String updateQuery = "UPDATE Customers SET full_name=?, address=?, mobile_no=?, email_id=?, account_type=?, initial_balance=?, date_of_birth=?, id_proof_type=?, id_proof_number=? WHERE id=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getMobileNo());
            preparedStatement.setString(4, customer.getEmailId());
            preparedStatement.setString(5, customer.getAccountType());
            preparedStatement.setDouble(6, customer.getInitialBalance());
            preparedStatement.setString(7, customer.getDob());
            preparedStatement.setString(8, customer.getIdProofType());
            preparedStatement.setString(9, customer.getIdProofNumber());
            preparedStatement.setInt(10, customer.getCustomerId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        }
    }
    
    public boolean deleteCustomer(int customerId) throws SQLException, ClassNotFoundException {
        String deleteQuery = "DELETE FROM Customers WHERE id=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, customerId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
   
    
    
    public double getBalanceByAccountNo(String accountNo) throws SQLException, ClassNotFoundException {
        String selectQuery = "SELECT initial_balance FROM Customers WHERE account_no=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("initial_balance");
            } else {
                throw new SQLException("Account not found");
            }
        }
    }

    public boolean updateBalance(String accountNo, double newBalance) throws SQLException, ClassNotFoundException {
        String updateQuery = "UPDATE Customers SET initial_balance=? WHERE account_no=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, accountNo);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        }
    }
    
    public boolean verifyCustomer(String customerId, String password) {
        String query = "SELECT * FROM customers WHERE id = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customerId);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if customer exists with given credentials
            }
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception as needed
            return false;
        }
    }

    // Method to update customer password
    public boolean updatePassword(String customerId, String newPassword) {
        String query = "UPDATE customers SET password = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, customerId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Returns true if password updated successfully
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception as needed
            return false;
        }
    }



    public boolean customerExists(String customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM customers WHERE customerId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    exists = true; // Customer exists
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return exists;
    }
    
    
    public Customer getCustomerById(int customerId) throws SQLException, ClassNotFoundException {
        String selectQuery = "SELECT * FROM Customers WHERE id=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setFullName(resultSet.getString("full_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setMobileNo(resultSet.getString("mobile_no"));
                customer.setEmailId(resultSet.getString("email_id"));
                customer.setAccountType(resultSet.getString("account_type"));
                customer.setInitialBalance(resultSet.getDouble("initial_balance"));
                customer.setDob(resultSet.getString("date_of_birth"));
                customer.setIdProofType(resultSet.getString("id_proof_type"));
                customer.setIdProofNumber(resultSet.getString("id_proof_number"));
                customer.setAccountNo(resultSet.getString("account_no"));
                return customer;
            } else {
                return null;
            }
        }
    }
    
}
