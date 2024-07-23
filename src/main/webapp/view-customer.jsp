<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .header {
            background-color: #007bff;
            color: white;
            padding: 10px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .header h1 {
            margin: 0;
        }
        .content {
            padding: 20px;
        }
        .content h2 {
            color: #333;
        }
        .content p {
            font-size: 16px;
            line-height: 1.5;
            color: #666;
        }
        .content .customer-details {
            margin-top: 20px;
        }
        .content .customer-details dt {
            font-weight: bold;
        }
        .content .customer-details dd {
            margin: 0 0 10px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Customer Details</h1>
        </div>
        <div class="content">
            <h2>Customer Information</h2>
            <div class="customer-details">
                <dl>
                    <dt>Full Name:</dt>
                    <dd>${customer.fullName}</dd>
                    <dt>Address:</dt>
                    <dd>${customer.address}</dd>
                    <dt>Mobile No:</dt>
                    <dd>${customer.mobileNo}</dd>
                    <dt>Email ID:</dt>
                    <dd>${customer.emailId}</dd>
                    <dt>Account Type:</dt>
                    <dd>${customer.accountType}</dd>
                    <dt>Initial Balance:</dt>
                    <dd>${customer.initialBalance}</dd>
                    <dt>Date of Birth:</dt>
                    <dd>${customer.dob}</dd>
                    <dt>ID Proof Type:</dt>
                    <dd>${customer.idProofType}</dd>
                    <dt>ID Proof Number:</dt>
                    <dd>${customer.idProofNumber}</dd>
                    <dt>Account No:</dt>
                    <dd>${customer.accountNo}</dd>
                </dl>
            </div>
        </div>
    </div>
</body>
</html>
