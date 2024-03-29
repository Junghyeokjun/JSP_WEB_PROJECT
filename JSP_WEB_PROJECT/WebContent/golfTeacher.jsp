<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<style>
  header,footer {
    font-family: 'HY견명조';
  }
</style>
<script type="text/javascript">
    $(document).ready(function(){
    	/* 수강료를 특정 형식으로 바꿔주는 이벤트 */
    	$(".price").each(function(index,item){
    		$(item).text($(item).text().replace(/\B(?=(\d{3})+(?!\d))/g, ","))
    	})
    });
</script>
<body>
  <div class="d-flex flex-column justify-content-between" style="height: 100vh;">
    <nav class="navbar navbar-expand-lg bg-dark " data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/golf.jsp">열심히하조</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link " aria-current="page" href="${pageContext.request.contextPath}/index.jsp">투표</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " aria-disabled="true" href="${pageContext.request.contextPath}/shop/index.do">홈쇼핑</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-disabled="true" href="${pageContext.request.contextPath}/golf.jsp">골프</a>
            </li>
          </ul>
        </div>
        <form class="d-flex" role="search">
          <input class="form-control me-2 bg-white text-dark" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

      </div>
    </nav>
    <div class="flex-grow-1 d-flex flex-column" style="background-color: #cdcdcd;" id="main">
      <header class="py-5 text-white text-center fs-2" style="background-color:#333;">골프연습장 회원관리 프로그램 ver 1.0</header>
      <nav class="navbar navbar-expand-lg " style="background-color: #666;">
        <div class="container-fluid">
          <div class="collapse navbar-collapse " id="navbarNav">
            <ul class="navbar-nav ">
              <li class="nav-item mx-2">
                <a class="nav-link text-white fw-bold" href="${pageContext.request.contextPath}/golf.jsp">홈으로</a>
              </li>
              <li class="nav-item mx-2">
                <a class="nav-link text-white fw-bold"  href="${pageContext.request.contextPath}/golf/teacher.do">강사조회</a>
              </li>
              <li class="nav-item mx-2">
                <a class="nav-link text-white fw-bold " href="${pageContext.request.contextPath}/golf/class.do">수강신청</a>
              </li>
              <li class="nav-item mx-2">
                <a class="nav-link text-white fw-bold" href="${pageContext.request.contextPath}/golf/member.do">수강정보조회</a>
              </li>
              <li class="nav-item mx-2">
                <a class="nav-link text-white fw-bold" href="${pageContext.request.contextPath}/golf/teachersales.do">강사매출현황</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- table end -->
            <div class="container text-center">
        <h1 class="my-5">강사조회</h1>
        <table class="table-bordered  w-75 mx-auto ">
          <thead >
            <tr class="fs-4">
              <th class="fw-bold py-1" scope="col">강사코드</th>
              <th class="fw-bold" scope="col">강사명</th>
              <th class="fw-bold" scope="col">강의명</th>
              <th class="fw-bold" scope="col">수강료</th>
              <th class="fw-bold" scope="col">강사자격취득일</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="teacher" items="${teachers}">
            	<tr class="fs-4">
	            	<td class="py-1">${teacher.teacherCode}</td>
	            	<td>${teacher.teacherName}</td>
	            	<td>${teacher.className}</td>
	            	<td>\<span class="price">${teacher.classPrice}<span></td>
	            	<td>${teacher.teacherRegistDate}</td>
            	</tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- table end -->
    </div>
    <footer>
      <div id="foot" class="text-center text-white py-3" style="background-color:#333;">
        <span>HRDKOREA Copyright@2015 All rights reserved. Human Resources Development Service of Korea</span>
      </div>
    </footer>
  </div>


</body>

</html>