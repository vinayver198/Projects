<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="RegisterServlet?action=Register" method="post">

<h2 align="center">Register New User</h2>


<h3 align="center">On Submission, you will receive a verification code for activation.</h3>


<table align="center">
<tr>
<td></td><td>First Name</td><td>Middle Name</td><td>Last Name</td>
</tr>
<tr>
<td>Name:</td>
<td><input pattern="[A-Z][a-z]{,33}" required name="fName" placeholder="Shubham"></td>
<td><input pattern="[A-Z][a-z]{,33}" required name="mName" placeholder="Kumar"></td>
<td><input pattern="[A-Z][a-z]{,33}" required name="lName" placeholder="Awasthi"></td>
</tr>
<tr>
<td>Business Name:</td>
<td colspan="2"><input pattern="[A-Z][a-z]{,100}" required  name="bName"></td>
</tr>
<tr>
<td>Email-Id:</td>
<td colspan="2"><input name="eMail" required></td>
</tr>
<tr>
<td>Mobile No:</td>
<td><input type="number" required name="Mnumber" pattern="[0-9]{10}"></td></tr>
<tr>
<td></td><td></td><td></td>
<td><input type="submit" value="Register"/>  <input type="reset" value="Reset"/></td>
</tr>
</table>
</form>

</body>
</html>