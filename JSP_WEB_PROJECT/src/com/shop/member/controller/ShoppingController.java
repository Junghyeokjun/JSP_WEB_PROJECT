package com.shop.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.command.Command;
import com.shop.member.command.MemberJoinCommand;
import com.shop.member.command.MemberJoinPageCommand;
import com.shop.member.command.MemberListCommand;
import com.shop.member.command.ShopMemberJoinPageCommand;
import com.shop.member.command.ThisMemberCommand;
import com.shop.member.command.ThisMemberUpdateCommand;


/**
 * Servlet implementation class ShoppingController
 */
@WebServlet("/shop/")
public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String comm = uri.substring(contextPath.length());
		
		System.out.println("uri : " + uri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("comm : " + comm);
		
		if(comm.equals("/shop/index.do")) {
			viewPage = "/shopindex.jsp";
		}else if(comm.equals("/shop/join_page.do")) {
			// 회원가입 페이지
			command = new MemberJoinPageCommand();
			command.execute(request, response);			
			viewPage = "/shopmemberjoinpage.jsp";
		}else if(comm.equals("/shop/insert.do")) {
			// 회원가입 절차 밟기
			command = new MemberJoinCommand();
			command.execute(request, response);
			viewPage = "/shop/list.do";
		}else if(comm.equals("/shop/list.do")) {
			// 회원 리스트 페이지
			command = new MemberListCommand();
			command.execute(request, response);
			viewPage = "/shopmemberlist.jsp";
		}else if(comm.equals("/shop/update_page.do")) {
			// 특정 회원 정보 출력 페이지
			command = new ThisMemberCommand();
			command.execute(request, response);
			viewPage = "/shopmember.jsp";
		}else if(comm.equals("/shop/update.do")) {
			// 특정 회원 정보 수정 절차 밟기
			command = new ThisMemberUpdateCommand();
			command.execute(request, response);
			viewPage = "/shop/list.do";
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
