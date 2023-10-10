

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Viewdata")
public class Viewdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			JdbcConnection.createConnection();
		
			ResultSet content = JdbcConnection.selectValues();
			out.println("<html></html>");
			out.println("<head><link rel='stylesheet' href='styles.css'></head>");
			out.println("<body class='main'></body>");
			out.println("<table><tr><th>EmployeeId</th><th>EmployeeName</th><th>Salary</th></tr>");
			while(content.next()) {
				int id = content.getInt(1);
				String name = content.getString(2);
				double salary = content.getDouble(3);
				out.println("<tr><td>"+id+"</td><td>" + name + "</td><td>" + salary+"</td></tr>");
				}
			out.println("</table>");
			out.println("<a href='selection.html'><button class='home-button'>Home</button></a>");
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
