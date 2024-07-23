<!DOCTYPE html>
<html>
<head>
    <title>Register Customer</title>
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
        <h1>Register Customer</h1>
    </div>
    <div class="content">
        <h2>Enter Customer Details</h2>
        <div class="form-container">
            <form action="RegisterCustomerServlet" method="post">
                <input type="text" name="full_name" placeholder="Full Name" required>
                <input type="text" name="address" placeholder="Address" required>
                <input type="text" name="mobile_no" placeholder="Mobile Number" required>
                <input type="email" name="email_id" placeholder="Email ID" required>
                <select name="account_type" required>
                    <option value="" disabled selected>Select Account Type</option>
                    <option value="Saving">Saving Account</option>
                    <option value="Current">Current Account</option>
                </select>
                <input type="number" name="initial_balance" placeholder="Initial Balance (min 1000)" required min="1000">
                <input type="date" name="date_of_birth" required>
                <select name="id_proof_type" required>
                    <option value="" disabled selected>Select ID Proof Type</option>
                    <option value="Pan Card">Pan Card</option>
                    <option value="Aadhar Card">Aadhar Card</option>
                    <option value="Driving License">Driving License</option>
                </select>
                <input type="text" name="id_proof_number" placeholder="ID Proof Number" required>
                <input type="submit" value="Register Customer">
            </form>
        </div>
    </div>
</body>
</html>
