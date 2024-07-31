<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.Transaction" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 2px 2px 12px #aaa;
            margin-top: 50px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Transaction History</h1>
        <form action="TransactionViewServlet" method="post">
            <div class="form-group">
                <label for="account_no">Account Number</label>
                <input type="text" id="account_no" name="account_no" required>
            </div>
            <div class="form-group">
                <button type="submit">View History</button>
            </div>
        </form>
        <%
            List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
            if (transactions != null && !transactions.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Transaction Date</th>
                        <th>Amount</th>
                        <th>Transaction Type</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Transaction transaction : transactions) {
                    %>
                    <tr>
                        <td><%= transaction.getId() %></td>
                        <td><%= transaction.getTransactionDate() %></td>
                        <td><%= transaction.getAmount() %></td>
                        <td><%= transaction.getTransactionType() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            } else if (transactions != null) {
        %>
            <p>No transactions found for this account number.</p>
        <%
            }
        %>
    </div>
</body>
</html>
