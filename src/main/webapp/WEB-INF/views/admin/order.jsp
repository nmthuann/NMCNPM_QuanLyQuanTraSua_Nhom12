<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@include file="/WEB-INF/views/include/header.jsp"%> --%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
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
<title>ORDER</title>
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
		<!-- Form 2 -->
		<div class="bg-light p-5 rounded">
			${message}
			<form:form class="row g-3" modelAttribute="detailbill"
				action="admin/order.htm">

				<!-- Mã HD -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">BillID</label>
					<form:input path="bill.billID" cssClass="form-control"
						value="${billIdLast}" id="exampleFormControlInput1"
						readonly="true" />
					<form:errors path="bill.billID"></form:errors>
				</div>

				<%-- 				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Bill
						ID</label>
					<form:input path="bill.billID" cssClass="form-control"
						id="exampleFormControlInput1" />
					<form:errors path="bill.billID"></form:errors>
				</div> --%>

				<%-- 				<label for="exampleFormControlInput1" class="form-label">Bill</label>
				<form:select path="bill.billID" items="${bills}" itemValue="billID"
					itemLabel="billID" class="form-select form-select-lg mb-6"
					aria-label=".form-select-lg example">
				</form:select> --%>


				<!-- Drink ID -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Drink</label>
					<form:select path="drink.drinkID" items="${drinkList}"
						itemValue="drinkID" itemLabel="drinkName"
						class="form-select form-select-lg mb-6"
						aria-label=".form-select-lg example">
					</form:select>
					<form:errors path="drink.drinkID"></form:errors>
				</div>

				<!-- Size -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Size:</label>
					<label for="exampleFormControlInput1" class="form-label">M</label>
					<form:radiobutton path="size" value="false"
						id="exampleFormControlInput1" />
					<label for="exampleFormControlInput2" class="form-label">L</label>
					<form:radiobutton path="size" value="true"
						id="exampleFormControlInput2" />
					<form:errors path="size"></form:errors>
				</div>

				<!-- Quantity -->
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Quantity</label>
					<form:input path="quantity" cssClass="form-control"
						id="exampleFormControlInput1" />
					<form:errors path="quantity"></form:errors>
				</div>

				<button name="btnInsert" id="insertDetailBill"
					class="btn btn-outline-success" type="submit">Insert</button>
			</form:form>

		</div>
		<table class="table table-hover">
			<tr>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Size</th>
				<th>Quantity</th>
				<th>total</th>
				<th>Cancel</th>
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

					<td><a href="admin/order/${de.drink.drinkID}.htm?btnCancel">
							<button name="btnCancel" type="button" class="btn btn-danger">Cancel</button>
					</a></td>

				</tr>

			</c:forEach>

		</table>
		<div class="col-md-4">
			<label for="exampleFormControlInput1" class="form-label">Tiền
				Nhận</label> <input id="TienNhan" />
		</div>
		<div class="col-md-4">
			<label for="exampleFormControlInput1" class="form-label">Tổng
				Thu</label> <input id="TongThu" />
		</div>
		<div class="col-md-4">
			<label for="exampleFormControlInput1" class="form-label">Tiền
				Thừa</label> 
		</div>
		<div>
			<button name="btnCancel" type="button" class="btn btn-primary">Thanh
				Toán</button>
			<button name="btnCancel" type="button" class="btn btn-danger">Hủy</button>
		</div>
	</main>
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
</body>

<style>
#popup-edit {
	opacity: 0;
	visibility: hidden;
	-webkit-transition: 0.2s;
	transition: 0.2s;
	position: absolute;
	top: 0;
	left: 0;
	width: 100vw;
	height: 100vh;
	background-color: rgba(51, 51, 51, 0.9);
	z-index: 1000;
}

#popup-edit * {
	padding: 0;
	margin: 0;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

#popup-edit .popup-container {
	position: absolute;
	top: 45%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	background-color: white;
	border-radius: 8px;
	overflow: hidden;
}

#popup-edit .popup-container .popup-header {
	padding: 12px 20px;
	background-color: #2980b9;
	color: white;
}

#popup-edit .popup-container .popup-content {
	padding: 12px 40px;
}

#popup-edit .popup-container .popup-content label {
	display: block;
	margin-top: 16px;
}

#popup-edit .popup-container .popup-content input {
	display: block;
	margin-top: 4px;
	padding: 4px 12px;
	font-size: 16px;
	min-width: 320px;
}

#popup-edit .popup-container .popup-action {
	padding: 40px 0 20px;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-pack: end;
	-ms-flex-pack: end;
	justify-content: end;
}

#popup-edit .popup-container .popup-action button, #popup-edit .popup-container .popup-action div
	{
	background: none;
	border: none;
	padding: 4px 12px;
	margin-left: 8px;
	cursor: pointer;
	border-radius: 6px;
	-webkit-transition: 0.2s;
	transition: 0.2s;
	font-size: 14px;
}

#popup-edit .popup-container .popup-action button.btn-save, #popup-edit .popup-container .popup-action div.btn-save
	{
	background-color: #16a085;
	color: white;
}

#popup-edit .popup-container .popup-action button.btn-cancel,
	#popup-edit .popup-container .popup-action div.btn-cancel {
	background-color: #efefef;
	color: #c0392b;
}

#popup-edit .popup-container .popup-action button:hover, #popup-edit .popup-container .popup-action div:hover
	{
	opacity: 0.9;
}

#popup-edit.show {
	visibility: visible !important;
	opacity: 1 !important;
}
/*# sourceMappingURL=style.css.map */
</style>

<script>
	function showPopup() {
		var popup = document.getElementById("popup-edit");
		popup.classList.toggle("show");
	}
</script>
</html>