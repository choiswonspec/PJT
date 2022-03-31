<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="<%=request.getContextPath()%>"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.nav-item {
	font-size: 20px;
	font-style: normal;
	font-weight: bold;
}
</style>


</head>
<body>
	<!-- header navigation 구현 -->
	<nav id="nav-bar"
		class="navbar navbar-expand-sm bg-light navbar-dark fixed-top shadow">
		<div class="container">
			<a id="logo" class="navbar-brand"
				href="${root}/MemberServlet?act=mvindex"> <img
				src="./img/dog_logo.png" alt="logo" style="width: 80px" />
			</a>
			<div class="collapse navbar-collapse justify-content-end"
				id="collapsibleNavbar">
				<c:if test="${empty userInfo}">
					<ul id="login_nav" class="navbar-nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="${root}/MemberServlet?act=mvlogin">로그인</a></li>
						<li class="nav-item"><a class="nav-link text-dark"
							href="${root}/MemberServlet?act=mvjoin">회원가입</a></li>
					</ul>
				</c:if>

				<c:if test="${!empty userInfo}">
					<ul id="log_out_nav" class="navbar-nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="${root}/MemberServlet?act=logout">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link text-dark"
							href="${root}/MemberServlet?act=mvmyPage">마이페이지</a></li>
					</ul>
				</c:if>
			</div>
		</div>
	</nav>
</body>
</html>