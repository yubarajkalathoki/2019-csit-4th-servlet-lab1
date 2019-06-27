package test1234;

import java.sql.*;

public class DatabaseConnection {
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/2019_csit_fourth";
		String un = "root";
		String pw = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection(url, un, pw);
			System.out.println("Database Connected Successfully!");
			return cn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		DatabaseConnection dc = new DatabaseConnection();
		Connection cn = dc.getConnection();
	}
}
