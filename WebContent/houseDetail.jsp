<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/houseDetail.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>

<div style="height:80px"></div>
	<div id="info-detail" style="display: flex;">
		<img src="img/CS타워.jfif">
		<div class="detail-info">
			<h1>${housedetail.aptName}</h1>
		</div>
		<div class = "detail-info-content">
				<div>지역명 : ${housedetail.dongCode}</div>
				<div>층고 : ${housedetail.floor}</div>
				<div>면적 : ${housedetail.area}</div>
				<div>가격 : ${housedetail.dealAmount}</div>
				<div>매물등록 일자 : ${housedetail.dealYear}년 ${housedetail.dealMonth}월 ${housedetail.dealDay}일 </div>
		</div>
		<div id="around-infra">
			<h2>주변 유치원 목록</h2>
			<!-- <table class="table table-hover">
				<thead>
					<tr>
						<th>유치원명</th>
						<th>위치</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>개동유치원</td>
						<td>서울특별시 성북구 보국문로 143</td>
					</tr>
				</tbody>
			</table> -->
		</div>
		<div id="around-infra">
			<h2>주변 병원 목록</h2>
			<!-- <table class="table table-hover">
				<thead>
					<tr>
						<th>병원명</th>
						<th>위치</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>전은의산부인과의원</td>
						<td>서울특별시 성북구 장월로 83 (장위동)</td>
					</tr>
					
				</tbody>
			</table> -->
		</div>
	</div>

</body>
</html>