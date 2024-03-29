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
<script>
	$(document).ready(function() {
		/* $("#joinForm").submit(function(event) {
			if (!validateForm()) {
				event.preventDefault();
			}
		}); */
		$(document).on("submit","#joinForm",function(event) {
			if (!validateForm()) {
				event.preventDefault();
			}
		});
	});

	function validateForm() {
		let memberName = $("input[name='memberName']").val();
		let phone = $("input[name='phone']").val();
		let address = $("input[name='address']").val();
		let grade = $("input[name='grade']").val();
		let city = $("input[name='city']").val();

		// 간단한 유효성 검사 예시
		if(memberName === ""){
			alert("회원성명을 입력하세요.");
			return false;
		}else if(phone === ""){
			alert("회원전화를 입력하세요.");
			return false;
		}else if(address === ""){
			alert("회원주소를 입력하세요.");
			return false;
		}else if(grade === ""){
			alert("고객등급을 입력하세요.");
			return false;
		}else if(city === ""){
			alert("도시코드를 입력하세요.");
			return false;
		}			
		
		alert("회원등록이 완료되었습니다.");
		return true; // 유효성 검사 통과
	}
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
			<h1>홈쇼핑 회원 등록</h1>
		</div>
		<div class="p-4 mx-auto w-50">
			<form id="joinForm" action="${pageContext.request.contextPath}/shop/join.do"
				method="post">
				<table class="table table-bordered p-4 font-weight-bold">
					<tr>
						<td class="w-50 text-center">회원번호(자동발생)</td>
						<td class="w-50"><input class="bg-secondary-subtle" type="text" name="memberNo"
							readonly="readonly" value="${joinSet.memberNum}"></td>
					</tr>
					<tr>
						<td class="w-50 text-center">회원성명</td>
						<td><input type="text" name="memberName"></td>
					</tr>
					<tr>
						<td class="w-50 text-center">회원전화</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td class="w-50 text-center">회원주소</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td class="w-50 text-center">가입일자</td>
						<td><input class="bg-secondary-subtle" type="text" name="joinDate" value="${joinSet.joinDate}" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="w-50 text-center">고객등급(A:VIP, B:일반, C:직원)</td>
						<td><input type="text" name="grade"></td>
					</tr>
					<tr>
						<td class="w-50 text-center">도시코드</td>
						<td><input type="text" name="city"></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit"
							value="등록"> <input type="button" value="조회"
							onclick="window.location.href='${pageContext.request.contextPath}/shop/list.do';">
						</td>
					</tr>
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