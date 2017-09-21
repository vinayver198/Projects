<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form name="log" action="BillServlet?action=Login" method = "post">
		<table align= "center">
			<tr>
				<td><div align="right">Username:</div></td>
				<td><input type="text" name="username" required /></td>
			</tr>
			
			<tr>
				<td><div align="right">Password:</div></td>
				<td><input type="password" name="password" required /></td>
			</tr>
			<tr>
				<td colspan=2><div align="center"><input type="submit" value="Login"></div></td>
			</tr>
			
		</table>
	</form>
</body>
</html>