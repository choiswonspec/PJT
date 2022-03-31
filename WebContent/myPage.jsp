<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/myPage.css" />


</head>

<body>
	<div style="height: 90px"></div>
	<main class="main_container">
	
		<div class="main_content">

			<div class="text_container">
				<!-- 상단 GAEKO 텍스트 -->
				<h3 class="main_text">GAEKO</h3>
			</div>

			<!-- 전체 회원가입 상자 -->
			<div class="SignUp_box">

				<form id="updateform" action="${root}/MemberServlet" method="post">
					<input type="hidden" id="act" name="act" value="update" />
					<!-- 아이디 기입란 -->
					<div class = "input_box">
						<div class="id_content">
							<label for="id" class="content_text">아이디</label>
						</div>
						<div class="input_content">
							<div id="id" class="search_window">${userInfo.memberID}</div>
							<div id="idresult" class="mt-1"></div>
						</div>
					</div>

					<!-- 비밀번호 기입란 -->
					<div class = "input_box">
						<div class="password_content">
							<label for="password" class="content_text">비밀번호</label>
						</div>
						<!-- 비밀번호 form -->
						<div class="input_content">
							<input id="password" class="search_window" type="text"
								 name="password" value="${userInfo.password}" /><br>
						</div>
					</div>
					
					<!-- 이름 기입 -->
					<div class = "input_box">
						<div class="name_content">
							<label for="name" class="content_text">이름</label>
						</div>
						<!-- 이름 form -->
						<div class="input_content">

							<input id="name" class="search_window" type="text"
								name="name" value="${userInfo.name}"/><br>

						</div>
					</div>

					<!-- 이메일 기입 -->
					<div class = "input_box">
						<div class="email_content">
							<label for="email" class="content_text">이메일</label>
						</div>
						<!-- 이메일 form -->
						<div class="input_content">

							<input id="email" class="search_window" type="text"
								 name="email" value="${userInfo.email}" /><br>

						</div>
					</div>


					<div>
						<input id="changeInfo" class="update_button" type="submit"
						value="회원수정" />
					</div>
					<div class="memeber_delete">
						<a  href="${root}/MemberServlet?act=delete">회원탈퇴</a>
					</div>
				</form>	
			</div><!-- 전체 회원가입 상자 -->
		</div>
	</main>
</body>
</html>