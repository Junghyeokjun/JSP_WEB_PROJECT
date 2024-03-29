<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>voteMember</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>    
<script>
function validateForm() {
	let v_jumin = $("input[name='v_jumin']").val();
	let v_name = $("input[name='v_name']").val();
	let m_no = $("select[name='m_no']").val();
	let v_time = $("input[name='v_time']").val();		
	let v_area = $("input[name='v_area']").val();
	let v_confirm = $("input[name='v_confirm']").val();

	// 간단한 유효성 검사 예시
	if(v_jumin == ""){
		alert("주민번호를 입력하세요.");
		return false;
	}else if(v_name == ""){
		alert("이름을 입력하세요.");
		return false;
	}else if(m_no == ""){
		alert("투표번호를 입력하세요.");
		return false;
	}else if(v_time == ""){
		alert("투표시간을 입력하세요.");
		return false;
	}else if(v_area == ""){
		alert("투표장소를 입력하세요.");
		return false;
	}else if(v_confirm == "null"){
		alert("유권자확인을 선택하세요.");
		return false;
	}			
	
	alert("회원등록이 완료되었습니다.");
	return true; // 유효성 검사 통과
}
	$(document).ready(function() {
		$(document).on("submit",$("#joinForm"),function(event){
			if (!validateForm()) {
				event.preventDefault();
			}
		});		
	});

	
</script>
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
<h2>∙ 투표하기 ∙</h2>
<form id=" joinForm" name="frm" method="post" action="write.do">
<div class="table">
	<table>
		<tr>
			<th>주민번호</th>
			<td>
			<input type="text" name="v_jumin" maxlength="13" > 예 : 8906153154726
			</td>
		</tr>
		<tr>
			<th>성명</th>
			<td>
			<input type="text" name="v_name">
			</td>
		</tr>
		<tr>
			<th>투표번호</th>
			<td>
			<select name="m_no">
				<option></option>
				<option value="1">[1]김후보</option>
				<option value="2">[2]이후보</option>
				<option value="3">[3]박후보</option>
				<option value="4">[4]조후보</option>
				<option value="5">[5]최후보</option>
			</select>		
			</td>
		</tr>
		<tr>
			<th>투표시간</th>
			<td>
			<input type="text" name="v_time" placeholder="예)0930" maxlength="4">
			</td>
		</tr>
		<tr>
			<th>투표장소</th>
			<td>
			<input type="text" name="v_area" placeholder="예)제1투표장">
			</td>
		</tr>
		<tr>
			<th>유권자확인</th>
			<td>
			<input style="float:none;" type="radio" name="v_confirm" value="Y">확인 
			<input style="float:none;" type="radio" name="v_confirm" value="N">미확인
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
			<input type="submit" value="투표하기">
			<button class="btn" type="reset" >다시하기</button>
			</td>
		</tr>
	</table>
</div>
</form>
</section>
<footer>
HRDKOREA Copyright@2024 All rights reserved. Human Resources Development Service of Korea
</footer>
</body>
</html>
