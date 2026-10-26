
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Expense Added Successfully</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: Arial, sans-serif;
        background-color: #f1f5f3;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .success-card {
        background-color: white;
        width: 90%;
        max-width: 450px;
        padding: 40px 30px;
        text-align: center;
        border-radius: 14px;
        box-shadow: 0 5px 20px rgba(0, 0, 0, 0.08);
    }

    .success-icon {
        width: 65px;
        height: 65px;
        line-height: 65px;
        margin: 0 auto 20px;
        border-radius: 50%;
        background-color: #d9f5e5;
        color: #21845a;
        font-size: 35px;
        font-weight: bold;
    }

    h1 {
        color: #246b57;
        font-size: 25px;
        margin-bottom: 12px;
    }

    p {
        color: #68756e;
        font-size: 15px;
        margin-bottom: 28px;
        line-height: 1.6;
    }

    .btn {
        display: inline-block;
        background-color: #246b57;
        color: white;
        padding: 13px 22px;
        text-decoration: none;
        border-radius: 6px;
        font-size: 15px;
        font-weight: bold;
        transition: background-color 0.3s;
    }

    .btn:hover {
        background-color: #194f40;
    }

    @media (max-width: 480px) {
        .success-card {
            padding: 30px 20px;
        }

        h1 {
            font-size: 22px;
        }
    }
</style>
</head>

<body>
    <div class="success-card">
        <div class="success-icon">&#10003;</div>

        <h1>Expense Added Successfully!</h1>

        <p>Your expense has been saved successfully.</p>

        <a href="addExpense.html" class="btn">Add Another Expense</a>
    </div>
</body>
</html>
