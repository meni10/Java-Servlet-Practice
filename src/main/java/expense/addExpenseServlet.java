package expense;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addExpense")
public class addExpenseServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String exp_name = req.getParameter("expenseName");
	String amount = req.getParameter("amount");
	String category = req.getParameter("category");
	String date = req.getParameter("expenseDate");
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	String sql = "Insert into expenses (expense_name,amount,expense_date,category) values (?,?,?,?)";
	
	try(Connection con = expenseDAO.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)){
		
		ps.setString(1, exp_name);
		ps.setString(2, amount);
		ps.setString(3, date);
		ps.setString(4, category);	
		
		int rs = ps.executeUpdate();
		
		req.getRequestDispatcher("success.jsp").forward(req, resp);
		}
	catch(Exception e) {
		e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        out.println("Please try again.");
	}

}
	

}
