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

<%-- <link
	href="<c:url value='/resources/assets/dist/starter-template.css' />"
	rel="stylesheet">

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css'/>"
	rel="stylesheet"> --%>
	
<!-- <link rel="stylesheet" href="style.css"> -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- <style>
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
<link rel="stylesheet" href="resources/assets/list/list2.css"> -->

<style>
@import
	url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	user-select: none;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

.btn {
	position: absolute;
	top: 15px;
	left: 45px;
	height: 45px;
	width: 45px;
	text-align: center;
	background: #1b1b1b;
	border-radius: 3px;
	cursor: pointer;
	transition: left 0.4s ease;
}

.btn.click {
	left: 320px;
}

.btn span {
	color: white;
	font-size: 28px;
	line-height: 45px;
}

.btn.click span:before {
	content: '\f00d';
}

.sidebar {
	position: fixed;
	width: 300px;
	height: 100%;
	left: -300px;
	background: #1b1b1b;
	transition: left 0.4s ease;
}

.sidebar.show {
	left: 0px;
	overflow: scroll;
}

.sidebar .text {
	color: white;
	font-size: 25px;
	font-weight: 600;
	line-height: 65px;
	text-align: center;
	background: #1e1e1e;
	letter-spacing: 1px;
}

nav ul {
	background: #1b1b1b;
	height: 100%;
	width: 100%;
	list-style: none;
}

nav ul li {
	line-height: 60px;
	border-top: 1px solid rgba(255, 255, 255, 0.1);
}

nav ul li:last-child {
	border-bottom: 1px solid rgba(255, 255, 255, 0.05);
}

nav ul li a {
	position: relative;
	color: white;
	text-decoration: none;
	font-size: 18px;
	padding-left: 40px;
	font-weight: 500;
	display: block;
	width: 100%;
	border-left: 3px solid transparent;
}

nav ul li.active a {
	color: cyan;
	background: #1e1e1e;
	border-left-color: cyan;
}

nav ul li a:hover {
	background: #1e1e1e;
}

nav ul ul {
	position: static;
	display: none;
}

nav ul .feat-show.show {
	display: block;
}

nav ul .serv-show.show1 {
	display: block;
}

nav ul ul li {
	line-height: 42px;
	border-top: none;
}

nav ul ul li a {
	font-size: 17px;
	color: #e6e6e6;
	padding-left: 80px;
}

nav ul li.active ul li a {
	color: #e6e6e6;
	background: #1b1b1b;
	border-left-color: transparent;
}

nav ul ul li a:hover {
	color: cyan !important;
	background: #1e1e1e !important;
}

nav ul li a span {
	position: absolute;
	top: 50%;
	right: 20px;
	transform: translateY(-50%);
	font-size: 22px;
	transition: transform 0.4s;
}

nav ul li a span.rotate {
	transform: translateY(-50%) rotate(-180deg);
}

.content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: #202020;
	z-index: -1;
	text-align: center;
}

.content .header {
	font-size: 45px;
	font-weight: 600;
}

.content p {
	font-size: 30px;
	font-weight: 500;
}

body {
	background: url("/resources/images/backgrounds.jpg"); /* no-repeat; */
	background-position: center;
	background-size: cover;
	/* height: 100vh; */
}
</style>
<!-- <link rel="stylesheet" href="resources/assets/list/list.css">
<link rel="stylesheet" href="resources/assets/list/list2.css"> -->
<base href="${pageContext.servletContext.contextPath}/">
</head>

<body>
<!-- 	<script>
		function tai_lai_trang() {
			location.reload();
		}
	</script> -->

	<%-- <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">MILK TEA</a>
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
						data-bs-toggle="dropdown" aria-expanded="true">Quản Lí</a>
						
						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li><a class="dropdown-item" href="admin/drink.htm">1: Danh mục Thức Uống </a></li>
							<li><a class="dropdown-item" href="admin/employee.htm">2: Danh sách Nhân Viên</a></li>
							<li><a class="dropdown-item" href="admin/seat.htm">3: Danh sách bàn </a></li>
							<li><a class="dropdown-item" href="admin/bill.htm">4: Danh sách Hóa Đơn</a></li>
							<li><a class="dropdown-item" href="#">5: Thống Kê</a></li>
							<li><a class="dropdown-item" href="admin/customer.htm">6: Danh Sách Khách hàng</a></li>
							<li><a class="dropdown-item" href="admin/position.htm">7: Danh sách Chức vụ</a></li>
						</ul></li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>

				</form>
				<form class="d-flex" action="login/loginindex.htm">
					<button class="btn btn-outline-success" type="submit">Tạo Tài</button>
				</form>
				<form class="d-flex" action="admin/login.htm">
					<button class="btn btn-outline-success" type="submit">Login</button>
				</form>
			</div>
		</div>
	</nav> --%>
<!-- onclick="tai_lai_trang()" -->

	<div class="btn">
		<span class="fas fa-bars"></span>
	</div>
	<nav class="sidebar" >
		<div class="text" >Sweet Milk Tea</div>
		<ul>

			<li><a class="feat-btn">Category <span
					class="fas fa-caret-down first"></span>
			</a>
				<ul class="feat-show">
					<li><a href="admin/drink.htm">Drink</a></li>
					<li><a href="admin/bill.htm">Order</a></li>
				</ul></li>

			<li class="active"><a href="admin/employeepage.htm">Employee</a></li>

			<li><a href="admin/seat.htm">Seat</a></li>

			<li><a href="admin/customer.htm">Customer</a></li>

			<li><a href="admin/position.htm">Position Table</a></li>

			<li><a  class="serv-btn">Satistical<span
					class="fas fa-caret-down second"></span>
			</a>
				<ul class="serv-show">
					<li><a href="admin/detailbill.htm">Detail Bill</a></li>
					<li><a href="admin/detailbill.htm">Sales</a></li>
				</ul></li>



			<li><a href="account/login.htm">Login</a></li>
			<li><a href="#">Register</a></li>
			<li><a href="#">Settings</a></li>
			<li><a href="#">About</a></li>

		</ul>
	</nav>

	<script>
		$('.btn').click(function() {
			$(this).toggleClass("click");
			$('.sidebar').toggleClass("show");
		});
		$('.feat-btn').click(function() {
			$('nav ul .feat-show').toggleClass("show");
			$('nav ul .first').toggleClass("rotate");
		});
		$('.serv-btn').click(function() {
			$('nav ul .serv-show').toggleClass("show1");
			$('nav ul .second').toggleClass("rotate");
		});
		$('nav ul li').click(function() {
			$(this).addClass("active").siblings().removeClass("active");
		});
	</script>

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

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%-- <% response.sendRedirect("/account/login.html"); %> --%>