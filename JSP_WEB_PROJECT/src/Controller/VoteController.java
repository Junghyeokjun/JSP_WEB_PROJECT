package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.VCommand;
import Command.VListCommand;


@WebServlet("*.do")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ..");

//		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");

//		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* URL check */
		System.out.println("actionDo() ..");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		VCommand command = null;
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String com = uri.substring(context.length());
		
		if(com.contentEquals("/main.do")) {
			System.out.println("index.jsp ..");
			viewPage = "index.jsp";
		}else if(com.contentEquals("/memberList.do")) {
			command = new VListCommand();
			command.execute(request,response);
			System.out.println("memberList.jsp ..");
			viewPage = "memberList.jsp";
		}
//		else if (com.equals("/write_view.do")) {
//			viewPage = "write_view.jsp";
//		}
		
//		switch(command) {
//		case "/main.do" : 		
//			site = "index.jsp";
//			break;
//		case "/memberList.do" : 			
//			site = vote.selectMember(request, response);
//			break;
//		case "/voteMember.do" : 			
//			site = "voteMember.jsp";
//			break;
//		case "/voteList.do" : 		
//			site = vote.selectAll(request, response);
//			break;
//		case "/voteResult.do" : 			
//			site = vote.selectResult(request, response);
//			break;
//		case "/vote.do" : 
//			int result = vote.insertVote(request, response);
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out=response.getWriter();
//			if(result == 1) {
//				out.println("<script>");
//				out.println("alert('투표하기 정보가 정상적으로 등록 되었습니다!'); location.href='"+context+"'; ");
//				out.println("</script>");
//				out.flush();
//			}else {
//				out.println("<script>");
//				out.println("alert('등록실패!'); location.href='"+context+"'; ");
//				out.println("</script>");
//				out.flush();
//			}		
//			break;
		RequestDispatcher dispatcher =  request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		}
		
}