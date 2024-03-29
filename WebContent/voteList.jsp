<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>voteList</title>
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<header>
	<h1>지역구의원투표 프로그램 ver 2024-03</h1>
</header>
<nav>
	<ul>
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