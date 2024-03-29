package com.shop.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.MemberDto;

public class MemberListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 리스트 보여주기
		ShoppingDao dao = new ShoppingDao();
		List<MemberDto> shopMembers = dao.memberList();		
		request.setAttribute("members", shopMembers);
	}

}
