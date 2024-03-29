package com.jsp.web.golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.web.golf.dao.GolfTeacherDao;

public class TeacherListCommand implements GCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		GolfTeacherDao dao =new GolfTeacherDao();
		request.setAttribute("teachers", dao.list());
	}

}
