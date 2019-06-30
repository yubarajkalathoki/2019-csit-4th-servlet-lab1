
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1234.DatabaseConnection;
import test1234.UserBean;
/**
 * Servlet implementation class UserViewServlet
 */
public class UserViewServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		DatabaseConnection dc = new DatabaseConnection();
		Connection cn = dc.getConnection();
		String sql = "Select * from user";
		try {
			Statement stat = cn.createStatement();
			ResultSet rs =stat.executeQuery(sql);
			List<UserBean> userBeans = new ArrayList<>();
			while(rs.next()) {
				UserBean ub = new UserBean();
				ub.setFullName(rs.getString("fullName"));
				ub.setId(rs.getInt("id"));
				ub.setUsername(rs.getString("username"));
				userBeans.add(ub);
			}
			System.out.println("Total User: "+userBeans.size());
			request.setAttribute("users", userBeans);
			RequestDispatcher rd = request.getRequestDispatcher("./userView.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
