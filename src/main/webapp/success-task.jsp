
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Saved Successfully</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f1f5f9;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .success-card {
            background-color: white;
            width: 90%;
            max-width: 450px;
            padding: 40px 30px;
            text-align: center;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.08);
        }

        .success-icon {
            width: 65px;
            height: 65px;
            line-height: 65px;
            margin: 0 auto 20px;
            border-radius: 50%;
            background-color: #dcfce7;
            color: #15803d;
            font-size: 35px;
            font-weight: bold;
        }

        h1 {
            color: #245b49;
            font-size: 25px;
            margin-bottom: 15px;
        }

        p {
            color: #64748b;
            font-size: 15px;
            line-height: 1.6;
            margin-bottom: 25px;
        }

        .btn {
            display: inline-block;
            background-color: #28785b;
            color: white;
            padding: 13px 22px;
            text-decoration: none;
            border-radius: 6px;
            font-size: 15px;
            font-weight: bold;
        }

        .btn:hover {
            background-color: #1d5c45;
        }
    </style>
</head>

<body>

    <div class="success-card">

        <div class="success-icon">&#10003;</div>

        <h1><%="Records successfully added!" %></h1>

        <p>Your task has been saved successfully. Keep organizing your day!</p>

        <a href="addtask.html" class="btn">Add Another Task</a>

    </div>

</body>
</html>
