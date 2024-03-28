package com.shop.member.command;

//import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.MemberDto;

public class MemberJoinCommand implements Command {
	// 가입 과정
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ShoppingDao dao = new ShoppingDao();
		// 데이터 받기
		int memberNum = Integer.valueOf(request.getParameter("memberNo"));
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joinDateStr = request.getParameter("joinDate");	
//		Timestamp joinDate = dao.strToTs(joinDateStr);
//		System.out.println(joinDateStr);
//		System.out.println(joinDate);
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		MemberDto newMember = new MemberDto(memberNum, memberName, phone, address, joinDateStr, grade, city);
		// 입력 과정 밟기
		dao.insertMember(newMember);
	}
}
