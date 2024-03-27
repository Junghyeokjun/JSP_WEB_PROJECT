package com.shop.member.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.MemberDto;

public class ThisMemberModifyCommand implements Command {

	// 수정 과정
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ShoppingDao dao = new ShoppingDao();
		
		int memberNum = Integer.valueOf(request.getParameter("memberNo"));
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joinDateStr = request.getParameter("joinDate");
		Timestamp joinDate = dao.strToTs(joinDateStr);
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		MemberDto updateMember = new MemberDto(memberNum, memberName, phone, address, joinDate, grade, city);
		
		dao.updateMember(updateMember);
	}

}
