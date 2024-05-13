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
<title>Chi Tiết Hóa đơn</title>
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
	<main class="container  ">
		<div class="row justify-content-md-center">
			<div class="d-flex flex-row justify-content-between">
				<div>
					<form:form class="row g-3" modelAttribute="detailbill"
						action="admin/detailbill.htm">
						<span id="result1"></span>
						<label for="exampleFormControlInput1" class="form-label">Bill</label>
						<form:select path="bill.billID" items="${bills}"
							itemValue="billID" itemLabel="billID"
							class="form-select form-select-lg mb-6"
							aria-label=".form-select-lg example">
						</form:select>
						<button name="btnFind" id="findDetailBil"
							class="btn btn-outline-success" type="submit">Find</button>
					</form:form>
				</div>

			</div>

			<%-- <c:set var="total" value="5" scope="session" /> --%>
			<table class="table table-hover">
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Size</th>
					<th>Quantity</th>
					<th>total</th>
				</tr>

				<c:forEach var="de" items="${detailbills}">
					<tr>
						<td>${de.drink.drinkName}</td>
						<td>${de.drink.price}</td>
						<td><c:choose>
								<c:when test="${de.size == true}">L</c:when>
								<c:when test="${de.size == false}">M</c:when>
							</c:choose></td>
						<td>${de.quantity}</td>
						<td><c:choose>
								<c:when test="${de.size == true }">${de.drink.price * de.quantity + '10000'}</c:when>
								<%-- ${total}= ${total} + ${de.drink.price * de.quantity + '10000'} --%>
								<c:when test="${de.size == false}">${de.drink.price * de.quantity }</c:when>
								<%-- ${total}= ${total} +${de.drink.price * de.quantity + '10000'} --%>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
			<h4>Total: ${total }</h4>
		</div>
	</main>
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>