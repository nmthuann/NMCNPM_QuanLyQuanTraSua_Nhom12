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
<title>DANH SÁCH BÀN</title>
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
		<div class="row justify-content-md-center"></div>
		<div class="bg-light p-5 rounded">
			<div class="d-flex flex-row justify-content-between">
				<div>
					<span id="result1"></span>

					<form class="d-inline-flex">
						<div>
							<button name="btnShow" class="btn btn-success" type="submit">Show</button>
						</div>
						<div>
							<button name="btnFull" class="btn btn-outline-success"
								type="submit">Full</button>
						</div>
					</form>

				</div>
			</div>


			<table class="table table-hover">
				<tr>
					<th>ID</th>
					<th>Seat Number</th>
					<th>Status</th>
					<th>Update</th>
				</tr>
				<c:forEach var="s" items="${seats}">
					<tr>
						<td>${s.seatID}</td>
						<td>${s.seatNum}</td>
						<td><c:choose>
								<c:when test="${s.seatStatus == true}">Empty</c:when>
								<c:when test="${s.seatStatus == false}">Full</c:when>
							</c:choose></td>

						<!-- <td><a name="insert" href="#" role="button">
								<button type="button" name="insert" class="btn btn-warning">Insert</button>
						</a></td> -->
						<td><a href="admin/seat/${s.seatID}.htm?btnUpdate">
								<button name="btnUpdate" type="button" class="btn btn-warning">Update</button>
						</a></td>
<%-- 						<td><a name="btnEdit" href="#" role="button"><img
								width="50" height="40"
								src="<c:url value="/resources/images/edit.png"/>"></a> <a
							href="#">
								<button type="button" name="btnEdit" class="btn btn-primary">Edit</button>
						</a>
						<td><a name="btnDelete" href="#" role="button"><img
								width="30" height="30"
								src="<c:url value="/resources/images/delete.png"/>"></a> <a
							href="#">
								<button type="button" name="btnDelete" class="btn btn-danger">Delete</button>
						</a> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>