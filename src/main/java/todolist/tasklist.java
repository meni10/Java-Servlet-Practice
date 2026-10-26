package todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import expense.expenseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addTask")
public class tasklist extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String taskname = req.getParameter("taskName");
		String description = req.getParameter("description");
		String priority = req.getParameter("priority");
		String date = req.getParameter("dueDate");
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String sql = "Insert into task_manager(task_name,task_description,priority,duedate) values(?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, taskname);
			ps.setString(2, description);
			ps.setString(3, priority);
			ps.setString(4, date);
			
			int rs = ps.executeUpdate();
			
			req.getRequestDispatcher("success-task.jsp").forward(req, resp);
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
	        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        out.println("Please try again.");
			
			
		}
		
	}

}
