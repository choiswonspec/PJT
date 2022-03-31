<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="css/login.css" />
<%@ include file="/header.jsp"%>
<script type="text/javascript">

$(document).ready(function () {
	$("#loginBtn").click(function () {
        if (!$("#id").val()) {
            alert("아이디 입력!!!");
            return;
        } else if (!$("#password").val()) {
            alert("비밀번호 입력!!!");
            return;
        } else {
            $("#loginform").attr("action", "${root}/MemberServlet").submit();
        }
    });

    $("#mvRegisterBtn").click(function () {
        location.href = "${root}/MemberServlet?act=mvjoin";
    });
});
</script>

</head>

<body>
	
	<c:if test="${cookie.loginid.value ne null}">
		<c:set var="svid" value="${cookie.loginid.value}" />
		<c:set var="ckid" value=" checked=\"checked\"" />
	</c:if>
	<div style="height: 80px"></div>

<div style="height:80px"></div>

	<!-- 본문 몸통 구현 -->
	<main class="container_body">
		
		<section class="main_content">
			<div class="text_container">
				<!-- 상단 GAEKO 텍스트 -->
				<h3 class="main_text">GAEKO</h3>
			</div>
			<!-- 로그인 박스 상자 -->
			<div class="login_box">
				<div class="id_login_content">
					<h3 class="id_login">ID로그인</h3>
				</div>
				<!-- 로그인 form -->
				<div class="input_content">
					<form id="loginform" class="text-left mb-3" method="post" action="">
						<input type="hidden" id="act" name="act" value="login"/> 
						<label
							class="form-check-label"> <input class="form-check-input"
							type="checkbox" id="idsave" name="idsave" value="saveok" ${ckid}>
							아이디저장
						</label> 
						<input id="id" class="search_window" type="text"
							placeholder="id" name="id" /><br>
							 <input id="password"
							class="search_window" type="text" placeholder="passward"
							name="password" />
					</form>
				</div>
				<div>
					<span class="login-menu"><a
						href="${root}/MemberServlet?act=mvjoin">회원가입</a></span> <span
						class="login-menu"><a href="">아이디 찾기</a></span> <span
						class="login-menu"><a href="">비밀번호 찾기</a></span>
				</div>
				<div>
					<form action="#">

						<button type="button" id="loginBtn" class="login_button">로그인</button>
					</form>
				</div>



			</div>
		</section>
	</main>



</body>
</html>

