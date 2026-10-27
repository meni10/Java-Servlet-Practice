package contactmanager;

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

@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		String Sql = "Delete from contactmanager where id = ?";
		
		PrintWriter out = resp.getWriter();
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(Sql);){
			
					int contactId = Integer.parseInt(id);
					ps.setInt(1, contactId);
					
					int rs = ps.executeUpdate();
					
					req.getRequestDispatcher("success-contact.jsp").forward(req, resp);
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("please try again!");
		}
	}

}
