package edu.jsp;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        ServletContext context = getServletContext();

        String college = (String) context.getAttribute("college");

        response.setContentType("text/html");
        response.getWriter().println("College Name: " + college);


	}	
}
