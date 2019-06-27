
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test1234.DatabaseConnection;
import java.sql.*;
/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Signup servlet ma aayo<br/>");
		
		String fullName = request.getParameter("fn");
		String username = request.getParameter("un");
		String password = request.getParameter("pw");
		out.print("<br/>fullname is "+fullName);
		out.print("<br/>username is "+username);
		out.print("<br/>password is "+password);
		
		DatabaseConnection dc = new DatabaseConnection();
		
		Connection cn = dc.getConnection();
		
		try {
			String sql = "insert into user (fullName,username,password) values (?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, fullName);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.executeUpdate();
			out.print("Inserted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
