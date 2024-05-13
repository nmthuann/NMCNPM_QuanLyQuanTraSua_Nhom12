<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>Quản lý Quán Trà Sữa</title>

<base href="${pageContext.servletContext.contextPath}/">



<link
	href="<c:url value='/resources/assets/dist/starter-template.css' />"
	rel="stylesheet">

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css'/>"
	rel="stylesheet">



<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<link rel="stylesheet" href="resources/assets/list/list.css">
<link rel="stylesheet" href="resources/assets/list/list2.css">
</head>




<body>
	<script>
		function tai_lai_trang() {
			location.reload();
		}
	</script>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="admin/adminhome.htm">MILK TEA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" onclick="tai_lai_trang()">Home</a></li>

					<li class="nav-item"><a class="nav-link" href="#">Menu</a></li>

					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Order</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown01"
						data-bs-toggle="dropdown" aria-expanded="true">Management</a>

						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li><a class="dropdown-item" href="admin/drink.htm">1:
									Danh mục Thức Uống </a></li>
							<li><a class="dropdown-item" href="admin/employeepage.htm">2:
									Danh sách Nhân Viên</a></li>
							<li><a class="dropdown-item" href="admin/seat.htm">3:
									Danh sách bàn </a></li>
							<li><a class="dropdown-item" href="admin/bill.htm">4:
									Danh sách Hóa Đơn</a></li>
							<li><a class="dropdown-item" href="#">5: Thống Kê</a></li>
							<li><a class="dropdown-item" href="admin/customer.htm">6:
									Danh Sách Khách hàng</a></li>
							<li><a class="dropdown-item" href="admin/position.htm">7:
									Danh sách Chức vụ</a></li>
						</ul></li>
				</ul>

				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				
				
				<ul class="header-right  d-flex jc-space-between ai-center">
					<!-- getSession -->

					<c:if test="${account != null}">
							<li><a href="account/account-infor.htm " class="user-area"><i class="fa-solid fa-user"></i> <span
									class="user-name">${account.employeeEntity.getLastName() }</span>
							</a></li>
					</c:if>

					<c:if test="${account == null}">
						<li><a href="admin/login.htm"><i class="fa-solid fa-user"></i></a></li>
					</c:if> 
				</ul>

			</div>
		</div>
	</nav>

	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/ckfinder/ckfinder.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/ckeditor/ckeditor.js'  />">
		
	</script>
	<script
		src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>

	<script>
		var editor = CKEDITOR.replace('messagebody');
		CKFinder.setupCKEditor(ckeditor,
				'${pageContext.request.contextPath}/resources/ckfinder/');
	</script>
</body>
</html>