<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully Submitted</title>
</head>
<body>

<h2 align="center">Your firm is successfully registered.</h2>
<br>
<h2 align="center">Activate your account with following activation code.</h2>
<br>
 <h4 align="center">${ActivationCode}</h4>
<br>
<p align="center">
<a href="RegisterServlet?action=GoHome">Home</a>
</p>






</body>
</html>