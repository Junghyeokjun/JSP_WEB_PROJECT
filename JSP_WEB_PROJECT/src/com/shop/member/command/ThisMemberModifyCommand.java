package com.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.MemberDto;

public class ThisMemberModifyCommand implements Command {

	// 수정 과정
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ShoppingDao dao = new ShoppingDao();
		
		int thisNum = Integer.valueOf(request.getParameter("thisMemberNo"));		
		int memberNum = Integer.valueOf(request.getParameter("memberNo"));
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joinDateStr = request.getParameter("joinDate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		MemberDto updateMember = new MemberDto(memberNum, memberName, phone, address, joinDateStr, grade, city);		
		dao.updateMember(updateMember, thisNum);
	}

}
