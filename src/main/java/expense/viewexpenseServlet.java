package expense;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todolist.DBConnection;

@WebServlet("/viewexpense")
public class viewexpenseServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sql =  "Select * from expenses";
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		try(Connection con = expenseDAO.getConnection();
				Statement st = con.createStatement();
				){
				ResultSet rs = st.executeQuery(sql);
				
				List<Map<String,Object>> exps = new ArrayList<>();
				
				while(rs.next()) {
					
					Map<String,Object> exp = new HashMap<>();
					
					exp.put("id", rs.getInt("id"));
					exp.put("expense_name",rs.getString("expense_name"));
					exp.put("amount",rs.getString("amount"));
					exp.put("expense_date",rs.getString("expense_date"));
					exp.put("category",rs.getString("category"));
					
					exps.add(exp);
				}
				req.setAttribute("exps", exps);
				req.getRequestDispatcher("/viewExpense.jsp").forward(req, resp);
				
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("please try again!");
			
		}
	}

}
