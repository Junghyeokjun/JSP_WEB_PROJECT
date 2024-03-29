package com.jsp.web.golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.web.golf.dao.GolfClassDao;
import com.jsp.web.golf.dao.GolfMemberDao;
import com.jsp.web.golf.dao.GolfTeacherDao;

public class ClassListCommand implements GCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GolfClassDao classDao = new GolfClassDao();
		GolfMemberDao memberDao = new GolfMemberDao();
		GolfTeacherDao teacherDao = new GolfTeacherDao();
		
		request.setAttribute("classDtos", classDao.distinctList());
		request.setAttribute("members", memberDao.list());
		request.setAttribute("teachers", teacherDao.list());
		
	}

}
