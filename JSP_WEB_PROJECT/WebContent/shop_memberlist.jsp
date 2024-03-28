<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>shop_memberjoinpage</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous">
	
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
	section, table{
		background-color:  #e2e3e5;
	}
</style>
</head>
<body class="d-flex flex-column justify-content-between vh-100">
	<header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary"
			data-bs-theme="dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">게임 사이트</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/lotto/list.do">골프</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/rsp/rsp_game">투표</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="${pageContext.request.contextPath}/board/list.do">쇼핑몰</a></li>
					</ul>
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
		<div class="p-5 bg-primary text-white mx-auto text-center">
			<h1>쇼핑몰 회원관리 ver 1.0</h1>
		</div>
	</header>
	<nav class="navbar navbar-expand-lg bg-danger-subtle"
		data-bs-theme="dark">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarShopContent"
				aria-controls="navbarShopContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarShopContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a
						class="nav-link mx-2 text-white font-weight-bold"
						aria-current="page"
						href="${pageContext.request.contextPath}/shop/join_page.do">회원등록</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-white font-weight-bold"
						href="${pageContext.request.contextPath}/shop/list.do">회원목록조회/수정</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-white font-weight-bold"
						href="${pageContext.request.contextPath}/shop/sales/list.do">회원매출조회</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-white font-weight-bold"
						href="${pageContext.request.contextPath}/shop/index.do">홈으로.</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section class="col p-5">
		<div class="mx-auto text-center">
			<h1>회원목록조회/수정</h1>
		</div>
		<div class="p-4 mx-auto w-75">
			<form id="joinForm" action="${pageContext.request.contextPath}/shop/join.do"
				method="post">
				<table class="table table-secondary table-bordered p-4 font-weight-bold text-center">
					<tr>
						<td>회원번호</td>
						<td>회원성명</td>
						<td>전화번호</td>
						<td>주소</td>
						<td>가입일자</td>
						<td>고객등급</td>
						<td>거주지역</td>
					</tr>
					<c:forEach var="member" items="${members}">
						<tr>
							<td><a class="text-white" href="${pageContext.request.contextPath}/shop/modify_page.do?memberNo=${member.memberNum}" style="text-decoration: none">${member.memberNum}</a></td>
							<td>${member.memberName}</td>
							<td>${member.phone}</td>
							<td>${member.address}</td>
							<td>${member.joinDate}</td>
							<td>${member.grade}</td>
							<td>${member.city}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</section>
	<footer class="text-center border-top border-secondary">
		<div class="d-flex justify-content-evenly align-items-center"
			style="height: 50px">
			<div class="col"></div>
			<div class="col">
				<p class="m-0">© Company 2023-2024</p>
			</div>
			<div class="col">
				<p id="nowDate" class="m-0 border p-1 rounded bg-info text-white"></p>
			</div>
			<script>
				function time() {
					let nowDate = new Date();
					let nowHour = nowDate.getHours();
					let nowMinute = nowDate.getMinutes();
					let nowSecond = nowDate.getSeconds();

					let dateStr = "현재 시각 : " + nowHour + "시 " + nowMinute
							+ "분 " + nowSecond + "초";

					let nowDateElement = document.getElementById("nowDate");
					nowDateElement.innerHTML = dateStr;
				}
				setInterval(time, 1000);
			</script>
		</div>
	</footer>
</body>

</html>