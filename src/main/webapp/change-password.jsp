<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            width: 300px;
            text-align: center;
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label, input {
            margin: 10px 0;
            width: 100%;
        }
        .btn {
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .error, .message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Change Password</h1>
        <form action="ChangePasswordServlet" method="post">
            <label for="current_password">Current Password:</label>
            <input type="password" id="current_password" name="current_password" required>
            
            <label for="new_password">New Password:</label>
            <input type="password" id="new_password" name="new_password" required>
            
            <label for="confirm_password">Confirm New Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
            
            <button type="submit" class="btn">Change Password</button>
        </form>
        <% 
            String error = request.getParameter("error");
            String message = request.getParameter("message");
            if (error != null && !error.isEmpty()) { 
        %>
            <p class="error"><%= error %></p>
        <% 
            } 
            if (message != null && !message.isEmpty()) { 
        %>
            <p class="message"><%= message %></p>
        <% 
            } 
        %>
    </div>
</body>
</html>
