package com.shop.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.MemberDto;

public class MemberJoinPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 해당 회원 번호 받기
		ShoppingDao dao = new ShoppingDao();
		MemberDto joinSet = dao.joinPageSet();
		request.setAttribute("joinSet", joinSet);
	}

}
