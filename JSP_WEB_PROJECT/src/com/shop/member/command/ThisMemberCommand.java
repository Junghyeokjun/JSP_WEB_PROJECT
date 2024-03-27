package com.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.MemberDto;

public class ThisMemberCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 해당 멤버 정보 꺼내오기
		String memberNumStr = request.getParameter("memberNo");
		ShoppingDao dao = new ShoppingDao();
		MemberDto thisMember = dao.member(memberNumStr);		
		request.setAttribute("thisMember", thisMember);
	}

}
