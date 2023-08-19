<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<%
		String msg = (String) request.getAttribute("msg");
	%>
	<form action="UserCtl" method="post">
		<table>
			<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
							<h1> 
			
			<p style="background-color: pink;">RAYS TECHNOLOGIES</p>
            <div style="background-color: lightblue;">PLACMENT IN IT COMPANY</div>
			
			<p style="color: blue;"> Register Below Side</p>
			<p style="color: #0000FF;">KHUSHALI RATHORE </p>
			
				</h1>
				
			</tr>
			<tr>
				<th>First_Name :</th>
				<td><input type="text" name="First_Name"></td>
			</tr>
			<tr>
				<th>Last_Name :</th>
				<td><input type="text" name="Last_Name"></td>
			</tr>
			<tr>
				<th>Login_Id :</th>
				<td><input type="text" name="Login_Id"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="password" name="Password"></td>
			</tr>
			<tr>
				<th>DOB :</th>
				<td><input type="date" name="DOB"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="Address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="SignUp">
					<input type="submit" name="operation" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>