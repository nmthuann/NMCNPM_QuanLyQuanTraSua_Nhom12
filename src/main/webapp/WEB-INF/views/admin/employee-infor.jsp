<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Information</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">

<%-- <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css' />"
	rel="stylesheet"> --%>
	
<link rel="icon" type="image/png"
	href="https://d-themes.com/html/riode/images/icons/favicon.png">

<link href="<c:url value='/resources/home/dist/css/reset.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/resources/home/dist/css/account_infor.css' />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="<c:url value='/resources/assets/dist/starter-template.css' />"
	rel="stylesheet">

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/starter-template/">
<link
	href="<c:url value='/resources/assets/dist/css/bootstrap.min.css'/>"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	${message }
	<aside class="aside">
		<a href="admin/employee-infor.htm" class="admin">
			<div class="logo">
				<i class="fa-solid fa-t"></i>
			</div> ${employee.getLastName() }
		</a>

		<ul class="functions">
			<li class="function"><a href="account/account-infor.htm"
				class=" active">
					<div class="icon">
						<i class="fa-solid fa-user"></i>
					</div> Information
			</a></li>

			<li class="function"><a href="admin/employeepage.htm" class="">
					<div class="icon">
						<i class="fa-solid fa-key"></i>
					</div> employee
			</a></li>

			<li class="function"><a href="admin/adminhome.htm">
					<div class="icon">
						<i class="fa-solid fa-receipt"></i>

					</div> Home
			</a></li>




		</ul>

		<%--         <form>
        	<button class="btn-log-out"><a href="account/logout.htm">Log out</a></button>
        </form> --%>
	</aside>

	<!-- Main -->
	<main class="main">
		<div class="main-header">
			<h2>Welcome</h2>

			<div class="map">
				<a href="user/home.htm">Employee</a> / <a href="user/home.htm">${employee.getLastName() }</a>
			</div>
		</div>

		<div class="main-content">
		<!-- 	<div class="row">
				<div class="col-4">
					<div class="logo">
						<i class="fa-solid fa-t"></i>

					</div>
				</div> -->

				<div class="bg-light p-5 rounded">
					${message}
					<form:form class="row g-3" modelAttribute="employee"
						action="admin/employee-infor.htm">

						<!-- Mã Nhân Viên -->

						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">ID</label>
							<form:input path="employeeID" cssClass="form-control"
								id="exampleFormControlInput1" readonly="true" />

						</div>
						<!-- Họ -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">First
								Name</label>
							<form:input path="firstName" type="text" cssClass="form-control"
								id="exampleFormControlInput1"
								placeholder="Vui lòng nhập tên sản phẩm"
								value="${employee.getFirstName()}" />
						</div>

						<!-- Tên -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Last
								Name</label>
							<form:input path="lastName" type="text" cssClass="form-control"
								id="exampleFormControlInput1" value="${employee.getLastName() }" />
						</div>

						<!-- Gender -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Gender</label>
				<%-- 						<c:choose>
								<c:when test="${employee.isGender() == true}">
									<form:radiobutton path="gender" type="text"
										cssClass="form-control" id="exampleFormControlInput1"
										value="${ employee.isGender()}" checked="checked" />Male
								</c:when>
								<c:when test="${employee.isGender() == false}">
									<form:radiobutton path="gender" type="text"
										cssClass="form-control" id="exampleFormControlInput1"
										value="${employee.isGender()}" checked="checked" />Female
								</c:when>
							</c:choose> --%>

							<form:input path="gender" value="${gender.isGender() }" />
							<%-- <form:radiobutton path="gender" value="Female"  /> --%>

						</div>

						<!-- Birthday -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Birthday</label>
							<form:input path="birthday" type="text" cssClass="form-control"
								id="exampleFormControlInput1" value="${employee.getBirthday() }" />
						</div>

						<!-- Address -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Address</label>
							<form:input path="address" type="text" cssClass="form-control"
								id="exampleFormControlInput1" value="${employee.getAddress() }" />
						</div>

						<!-- Phone -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Phone</label>
							<form:input path="phone" type="text" cssClass="form-control"
								id="exampleFormControlInput1" value="${employee.getPhone() }" />
						</div>

						<!-- Position -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Position</label>
							<form:select path="position.positionID" items="${positions}"
								itemValue="positionID" itemLabel="positionName"
								class="form-select form-select-lg mb-6"
								aria-label=".form-select-lg example">
							</form:select>
						</div>

						<!-- start day -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Start
								Day</label>
							<form:input path="startDay" type="text" cssClass="form-control"
								id="exampleFormControlInput1" value="${employee.getStartDay() }" />
						</div>

						<!-- Employee Status -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Status</label>
							<form:input path="status" type="text" cssClass="form-control"
								id="exampleFormControlInput1" value="${employee.isStatus() }" />
						</div>

						<!-- Email -->
						<div class="col-md-4">
							<label for="exampleFormControlInput1" class="form-label">Email</label>
							<form:input path="employeeaccountEntity.userName" type="text"
								cssClass="form-control" id="exampleFormControlInput1"
								value="${employee.getEmployeeaccountEntity().userName }" />
						</div>


						<button name="${btnStatus}" class="btn btn-primary">Save</button>

					</form:form>

				</div>
			</div>
	</main>
</body>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>
<script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
<script src="<c:url value='/resources/home/dist/js/home.js' />"></script>
</html>