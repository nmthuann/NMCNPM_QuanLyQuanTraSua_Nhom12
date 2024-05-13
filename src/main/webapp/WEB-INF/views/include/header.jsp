<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>Quản Lý Quán Trà Sữa</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">

<!-- Bootstrap core CSS -->
<!-- <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css' />"
	rel="stylesheet">
<link rel="stylesheet" href="resources/assets/list/list.css">
<link rel="stylesheet" href="resources/assets/list/list2.css">
<!-- <link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css"> -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="<c:url value='/resources/ckfinder/ckfinder.js'  />">
	
</script>
<script type="text/javascript"
	src="<c:url value='/resources/ckeditor/ckeditor.js'  />">
	
</script>

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

--%>

<%-- <link
	href="<c:url value='/resources/assets/dist/starter-template.css' />"
	rel="stylesheet">
</head> --%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <%@ include file="/WEB-INF/views/home/taglib.jsp"%> --%>
<!-- <script>
	function tai_lai_trang() {
		location.reload();
	}
</script> -->

<!-- Header -->
<header class="header">

	<section class="header-top">
		<div class="container d-flex jc-space-between ai-center">
			<div class="header-left">
				<p>Welcome to Milk Tea message or remove it!</p>
			</div>

			<div class="header-right">
				<a class="hover-p-color" href=""> <i
					class="fa-solid fa-location-dot"></i>Contact Us
				</a> <a class="hover-p-color" href=""> <i
					class="fa-solid fa-circle-info"></i>Need help
				</a>
			</div>
		</div>
	</section>

	<section class="header-middle">
		<div class="container d-flex jc-space-between ai-center">
			<div class="header-left  d-flex jc-space-between ai-center">
				<div class="logo">
					<a class="navbar-brand" href="#"> SWEET MILK TEA</a>
				</div>

				<ul class="menu  d-flex jc-space-between ai-center">
					<li><a href="employee/home.htm">Home</a></li>
					<li><a href="employee/order.htm">Order</a></li>
					<li><a href="employee/drink.htm">Drink</a></li>
					<li><a href="employee/seat.htm">Seat</a></li>
					<li><a href="employee/customer.htm">Customer</a></li>
					<li><a href="#">About</a></li>
					<li class="search d-flex ai-center"><input type="text"
						placeholder="Search..."> <a href=""> <i
							class="fa-solid fa-magnifying-glass"></i>
					</a></li>
				</ul>
			</div>

			<ul class="header-right  d-flex jc-space-between ai-center">
				<!-- getSession -->

				<c:if test="${infor != null}">

					<%-- 			<c:if test="${account.isRole()==true}">
						<li><a href="admin/account_infor.htm " class="user-area"><i
								class="fa-solid fa-user"></i> <span class="user-name">${admin.employeeEntity.getLastName() }</span>
						</a></li>
					</c:if>
					<c:if test="${account.isRole()==false}">
						<li><a href="account/account_infor.htm " class="user-area"><i
								class="fa-solid fa-user"></i> <span class="user-name">${user.employeeEntity.getLastName() }</span>
						</a></li>
					</c:if> --%>

					<li><a href="account/account-infor.htm "
						class="user-area user-name" style="width: 60px; height: 60px;">${infor.getEmployeeEntity().getLastName() }</a></li>
					<li><i class="fa-solid fa-user"></i></li>
				</c:if>
				
				<c:if test="${infor == null}">
					<li><a href="account/login.htm"><i
							class="fa-solid fa-user"></i></a></li>
				</c:if>
	</section>

	<div class="header-support"></div>

</header>