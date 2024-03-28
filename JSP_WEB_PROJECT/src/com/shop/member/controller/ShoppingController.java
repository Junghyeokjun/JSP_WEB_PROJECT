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
import com.shop.member.command.SalesMemberListCommand;
import com.shop.member.command.ThisMemberCommand;
import com.shop.member.command.ThisMemberModifyCommand;


/**
 * Servlet implementation class ShoppingController
 */
@WebServlet("/shop/*")
public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get, post 상관없이 해당 함수 실행
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get, post 상관없이 해당 함수 실행
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
			viewPage = "/shop_index.jsp";
		}else if(comm.equals("/shop/join_page.do")) {
			// 회원가입 페이지
			command = new MemberJoinPageCommand();
			command.execute(request, response);			
			viewPage = "/shop_memberjoinpage.jsp";
		}else if(comm.equals("/shop/join.do")) {
			// 회원가입 절차 밟기
			command = new MemberJoinCommand();
			command.execute(request, response);
			viewPage = "/shop/list.do";
		}else if(comm.equals("/shop/list.do")) {
			// 회원 리스트 페이지
			command = new MemberListCommand();
			command.execute(request, response);
			viewPage = "/shop_memberlist.jsp";
		}else if(comm.equals("/shop/sales/list.do")) {
			// 특정 회원 정보가 필요한 페이지에 사용됨
			command = new SalesMemberListCommand();
			command.execute(request, response);
			viewPage = "/shop_salesmember.jsp";
		}else if(comm.equals("/shop/modify_page.do")) {
			// 수정할 회원 정보 보여주기
			command = new ThisMemberCommand();
			command.execute(request, response);
			viewPage = "/shop_member.jsp";
		}else if(comm.equals("/shop/modify.do")) {
			// 특정 회원 정보 수정 절차 밟기
			command = new ThisMemberModifyCommand();
			command.execute(request, response);
			viewPage = "/shop/list.do";
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
