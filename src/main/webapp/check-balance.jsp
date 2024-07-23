<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check Balance</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 2px 2px 12px #aaa;
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
        }
        .form-group button {
            padding: 10px 20px;
            background-color: #5cb85c;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #4cae4c;
        }
        .balance {
            font-size: 20px;
            color: green;
            margin-top: 20px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Check Balance</h1>
        <form action="CheckBalanceServlet" method="post">
            <div class="form-group">
                <label for="account_no">Account Number</label>
                <input type="text" id="account_no" name="account_no" required>
            </div>
            <div class="form-group">
                <button type="submit">Check Balance</button>
            </div>
        </form>
        <%
            String accountNo = (String) request.getAttribute("accountNo");
            Double balance = (Double) request.getAttribute("balance");
            if (balance != null) {
        %>
            <p class="balance">The balance for account number <%= accountNo %> is <%= balance %></p>
        <%
            } else if (request.getAttribute("error") != null) {
        %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <%
            }
        %>
    </div>
</body>
</html>
