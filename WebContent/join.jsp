<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
	<style>
	mark.orange {
		background: linear-gradient(to top, orange 20%, transparent 30%);
	}
	</style>
<link rel="stylesheet" href="css/join.css" />
<script>

$(document).ready(function () {
	var isId = false;
	// 아이디 중복검사
	$("#id").keyup(function () {
		var ckid = $("#id").val();
		console.log(ckid);
		if(ckid.length < 6 || ckid.length > 16) {
			$("#idresult").text("아이디는 6자이상 16자이하입니다.").removeClass('text-primary').removeClass('text-danger').addClass('text-dark');
			isId = false;
		} else {
            $.ajax({
            	url: '${root}/MemberServlet',
            	data: {'act': 'idcheck', 'ckid': ckid},
              	type: 'GET',
              	dataType: 'text',
              	success: function (response) {
                	var cnt = parseInt(response);
                	console.log(cnt);
                	if(cnt == 0) {
                		$("#idresult").text(ckid + "는 사용가능합니다.").removeClass('text-dark').removeClass('text-danger').addClass('text-primary');
                		isId = true;
                	} else {
                		$("#idresult").text(ckid + "는 사용할 수 없습니다.").removeClass('text-dark').removeClass('text-primary').addClass('text-danger');
                		isId = false;
                	}
              	}
			});
		}
	});
	
	// 회원가입
    $("#registerBtn").click(function () {
        if (!$("#name").val()) {
            alert("이름 입력!!!");
            return;
        } else if (!isId) {
            alert("아이디 확인!!!");
            return;
        } else if (!$("#password").val()) {
            alert("비밀번호 입력!!!");
            return;
        }else {
            $("#memberform").attr("action", "${root}/MemberServlet").submit();
        }
    });

    // $('#zipcode').focusin(function () {
    //     $('#zipModal').modal();
    // });
});


</script>

</head>
<body>

<div style="height: 200px"></div>
	<!-- 본문 몸통 구현 -->
	<main class="main_container">
		<section class="main_content">
			<div class="text_container">
				<!-- 상단 GAEKO 텍스트 -->
				<h3 class="main_text">GAEKO</h3>
			</div>
			<!-- 전체 회원가입 상자 -->
			<div class="SignUp_box">
				<!-- 아이디 기입 -->
				<form id="memberform" action="" method="post">
					<input type="hidden" id="act" name="act" value="join" />
					<div>

						<div class="id_content">

							<label for="id" class="content_text">아이디</label>

						</div>

						<div class="input_content">

							<input id="id" class="search_window" type="text" placeholder="id"
								name="id" /><br>
							<div id="idresult" class="mt-1"></div>
						</div>
					</div>
					<!-- 비밀번호 기입 -->
					<div>
						<div class="password_content">
							<label for="password" class="content_text">비밀번호</label>

						</div>
						<!-- 비밀번호 form -->
						<div class="input_content">

							<input id="password" class="search_window" type="text"
								placeholder="password" name="password" /><br>

						</div>
					</div>
					<!-- 이름 기입 -->
					<div>
						<div class="name_content">
							<label for="name" class="content_text">이름</label>
						</div>
						<!-- 이름 form -->
						<div class="input_content">

							<input id="name" class="search_window" type="text"
								placeholder="name" name="name" /><br>

						</div>
					</div>


					<!-- 이메일 기입 -->
					<div>
						<div class="email_content">
							<label for="email" class="content_text">이메일</label>
						</div>
						<!-- 이메일 form -->
						<div class="input_content">

							<input id="email" class="search_window" type="text"
								placeholder="xxxx@xxxxx" name="email" /><br>

						</div>
					</div>

					<div>
						<button type="button" id="registerBtn" class="SignUp_button">회원가입</button>
						<!-- <input class="SignUp_button" type="submit" value="회원가입" />-->

					</div>
				</form>


			</div>
		</section>
	</main>


</body>
</html>