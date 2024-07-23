<!DOCTYPE html>
<html>
<head>
    <title>Modify Customer</title>
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
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container input[type="text"],
        .form-container input[type="number"],
        .form-container input[type="email"],
        .form-container input[type="date"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: #ffffff;
            font-size: 16px;
        }
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Modify Customer Details</h1>
    </div>
    <div class="content">
        <div class="form-container">
            <form action="ModifyCustomerServlet" method="post">
                <input type="text" name="customer_id" value="${customer.id}">
                <input type="text" name="full_name" placeholder="Full Name" value="${customer.full_name}" required>
                <input type="text" name="address" placeholder="Address" value="${customer.address}" required>
                <input type="text" name="mobile_no" placeholder="Mobile Number" value="${customer.mobile_no}" required>
                <input type="email" name="email_id" placeholder="Email ID" value="${customer.email_id}" required>
                <select name="account_type" required>
                    <option value="Saving" ${customer.account_type == 'Saving' ? 'selected' : ''}>Saving Account</option>
                    <option value="Current" ${customer.account_type == 'Current' ? 'selected' : ''}>Current Account</option>
                </select>
                <input type="number" name="initial_balance" placeholder="Initial Balance (min 1000)" value="${customer.initial_balance}" required min="1000">
                <input type="date" name="date_of_birth" value="${customer.date_of_birth}" required>
                <select name="id_proof_type" required>
                    <option value="Pan Card" ${customer.id_proof_type == 'Pan Card' ? 'selected' : ''}>Pan Card</option>
                    <option value="Aadhar Card" ${customer.id_proof_type == 'Aadhar Card' ? 'selected' : ''}>Aadhar Card</option>
                    <option value="Driving License" ${customer.id_proof_type == 'Driving License' ? 'selected' : ''}>Driving License</option>
                </select>
                <input type="text" name="id_proof_number" placeholder="ID Proof Number" value="${customer.id_proof_number}" required>
                <input type="submit" value="Update Customer">
            </form>
        </div>
    </div>
</body>
</html>
