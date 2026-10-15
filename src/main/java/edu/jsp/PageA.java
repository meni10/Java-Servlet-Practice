package edu.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PageA extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=getServletContext();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>"+context.getInitParameter("name")+"</h1>");
		out.println("<h1>"+context.getInitParameter("gf")+"</h1>");
		
		ServletConfig config=getServletConfig();

		out.println("<h1>"+config.getInitParameter("king")+"</h1>");
        
	}

}
