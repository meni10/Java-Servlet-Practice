<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Contacts</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            margin-top: 25px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #2c3e50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .message {
            text-align: center;
            color: #555;
            margin-top: 30px;
        }
    </style>
</head>
<body>

    <h2>Expense List</h2>
    
    
    <%
    	List<Map<String,Object>> expense = (List<Map<String,Object>>) request.getAttribute("exps");
    
    	if(expense!=null && !expense.isEmpty()){
    %>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Amount</th>
            <th>Expense Date</th>
            <th>Category</th>
        </tr>
        
        <% for(Map<String,Object> exp:expense) {%>
        
        <tr>
            <td><%= exp.get("id") %></td>
            <td><%= exp.get("expense_name") %></td>
            <td><%= exp.get("amount") %></td>
            <td><%= exp.get("expense_date") %></td>
            <td><%= exp.get("category") %></td>
        </tr>
        
        
        <%}%>
        
         </table>

    <%
        } else {
    %>

        <p class="message">No contacts found.</p>

    <%
        }
    %>
        
        
        

    

</body>
</html>
