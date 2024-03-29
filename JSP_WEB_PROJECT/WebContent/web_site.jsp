<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역구의원투표</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<%@ include file="../voteNav.jsp" %>
<header class="d-flex align-items-center justify-content-center">
	<h1>지역구의원투표 프로그램</h1>
</header>
<nav id="mainNav">
	<ul id="mainUl" >
		<li><a href="${pageContext.request.contextPath }/vote/memberList.do">∙후보조회</a></li>
		<li><a href="${pageContext.request.contextPath }/vote/voteMember.do">∙투표하기</a></li>
		<li><a href="${pageContext.request.contextPath }/vote/voteList.do">∙투표검수조회</a></li>
		<li><a href="${pageContext.request.contextPath }/vote/voteResult.do">∙후보자등수</a></li>
		<li><a href="${pageContext.request.contextPath }/vote/main.do">∙홈으로</a></li>
	</ul>
</nav>
<footer>
HRDKOREA Copyright@2024 All rights reserved. Human Resources Development Service of Korea
</footer>
</body>
</html>