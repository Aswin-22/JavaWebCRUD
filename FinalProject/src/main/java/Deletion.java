

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deletion")
public class Deletion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("id");
		int id = Integer.parseInt(eid);
		JdbcConnection.createConnection();
		
		//call JDBC save method
		JdbcConnection.deleteRows(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/selection.html");
		rd.forward(request, response);
	}

}
