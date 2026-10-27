package contactmanager;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewcontact")
public class viewcontactServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String sql = "Select * from contactmanager";
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		try(Connection con = DBConnection.getConnection();
				java.sql.Statement st = con.createStatement();
				){
					ResultSet rs = st.executeQuery(sql);
					
					List<Map<String,Object>> contacts = new ArrayList<>();
					
					while(rs.next()) {
						
						Map<String, Object> contact = new HashMap<>();
						
						contact.put("id",rs.getInt("id"));
						contact.put("fullname",rs.getString("fullname"));
						contact.put("email", rs.getString("email"));
						contact.put("phoneno",rs.getString("phoneno"));
						contact.put("address",rs.getString("address"));
						
						contacts.add(contact);
						
						
						
					}
					req.setAttribute("contacts", contacts);
					req.getRequestDispatcher("viewcontact.jsp").forward(req, resp);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("please try again!");
		}
	}
}
