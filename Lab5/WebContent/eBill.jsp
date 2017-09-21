<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User Info Page</title>
</head>
<body>
	<form name="bill" action="BillServlet?action=Calculate Bill" method="post">
		<table align= "center">
			<tr>
				<td><div align="right">Consumer Number:</div></td>
				<td><input type="number" pattern="[0-9]{,10}" name="ConsumerNum" required></td>
			</tr>
			
			<tr>
				<td><div align="right">Last Month Meter Reading:</div></td>
				<td><input type="number" pattern="[0-9]{,10}" name="LMMR" required></td>
			</tr>
			
			<tr>
				<td><div align="right">Current Month Meter Reading:</div></td>
				<td><input type="number" pattern="[0-9]{,10}" name="CMMR" required></td>
			</tr>
			
			<tr>
				<td colspan=2><div align="center"><input type="submit" value="Calculate Bill"></div></td>
			</tr>
		</table>
	</form>
</body>
</html>