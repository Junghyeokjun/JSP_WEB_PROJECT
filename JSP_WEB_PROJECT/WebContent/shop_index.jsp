<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>shop_index</title>
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
<style>
	section{
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
	<nav class="navbar navbar-expand-lg bg-danger-subtle" data-bs-theme="dark">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarShopContent"
				aria-controls="navbarShopContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarShopContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link mx-2 text-white font-weight-bold" aria-current="page"
						href="${pageContext.request.contextPath}/shop/join_page.do">회원등록</a></li>
					<li class="nav-item"><a class="nav-link mx-2 text-white font-weight-bold"
						href="${pageContext.request.contextPath}/shop/list.do">회원목록조회/수정</a></li>
					<li class="nav-item"><a class="nav-link mx-2 text-white font-weight-bold"
						href="${pageContext.request.contextPath}/shop/sales/list.do">회원매출조회</a></li>
					<li class="nav-item"><a class="nav-link mx-2 text-white font-weight-bold"
						href="${pageContext.request.contextPath}/shop/index.do">홈으로.</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section class="col p-5 w-100">
		<div class="text-center">
			<h1>쇼핑몰 회원관리 프로그램</h1>
		</div>
		<div class="p-5 w-75 mx-auto">
			<p>
				쇼핑몰 회원 정보와 회원매출 정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
				프로그램 작성 순서<br> 1. 회원정보 테이블을 생성한다.<br> 2. 매출정보 테이블을 생성한다.<br>
				3. 회원정보,매출정보 테이블에 제시한 문제지의 참조 데이터를 추가 생성한다.<br> 4. 회원정보 입력 화면
				프로그램을 작성한다.<br> 5. 회원정보 조회 프로그램을 작성한다.<br> 6. 회원매출정보 조회
				프로그램을 작성한다.
			</p>
		</div>
	</section>
	<footer class="text-center">
		<div class="d-flex justify-content-evenly align-items-center" style="height: 50px">
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
					let nowMinute = nowDate
							.getMinutes();
					let nowSecond = nowDate
							.getSeconds();
	
					let dateStr = "현재 시각 : " + nowHour
							+ "시 " + nowMinute + "분 "
							+ nowSecond + "초";
	
					let nowDateElement = document
							.getElementById("nowDate");
					nowDateElement.innerHTML = dateStr;
				}
				setInterval(time, 1000);
			</script>
		</div>
	</footer>
</body>

</html>