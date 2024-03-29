package com.jsp.web.golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.web.golf.dao.GolfTeacherSalesDao;

public class TeacherSalesListCommand implements GCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GolfTeacherSalesDao dao= new GolfTeacherSalesDao();
		request.setAttribute("teacherSales", dao.list());
	}

}
