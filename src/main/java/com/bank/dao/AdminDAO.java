package com.bank.dao;

import com.bank.model.Admin;
import com.bank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	
	private Connection connection;

    public AdminDAO(Connection connection2) {
        this.connection = DBUtil.getConnection();
    }
	
	
    public Admin getByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException {
        Admin admin = null;
        String query = "SELECT * FROM Admins WHERE username = ? AND password = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin(resultSet.getString("username"), resultSet.getString("password"));
            }
        }
        return admin;
    }
    
    
    
    
    public Admin getAdminByUsername(String username) {
        Admin admin = null;
        String query = "SELECT * FROM admins WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                admin = new Admin(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public boolean changePassword(String username, String currentPassword, String newPassword) {
        try {
            Admin admin = getAdminByUsername(username);
            if (admin != null && admin.getPassword().equals(currentPassword)) {
                String updateQuery = "UPDATE admins SET password = ? WHERE username = ?";
                try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
                    ps.setString(1, newPassword);
                    ps.setString(2, username);
                    int rowsUpdated = ps.executeUpdate();
                    return rowsUpdated > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
