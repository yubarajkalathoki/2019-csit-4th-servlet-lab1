<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="test1234.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User View</title>
</head>
<body>
	<h1>User List</h1>
	<table>
		<tr>
			<th>S.N.</th>
			<th>Full Name</th>
			<th>Username</th>
		</tr>
		<%
			List<UserBean> us = (List<UserBean>) request.getAttribute("users");
			for (int i = 0; i < us.size(); i++) {
		%>
		<tr>
			<td><%out.print(i+1);%></td>
			<td><%=us.get(i).getFullName()%></td>
			<td><%=us.get(i).getUsername()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>