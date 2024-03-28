<%@page import="java.util.List"%>
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
	var memberGrade='일반';
	$(document).ready(function(){
		/* 회원이름 변경시 회원번호 변경과 회원등급에 따른 가격할인을 설정하는 이벤트 */
		$("#cName").change(function(){
			$("#cNo").val($("#cName option:selected").val());
			memberGrade=$("#cName option:selected").attr('class');
			if(memberGrade=='VIP'){
				$("#tuition").val(Number($("#teacherCode option:selected").attr('class'))/2);
			}else{
				$("#tuition").val($("#teacherCode option:selected").attr('class'));
			}
			if(isNaN($("#tuition").val())){
				$("#tuition").val("");
			}
		})
		/* 강의명 변경시 회원등급에 따른 가격할인을 설정하는 이벤트 */
		$("#teacherCode").change(function(){
			$("#tuition").val($("#teacherCode option:selected").attr('class'));
			if(memberGrade=='VIP'){
				$("#tuition").val(Number($("#teacherCode option:selected").attr('class'))/2);
			}else{
				$("#tuition").val($("#teacherCode option:selected").attr('class'));
			}
		})
		/* 폼에 입력되지 않은 항목이 존재하거나 형식에 맞지않는 항목이 존재할경우 서브밋을 중지하는 이벤트 */
		$("form").submit(function(e){
			if($("#registMonth").val()==""||$("#cNo").val()==""||$("#tuition").val()==""||$("#classArea option:selected").val()=="0"){
				alert("입력되지 않은 항목이 존재합니다.");
				e.preventDefault();
			}else if($("#registMonth").val().length!=6||isNaN(Number($("#registMonth").val()))){
				alert("수강월을 형식에 맞춰 입력하여 주십시오.");
				e.preventDefault();
			}
		})
	})
</script>
<body>
  <div class="d-flex flex-column justify-content-between" style="height: 100vh;">
    <nav class="navbar navbar-expand-lg bg-dark " data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">게임사이트</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link disabled" aria-current="page" href="#">투표</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" aria-disabled="true" href="#">홈쇼핑</a>
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
              <li class="nav-item mx-2">
                <a class="nav-link text-white fw-bold" href="${pageContext.request.contextPath}/golf.jsp">홈으로</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- table end -->
        <div class="container">
        <h1 class="my-5 text-center">수강신청</h1>
        <form action="${pageContext.request.contextPath}/golf/apply.do" method="post">
            <table class="table-bordered border-dark w-75  mx-auto">
                <tr class="fs-4">
                    <td class="text-center py-2" style="width: 30%;">수강월</td>
                    <td style="width: 70%;"><input type="text" class="ms-2 " style="width: 40%;" id="registMonth" name="registMonth" >  2022년 03월 예)202203 </td>
                </tr>
                <tr class="fs-4">
                    <td class="text-center py-2" style="width: 30%;">회원명</td>
                    <td style="width: 70%;">
                        <select class="ms-2 rounded" style="width: 40%;" id="cName" >
                            <option value="0" selected hidden disabled>&nbsp;회원명</option>
                            <c:forEach var="member" items="${members}">
                            	<option class="${member.grade}" value="${member.cNo}">&nbsp;${member.cName }</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="fs-4">
                    <td class="text-center py-2" style="width: 30%;">회원번호</td>
                    <td style="width: 70%;"><input type="text" class="ms-2" style="width: 40%;" id="cNo" name="cNo" readonly></td>
                </tr>
                <tr class="fs-4">
                    <td class="text-center py-2" style="width: 30%;" >강의장소</td>
                    <td style="width: 70%;">
                        <select id="classArea" name="classArea" class="ms-2 rounded" style="width: 40%;">
                            <option value="0" selected hidden disabled>&nbsp;강의장소</option>
                            <c:forEach var="classDto" items="${classDtos}">
                            	<option value="${classDto.classArea}">&nbsp;${classDto.classArea}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="fs-4">
                    <td class="text-center py-2" style="width: 30%;">강의명</td>
                    <td style="width: 70%;">
                        <select class="ms-2 rounded" style="width: 40%;" id="teacherCode" name="teacherCode">
                            <option value="0" selected hidden disabled>&nbsp;강의명</option>
                            <c:forEach var="teacher" items="${teachers}">
                            	<option class="${teacher.classPrice}" value="${teacher.teacherCode}">&nbsp;${teacher.className}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="fs-4">
                    <td class="text-center py-2" style="width: 30%;">수강료</td>
                    <td style="width: 70%;"><input id="tuition" name="tuition" type="text" class="ms-2" style="width: 40%;" readonly> 원</td>
                </tr>
                <tr class="">
                    <td class="text-center py-2" colspan="2">
                        <button class="btn btn-light btn-sm border-secondary" type="submit">수강신청</button>
                        <a href=""><button class="btn btn-light btn-sm border-secondary" type="button">다시쓰기</button></a>
                    </td>
                </tr>
            </table>
        </form>
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