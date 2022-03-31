<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/index.css" rel="stylesheet" type="text/css">
<title>메인페이지</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>

<div class="container">
      <div style="height: 250px"></div>
      <div class="row">
        <!-- 왼쪽 3칸 여백 -->
        <div class="col-sm-4"></div>
        <!-- 다음 6칸 메인 공간 -->
        <div class="col-sm-4">

          <div class="main_image">
            <!--  로고 -->
            <div><img  src="img/dog_logo.png" style="width: 100px" /></div>
            <div><a  href="${root}/HouseDealServlet?act=search"><button class="btn_service">서비스 이용하기</button></a></div>
          </div>
          
          <!-- 돋보기 사진 -->
          
        </div>
      </div>
    </div>
</body>
</html>