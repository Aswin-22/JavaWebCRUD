

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginControl extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		String name = request.getParameter("usr");
		String pass = request.getParameter("pwd");
		System.out.println(name + "     "+pass);
		
		if(name.equals("aswin") && pass.equals("123")) {
			RequestDispatcher rd = request.getRequestDispatcher("/selection.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
		
		
	}

}
