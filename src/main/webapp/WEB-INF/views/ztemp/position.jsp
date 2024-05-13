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
<title>CHUC VU</title>
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

		<%-- 		<div id="popup-edit">
			<form action="" method="post" class="popup-container">
				<h4 class="popup-header">Edit</h4>

				<div class="popup-content">
					<label for="popup-id">ID:</label>
					<form:input type="number" value="${p.positionID }" readonly></form:input>
					> <label for="popup-name">Name:</label> <input type="text"
						value="Nhan vien giao hang">

					<div class="popup-action">
						<button class="btn-save" onclick="showPopup()">Save</button>
						<div class="btn-cancel" onclick="showPopup()">Cancel</div>
					</div>
				</div>


			</form>

		</div>

 --%>

		<div class="bg-light p-5 rounded">
			${message}
			<form:form class="row g-3" modelAttribute="position"
				action="admin/position.htm" method="POST">

				<div class="col-md-4">
					<label for="positionID" class="form-label">ID</label>
					<form:input path="positionID"  class="form-control"
						placeholder="Mã Chức Vụ" readonly="true"/>
					<form:errors path="positionID"></form:errors>
				</div>
				<div class="col-md-4">
					<label for="positionName" class="form-label">Name</label>
					<form:input path="positionName" class="form-control"
						placeholder="Nhập Tên Chức Vụ" />
					<form:errors path="positionName"></form:errors>
				</div>

				<div class="col-md-4 row-g-3">
					<button name="${btnStatus }" type="submit" class="btn btn-primary"
						style="margin-left: 40px; margin-top: 30px">Insert</button>
				</div>
			</form:form>
		</div>

		<%-- 	<div class="row justify-content-md-center">
				<%@include file="/WEB-INF/views/include/menudemo.jsp"%>
		</div>  --%>

		<div class="bg-light p-5 rounded">
			<div class="d-flex flex-row justify-content-between">
				<div>
					<span id="result1"></span>

					<form class="d-inline-flex">
						<input name="searchInput" id="searchInput"
							class="form-control me-2" type="search" placeholder="Search"
							aria-label="Search">

						<button name="btnsearch" id="searchPositionName"
							class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>

			</div>


			<table class="table table-hover">
				<tr>

					<th>ID</th>
					<th>Name</th>
					<th>Edit</th>
					<th>Delete</th>


					<th></th>
				</tr>
				<c:forEach var="p" items="${positions}">

					<tr>

						<td>${p.positionID}</td>
						<td>${p.positionName}</td>


						<td><c:if test="${p.positionID <= 2 }">
								<img width="50" height="40"
									src="<c:url value="/resources/images/edit.png"/>">
								<button name="btnEdit1" class="btn btn-light">Edit</button>
							</c:if> <c:if test="${p.positionID > 2 }">
								<%-- <div id="popup-edit">
									<form:form action="" method="post" class="popup-container"
										modelAttribute="position1">
										<h4 class="popup-header">Edit</h4>

										<div class="popup-content">
											<label for="popup-id">ID:</label>
											<form:hidden path="positionID" value="${p.positionID }"></form:hidden>
											<label for="popup-name">Name:</label>
											<form:input path="positionName" value="${p.positionName }"></form:input>


											<div class="popup-action">
												<button name="btnEdit" type="submit" class="btn-save"
													onclick="showPopup()">Save</button>
												<div class="btn-cancel" onclick="showPopup()">Cancel</div>
											</div>
										</div>
									</form:form>
								</div>	 --%>
							<%-- 	<img width="50" height="40"
									src="<c:url value="/resources/images/edit.png"/>">
								<div class="btn btn-warning  btn-edit" onclick="showPopup()">Edit</div> --%>
								
								<!-- name="btnEdit" -->
								<a 
									href="admin/position/${p.positionID}.htm?linkEdit"
									role="button"> <img width="50" height="40"
									src="<c:url value="/resources/images/edit.png"/>">
								</a>
								<a href="admin/position/${p.positionID}.htm?linkEdit">
									<button type="button" class="btn btn-danger">Edit</button>
								</a>		

							</c:if></td>


						<td><c:if test="${p.positionID <= 2 }">
								<img width="30" height="30"
									src="<c:url value="/resources/images/delete.png"/>">
								<button name="btnDelete" class="btn btn-light">Delete</button>
							</c:if> <c:if test="${p.positionID > 2 }">
								<a name="btnDelete"
									href="admin/position/${p.positionID}.htm?btnDelete"
									role="button"> <img width="30" height="30"
									src="<c:url value="/resources/images/delete.png"/>">
								</a>
								<a href="admin/position/${p.positionID}.htm?btnDelete">
									<button type="button" name="btnDelete" class="btn btn-danger">Delete</button>
								</a>


							</c:if></td>
					</tr>

				</c:forEach>

			</table>

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