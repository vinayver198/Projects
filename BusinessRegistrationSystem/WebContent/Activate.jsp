<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet?action=Update" method="post">
<table align="center">
<h2 align="center">Activate your account</h2>
<tr>
<td>Email-Id</td>
<td><input required name="eMail"></td>
</tr>
<tr>
<td>Activation Code</td>
<td><input type="number" name="Acode"></td>
</tr>
<tr>
<td></td><td></td><td><input type="submit" value="Activate"><input type="reset"></td>
</tr>
</table>

<h2 align="center"> ${Error1}</h2>

</form>

</body>
</html>