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
    <link rel="icon" type="image/png" href="https://d-themes.com/html/riode/images/icons/favicon.png">

    <link href="<c:url value='/resources/home/dist/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/home/dist/css/account_infor.css' />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
    ${message }
    <aside class="aside">
        <a href="account/account-infor.htm" class="admin">
            <div class="logo">
                <i class="fa-solid fa-t"></i>
            </div>
            
            ${account.getEmployeeEntity().getLastName() }
        </a>

        <ul class="functions">
            <li class="function">
                <a href="account/account-infor.htm" class=" active">
                    <div class="icon">
                        <i class="fa-solid fa-user"></i>
                    </div>
                    Information 
                </a>
            </li>

            <li class="function">
                <a href="account/changepassword.htm" class="">
                    <div class="icon">
                        <i class="fa-solid fa-key"></i>
                    </div>
                    Change password 
                </a>
            </li>

            <li class="function">
                <a href="">
                    <div class="icon">
                        <i class="fa-solid fa-receipt"></i>

                    </div>
                    Home
                </a>
            </li>

        

            
        </ul>

        <form>
        	<button class="btn-log-out"><a href="account/logout.htm">Log out</a></button>
        </form>
    </aside>

    <!-- Main -->
    <main class="main">
        <div class="main-header">
            <h2>Welcome</h2>

            <div class="map">
                <a href="user/home.htm">Home</a>
                /
                <a href="user/home.htm">${account.getEmployeeEntity().getLastName() }</a>
            </div>
        </div>

        <div class="main-content">
            <div class="row">
                <div class="col-4">
                    <div class="logo">
                        <i class="fa-solid fa-t"></i>

                    </div>
                </div>
                
                <div class="col-4">
                    
                    <input type="text" placeholder= "Username" value="${account.getUserName() }" readonly>
                    <input type="text" placeholder="FullName" value= "${account.getEmployeeEntity().getFirstName() } ${ account.getEmployeeEntity().getLastName()}" readonly>
                    <input name ="Role" type="text" placeholder="Role" value= "${account.getEmployeeEntity().getPosition().getPositionName()}"  readonly>
                    
                    <!-- <select name="" id="" reaonly>
                        <option value="">Male</option>
                        <option value="">Female</option>
                        <option value="">Other</option>
                    </select> -->


                </div>
                
                
                <div class="col-4">
               
                    <input type="text" placeholder="Birthday" value="${account.getEmployeeEntity().getBirthday()}" readonly>
                    <input type="text" placeholder="Address" value= "${account.getEmployeeEntity().getAddress() }" readonly>  
               		<input type="text" placeholder="Address" value= "${account.getEmployeeEntity().getPhone() }" readonly> 
                </div>
                
            </div>

            <button name="change-information" class="btn-change">Change Information</button>

        </div>
    </main>
</body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
	<script src="<c:url value='/resources/home/dist/js/home.js' />"></script>
</html>