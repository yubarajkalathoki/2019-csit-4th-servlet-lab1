<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup page!</title>
</head>
<body>


	<form action="./signup" method="post">
		<table>
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="un" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr>
			
			<td colspan="2" align="center"><input type="submit" value="Signup"/> </td>
			</tr>
		</table>
	</form>

</body>
</html>