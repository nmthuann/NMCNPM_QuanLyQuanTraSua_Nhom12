<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@include file="/WEB-INF/views/include/header.jsp"%> --%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>KHACH HANG</title>
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
		<div class="bg-light p-5 rounded">
			${message}
			<form:form class="row g-3" modelAttribute="customer"
				action="admin/customer.htm" method="POST">

				<!-- Insert - Edit  -->
				<div class="col-md-4">
					<label for="customerID" class="form-label">ID</label>
					<form:input path="customerID" class="form-control"
						placeholder="Customer Id" />
					<form:errors path="customerID"></form:errors>
				</div>
				<div class="col-md-4">
					<label for="customerName" class="form-label">Name</label>
					<form:input path="customerName" class="form-control"
						placeholder="Customer Name" />
					<form:errors path="customerName"></form:errors>
				</div>

				<div class="col-md-4 row-g-3">
					<button name="${btnStatus }" type="submit" class="btn btn-warning"
						style="margin-left: 40px; margin-top: 30px">Insert</button>
				</div>
			</form:form>
		</div>


		<!-- Search -->
		<div class="bg-light p-5 rounded">
			<div class="d-flex flex-row justify-content-between">
				<div>
					<span id="result1"></span>

					<form class="d-inline-flex">
						<input name="searchCustomerId"
							class="form-control me-2" type="search" placeholder="Search"
							aria-label="Search">

						<button name="btnSearch" id="searchCustomerId"
							class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>

			<table class="table table-hover">
				<tr>

					<th>ID</th>
					<th>Name</th>
					<th>Edit</th>
			<!-- 		<th>Edit</th>
					<th>Delete</th> -->
				</tr>
				<c:forEach var="c" items="${customers}">

					<tr>

						<td>${c.customerID}</td>
						<td>${c.customerName}</td>

						<td>
							<!-- name="btnEdit" --> <a
							href="admin/customer/${c.customerID}.htm?linkEdit" role="button">
								<img width="50" height="40"
								src="<c:url value="/resources/images/edit.png"/>">
						</a> <a href="admin/customer/${c.customerID}.htm?linkEdit">
								<button type="button" class="btn btn-primary">Edit</button>
						</a>

						</td>

						<%-- <td><a id="btnDelete"
						href="admin/delete/${c.customerID}.htm?linkDelete" role="button"><img
							width="30" height="30"
							src="<c:url value="/resources/images/delete.png"/>"></a> 
								<a href="admin/delete/${c.customerID}.htm"> 
								<button type="button" name="btnDelete"  class="btn btn-danger">Delete</button> </a> --%>
								
					</tr>

				</c:forEach>

			</table>

		</div>
	</main>
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>