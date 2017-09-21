<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><b>Account Summary On</b></h1>
Thu Sep 17 15:05:58 IST 2017
<h3>Subscriber Id: ${sessionScope.costumer.subscriberId}</h3>
<br/>
<h3>Account Balance:${sessionScope.costumer.accountBalance}</h3>
<br/>
<h3>Recommended Recharge: ${sessionScope.reccomendedRecharge}</h3>
<br/>
Click Here To  <a href="recharge.jsp">Recharge Amount</a>



</body>
</html>