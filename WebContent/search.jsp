<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/search.css" rel="stylesheet" type="text/css">
<link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />

<title>검색 페이지</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5241faa4704eaf06cfe702b77fc0fdc5"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div style="height:90px"></div>
	<section id="main-section">
		<div id="info-detail"></div>
		<div id="main-map"></div>
		<script>
			var markers = [];
			
		</script>
		<article id="main-list">
			<h1>매물 목록</h1>
			<form id="filter-container" action="${root}/HouseDealServlet" method="post">
				<input type="hidden" name ="act" value="search">
				<input type="text" class="form-control" id="search-filter" name="keyword"
					placeholder="구, 동, 아파트 명" />
				<button type="submit" id="filter-btn">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
			<div id="list-item-container">
				<c:choose>
					<c:when test="${empty requestScope.hList}">
						<!-- <tr>
							<td colspan="5">매물 목록이 비었습니다. 매물을 추가해주세요.</td>
						</tr> -->
					</c:when>

					<c:otherwise>
						<c:forEach items="${requestScope.hList}" var="h">
							<a href="${root}/HouseDealServlet?act=read&aptCode=${h.aptCode}" id="list-item-box">
								<div class="list-item">
									<img class="test" src = "img/CS타워.jfif"/>
									<div class="list-item-detail">
										<h5>${h.aptName}</h5>
										<h3>${h.dealAmount}</h3>
										<div class="list-item-detail-info">
											<label>${h.area} 평 - ${h.floor} </label> <label>${h.dongName}</label>
											<label>아파트</label><i class="fa-regular fa-heart press_like"></i>
										</div>
									</div>
								</div>
							</a>
							<script>
								markers.push({
									title : '${h.aptName}',
									latlng : new kakao.maps.LatLng('${h.lat}','${h.lng}')
								});
							</script>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
			</div>
		</article>
	</section>

	<script>
		
		///지도 생성
		const mapContainer = document.getElementById('main-map'), // 지도를 표시할 div
		mapOption = {
			center : markers[0].latlng, // 지도의 중심좌표
			level : 6, // 지도의 확대 레벨
		};
		let map = new kakao.maps.Map(mapContainer, mapOption);

		for (var i = 0; i < markers.length; i++) {

			// 마커 이미지의 이미지 크기 입니다
			var imageSize = new kakao.maps.Size(24, 35);

			// 마커 이미지를 생성합니다    
			//var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

			// 마커를 생성합니다

			console.log(markers.length);
			console.log(markers[i]);
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : markers[i].latlng, // 마커를 표시할 위치
				title : markers[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			});
		}
	</script>



</body>
</html>