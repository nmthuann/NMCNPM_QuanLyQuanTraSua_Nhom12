<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>Quản Lý Quán Trà Sữa</title>

<!-- <link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/sign-in/"> -->



<!-- Bootstrap core CSS -->
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css' />"
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


<!-- Custom styles for this template -->
<!--  <link href="assets/dist/signin.css" rel="stylesheet"> -->
<link href="<c:url value='/resources/assets/dist/signin.css' />"
	rel="stylesheet">
</head>
<body class="text-center">
	${message }
	<main class="form-signin">
		<form:form action="login.htm" modelAttribute="account" method="post">

			<img class="mb-4"
				src="<c:url value='/resources/assets/brand/bootstrap-logo.svg' />"
				alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

			<div class="form-group first">
				<form:label path="userName" class="visually-hidden">User name</form:label>
				<form:input placeholder="Email address" path="userName" />
				<form:errors path="userName" cssClass="text-danger" />
			</div>


			<div class="form-group last mb-4">
				<form:label path="password" class="visually-hidden">Password</form:label>
				<form:password placeholder="Password" path="password" />
				<form:errors path="password" cssClass="text-danger" />
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>

			<form:button class="w-100 btn btn-lg btn-primary">Sign
				in</form:button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
			
			<div class="social-login text-center">
				<a href="#" class="facebook"> <span class="icon-facebook mr-3"></span>
				</a> <a href="#" class="twitter"> <span class="icon-twitter mr-3"></span>
				</a> <a href="#" class="google"> <span class="icon-google mr-3"></span>
				</a>
			</div>
		</form:form>
	</main>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<base href="${pageContext.servletContext.contextPath}/">

<link href="<c:url value='/resources/home/dist/css/reset.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/home/dist/css/login.css' />"
	rel="stylesheet">
<link rel="icon" type="image/png"
	href="https://d-themes.com/html/riode/images/icons/favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link href="<c:url value='/resources/home/dist/css/owl.carousel.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/resources/home/dist/css/owl.theme.default.css' />"
	rel="stylesheet">
</head>

<body>


	<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Main -->

	<main class="main login-container">
		<div class="container">

			<form:form class="login-form" action="login.htm"
				modelAttribute="account">
				<h2>Login</h2>

				<form:input type="text" path="userName" placeholder="Username" />
				<h5>
					<form:errors path="userName"></form:errors>
				</h5>
				<!-- <span class="errors">Have to type account</span> -->
				<form:input type="password" path="password" placeholder="Password" />
				<h5>
					<form:errors path="password"></form:errors>
				</h5>
				<!-- <span class="errors">Wrong password</span> -->

				<div class="link">
					<a href="admin/register.htm">I don't have account</a> <a
						href="admin/forgotpassword.htm">Lost your password?</a>
				</div>

				<h5 style="margin: 12px;">${message }</h5>
				<!-- <br> -->
				<form:button>Login</form:button>
			</form:form>
		</div>
	</main>

	<%@include file="/WEB-INF/views/include/footer.jsp"%>
</body>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>
<script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
<script src="<c:url value='/resources/home/dist/js/home.js' />"></script>

</html>