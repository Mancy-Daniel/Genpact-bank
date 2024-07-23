<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Transactions</title>
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
            border: 1px solid black;
        }
        th, td {
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
        <h1>View Transactions</h1>
        <form action="TransactionViewServlet" method="post">
            <div class="form-group">
                <label for="account_no">Account Number</label>
                <input type="text" id="account_no" name="account_no" required>
            </div>
            <div class="form-group">
                <button type="submit">View Transactions</button>
            </div>
        </form>

        <c:if test="${not empty transactions}">
            <h2>Transactions for Account Number: ${accountNo}</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Transaction Date</th>
                    <th>Amount</th>
                    <th>Transaction Type</th>
                </tr>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${transaction.transactionDate}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.transactionType}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty transactions}">
            <p>No transactions found for the provided account number.</p>
        </c:if>
    </div>
</body>
</html>
