package contactmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addContact")
public class contactManagerServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fullname = req.getParameter("fullName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String sql = "Insert into contactmanager (fullname,email,phoneno,address) values(?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
					ps.setString(1, fullname);
					ps.setString(2, email);
					ps.setString(3, phone);
					ps.setString(4, address);
					
					int res = ps.executeUpdate();
					
					req.getRequestDispatcher("success-contact.jsp").forward(req, resp);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("please try again!");
		}
		
		
	}

}
