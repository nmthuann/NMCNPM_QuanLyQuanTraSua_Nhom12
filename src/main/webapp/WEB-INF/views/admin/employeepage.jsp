
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@include file="/WEB-INF/views/include/header.jsp"%> --%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">

<title>Danh Sach Nhan Vien</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">

<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css' />"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/resources/ckeditor/ckeditor.js' />">
	
</script>
<script type="text/javascript"
	src="<c:url value='/resources/ckfinder/ckfinder.js'  />">
	
</script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link
	href="<c:url value='/resources/assets/dist/starter-template.css' />"
	rel="stylesheet">
</head>
<body>
	<%@include file="/WEB-INF/views/include/menu.jsp"%>
	<main class="container ">
			${message}
		<div class="bg-light p-5 rounded">
			<div class="d-flex flex-row justify-content-between">
				<div>
					<span id="result1"></span>

					<form class="d-inline-flex">
						<input name="searchInput" id="searchInput"
							class="form-control me-2" type="search" placeholder="Search"
							aria-label="Search">
						<button name="btnSearch" id="btnSearch"
							class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>

		</div>
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>FirstName</th>
				<th>Gender</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Position Name</th>
				<th>Email</th>
				<th>StartDay</th>
				<th>Status</th>
				<th>Update</th>
				<th>Edit</th>

			</tr>
			<c:forEach var="em" items="${employees}">
				<tr>
					<td>${em.employeeID}</td>
					<td>${em.firstName}</td>
					<td>${em.lastName}</td>
					<td><c:choose>
							<c:when test="${em.gender == true}">Male</c:when>
							<c:when test="${em.gender == false}">Female</c:when>
						</c:choose></td>
					<td>${em.birthday}</td>
					<td>${ em.address}</td>
					<td>${em.phone}</td>
					<td>${em.position.positionName}</td>
					<td>${em.employeeaccountEntity.userName}</td>
					<td>${em.startDay}</td>
					<td><c:choose>
							<c:when test="${em.status == true}">Active</c:when>
							<c:when test="${em.status == false}">OFF</c:when>
						</c:choose></td>

					<!-- Update -->
					<td><a
						href="admin/employeepage/${em.employeeID}.htm?btnUpdate ">
							<button name="btnUpdate" type="button" class="btn btn-warning">Update</button>
					</a></td>

					<!-- Edit -->
					<td><a href="admin/employee-infor/${em.employeeID}.htm?linkEdit">
							<button type="button" name="btnEdit" class="btn btn-primary">Edit</button>
					</a>
				</tr>
			</c:forEach>
		</table>

		<script
			src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
	</main>
</body>
</html>