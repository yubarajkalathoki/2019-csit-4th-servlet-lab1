
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");

		String username = request.getParameter("un");
		String password = request.getParameter("pw");

		//connect to database if needed
		
		PrintWriter out = response.getWriter();
		out.println("username is: " + username);
		out.println("Password is: " + password);
		out.print("</br>");
		out.print("</br>");

		if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
			// send to login success page
//			response.sendRedirect("./loginSuccess.html");
//			response.sendRedirect("./success");
			RequestDispatcher rd = request.getRequestDispatcher("./success");
//			rd.forward(request, response);
			rd.include(request, response);
		} else {
			// send to login failed page
			response.sendRedirect("./loginFailed.html");
		}
	}

}
