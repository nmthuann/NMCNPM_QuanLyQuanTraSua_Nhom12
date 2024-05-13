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
<title>BILL</title>
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
	<main class="container">
				<div class="bg-light p-5 rounded">
			${message}
			<form:form class="row g-3" modelAttribute="bill"
				action="admin/bill.htm">
				<!-- Mã HD -->
				<div class="col-md-4"><%-- value="${billIdLast}"  --%>
					<label for="exampleFormControlInput1" class="form-label">ID</label>
					<form:input path="billID" cssClass="form-control"
						id="exampleFormControlInput1" readonly="true" />
						<form:errors path="billID"></form:errors>
				</div>

				<!-- mã Nhân Viên -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">EmployeeID</label>
					<form:input path="employee.employeeID" type=" text"
						cssClass="form-control" id="exampleFormControlInput1"
						placeholder="mã Nhân Viên" value="${EmployeeId }" readonly="true" />
						<form:errors path="employee.employeeID" ></form:errors>
				</div>

				<!-- Ma cho ngoi - empty -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Seat</label>
					<form:select path="seat.seatID" items="${seatEmpty}"
						itemValue="seatID" itemLabel="seatID"
						class="form-select form-select-lg mb-6"
						aria-label=".form-select-lg example">
					</form:select>
					<form:errors path="seat.seatID" ></form:errors>
				</div>

				<!-- Ma KH -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Customer</label>
					<form:select path="customer.customerID" items="${customers}"
						itemValue="customerID" itemLabel="customerID"
						class="form-select form-select-lg mb-6"
						aria-label=".form-select-lg example">
					</form:select>
					<form:errors path="customer.customerID"></form:errors>
				</div>

				<!-- TG lap HD -->
				<div class="col-md-4"><%-- value="${TimeNowCreateBill}"readonly="true" --%>
					<label for="exampleFormControlInput1" class="form-label">Create
						Bill Day</label>
					<form:input path="createBillDay" type="text"
						cssClass="form-control" id="exampleFormControlInput1" value="${TimeNowCreateBill}" readonly="true"/>
						<form:errors path="createBillDay"></form:errors>
				</div>
					<a href="admin/order.htm">
					
							<button name="btnCreate" type="submit" class="btn btn-warning">Create</button>
					</a>
			</form:form>
		</div>
		<table class="table table-hover">
			<tr>
			<tr>
				<th>ID</th>
				<th>Employee</th>
				<th>Seat ID</th>
				<th>Customer ID</th>
				<th>CreateBillDay</th>
				<th>Total</th>
				<th>Detail</th>
			</tr>
			<c:forEach var="b" items="${bills}">
				<tr>

					<td>${b.billID}</td>
					<td>${b.employee.getLastName()}</td>
					<td>${b.seat.seatID}</td>
					<td>${b.customer.customerID}</td>
					<td>${b.createBillDay}</td>
					<td>total</td>
					<td><a href="admin/detailbill.htm">
							<button name="" type="button" class="btn btn-danger">Detail</button>
					</a></td>

				</tr>

			</c:forEach>

		</table>
	</main>
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>