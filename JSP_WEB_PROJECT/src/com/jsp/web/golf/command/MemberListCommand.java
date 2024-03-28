package com.jsp.web.golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.web.golf.dao.GolfSingUpJoinDao;

public class MemberListCommand implements GCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GolfSingUpJoinDao dao=new GolfSingUpJoinDao();
		
		request.setAttribute("sineUpList", dao.list());
	}

}
