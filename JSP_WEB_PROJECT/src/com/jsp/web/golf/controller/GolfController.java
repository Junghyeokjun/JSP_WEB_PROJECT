package com.jsp.web.golf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.web.golf.command.ClassApplyCommand;
import com.jsp.web.golf.command.ClassListCommand;
import com.jsp.web.golf.command.GCommand;
import com.jsp.web.golf.command.MemberListCommand;
import com.jsp.web.golf.command.TeacherListCommand;
import com.jsp.web.golf.command.TeacherSalesListCommand;




/**
 * Servlet implementation class GolfController
 */
@WebServlet("/golf/*")
public class GolfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GolfController() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doGet..");
    	actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doPost..");
    	actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo..");
		
		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		GCommand command = null;
		
		String uri=request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
	
		System.out.println("uri:" + uri);
		System.out.println("conPath:" + conPath);
		System.out.println("com:" + com);
		
		if (com.equals("/golf/teacher.do")) {
			command = new TeacherListCommand(); //강사목록을 조회한 정보를 받아오는 클래스
			command.execute(request, response);
			viewPage = "/golfTeacher.jsp";
		}else if(com.equals("/golf/class.do")) {
			command = new ClassListCommand(); //수강신청에 필요한 정보를 받아오는 클래스
			command.execute(request, response);
			viewPage = "/golfapply.jsp";
		}else if(com.equals("/golf/apply.do")) {
			command = new ClassApplyCommand(); //작성된 수강신청 정보를 db에 추가하는 클래스
			command.execute(request, response);
			viewPage = "/golf.jsp";
		}else if(com.equals("/golf/member.do")) {
			command = new MemberListCommand(); //작성된 수강신청 정보를 받아오는 클래스
			command.execute(request, response);
			viewPage = "/golfmember.jsp";
		}else if (com.equals("/golf/teachersales.do")) {
			command = new TeacherSalesListCommand(); //강사 매출 정보를 받아오는 클래스
			command.execute(request, response);
			viewPage = "/golfTeacherSales.jsp";
		}



		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}


}
