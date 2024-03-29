<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>voteList</title>
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
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark " data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">열심히하조</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">투표</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " aria-disabled="true" href="${pageContext.request.contextPath}/shop/index.do">홈쇼핑</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-disabled="true" href="${pageContext.request.contextPath}/golf.jsp">골프</a>
            </li>
          </ul>
        </div>
        <form class="d-flex" role="search">
          <input class="form-control me-2 bg-white text-dark" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

      </div>
    </nav>
<header class="d-flex align-items-center justify-content-center">
	<h1>지역구의원투표 프로그램 ver 2024-03</h1>
</header>
<nav id="mainNav">
	<ul id="mainUl">
		<li><a href="memberList.do">∙후보조회</a></li>
		<li><a href="voteMember.do">∙투표하기</a></li>
		<li><a href="voteList.do">∙투표검수조회</a></li>
		<li><a href="voteResult.do">∙후보자등수</a></li>
		<li><a href="main.do">∙홈으로</a></li>	
	</ul>
</nav>
<section>
<h2>∙ 투표검수조회 ∙</h2>
<div class="table">
	<table style="width:700px;">
		<tr>
			<th>성명</th>
			<th>생년월일</th>
			<th>나이</th>
			<th>성별</th>
			<th>후보번호</th>
			<th>투표시간</th>
			<th>유권자확인</th>
		</tr>
		<c:forEach var="vdto" items="${vdtos}">
			<tr>
			<td>${vdto.v_name}</td>
			<td>${vdto.v_jumin}</td>
			<td>${vdto.v_age}</td>
			<td>${vdto.v_gender}</td>
			<td>${vdto.m_no}</td>
			<td>${vdto.v_time}</td>	
			<td>${vdto.v_confirm}</td>						
		</tr>
		</c:forEach>					
	</table>
</div>
</section>
<footer>
HRDKOREA Copyright@2024 All rights reserved. Human Resources Development Service of Korea
</footer>
</body>
</html>