package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		
		System.out.println("in second  servlet do Get"+ name  );
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name =req.getParameter("name");
		
		
	req.setAttribute("surname", "sharma");
	String surname = (String) req.getAttribute("surname");
		System.out.println("in second servlet do post " + name + surname );
		

		resp.sendRedirect("FirstServlet");
		
	
	}

}
