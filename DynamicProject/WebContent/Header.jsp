<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<%  UserBean bean = (UserBean) request.getAttribute("user");

%>

<%
if (bean!= null){
	%>
	<h3>
	
		Hi,
	<%=bean.getFirstName()%></h3>
	<%
}else{
	
	%>
	<h3>hii, Guest</h3>
	<%
}
	%>

</body>
</html>