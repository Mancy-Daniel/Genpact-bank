<!DOCTYPE html>
<html>
<head>
    <title>Delete Customer</title>
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
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #dc3545;
            border: none;
            border-radius: 5px;
            color: #ffffff;
            font-size: 16px;
        }
        .form-container input[type="submit"]:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Delete Customer</h1>
    </div>
    <div class="content">
        <div class="form-container">
            <h2>Are you sure you want to delete this customer?</h2>
            <p>Deleting this customer will permanently remove all their details.</p>
            <form action="DeleteCustomerServlet" method="post">
                <input type="text" name="customer_id" value="${customer.id}">
                <input type="submit" value="Delete Customer">
            </form>
        </div>
    </div>
</body>
</html>
