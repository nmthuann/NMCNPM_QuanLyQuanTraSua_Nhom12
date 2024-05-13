<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Account</title>
</head>
<body>
	<table class="table table-hover">
	<tr>
		<th>Username</th>
		<th>pass</th>
		<th>role</th>
	</tr>
	
	<c:forEach var="u" items="${employeeaccounts}">
	<tr>
		<td> ${u.userName} </td>
		<td> ${u.password}</td>
		<td> ${u.role}</td> 
	</tr>
	</c:forEach>
	</table>
</body>
</html>