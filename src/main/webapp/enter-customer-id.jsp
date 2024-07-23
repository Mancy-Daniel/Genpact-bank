<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Customer ID</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #007bff;
            color: white;
            padding: 20px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .header h1 {
            margin: 0;
        }
        .content {
            padding: 50px;
            text-align: center;
        }
        .content h2 {
            color: #333;
        }
        .form-container {
            margin-top: 20px;
        }
        .form-container input[type="text"] {
            padding: 10px;
            width: 200px;
            margin-right: 10px;
        }
        .form-container input[type="submit"] {
            padding: 10px 20px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Enter Customer ID</h1>
    </div>
    <div class="content">
        <h2>Enter the Customer ID to View Details</h2>
        <div class="form-container">
            <form action="viewCustomer" method="get">
                <input type="text" name="customerId" placeholder="Enter Customer ID" required>
                <input type="submit" value="View Customer">
            </form>
        </div>
    </div>
</body>
</html>
