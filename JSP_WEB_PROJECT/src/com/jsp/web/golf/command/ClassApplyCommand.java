package com.jsp.web.golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.web.golf.dao.GolfClassDao;
import com.jsp.web.golf.dto.GolfClassDto;

public class ClassApplyCommand implements GCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String registMonth=request.getParameter("registMonth");
		String cNo=request.getParameter("cNo");
		String classArea=request.getParameter("classArea");
		int tuition=Integer.valueOf(request.getParameter("tuition"));
		String teacherCode=request.getParameter("teacherCode");
		
		GolfClassDao dao=new GolfClassDao();
		GolfClassDto dto= new GolfClassDto(registMonth,cNo,classArea,tuition,teacherCode);
		dao.apply(dto);
	}

}
