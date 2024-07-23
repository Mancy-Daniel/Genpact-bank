<!DOCTYPE html>
<html>
<head>
    <title>Customer Dashboard</title>
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
        .content p {
            font-size: 16px;
            line-height: 1.5;
            color: #666;
        }
        .nav {
            margin-top: 20px;
        }
        .nav a {
            margin: 0 10px;
            padding: 10px 20px;
            color: white;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 5px;
        }
        .nav a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Customer Dashboard</h1>
    </div>
    <div class="content">
        <h2>Welcome, Customer</h2>
        <p>You are now logged in. Use the navigation below to manage your account.</p>
        <div class="nav">
            <a href="deposit-money.jsp">Deposit</a>
            <a href="withdraw-money.jsp">Withdraw</a>
            <a href="check-balance.jsp">Check Balance</a>
            <a href="view-transaction.jsp">View Transaction</a>
            <a href="change-password.jsp">Change Password</a>
            <a href="#">Logout</a>
        </div>
    </div>
</body>
</html>
