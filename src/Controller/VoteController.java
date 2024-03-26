package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VoteDAO;

/**
 * Servlet implementation class VoteController
 */
@WebServlet("/vote/*")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() .. ");

		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() .. ");

		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() .. ");

		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
	    Command command = null;
	      
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commandDo = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("commandDo : " + commandDo);

		VoteDAO vote = new VoteDAO();

		if(commandDo.equals("vote/list.do"){
			 command = new VoteListCommand();
	         command.excuete(request, response);
	         
	         viewPage = "/vote_list.jsp";
		}else if(commandDo.equals("vote/list.do"){
			command = new VoteListCommand();
	         command.excuete(request, response);
	         
	         viewPage = "/vote_list.jsp";
		}else if(commandDo.equals("vote/list.do"){
			command = new VoteListCommand();
	         command.excuete(request, response);
	         
	         viewPage = "/vote_list.jsp";
		}else if(commandDo.equals("vote/list.do"){
			command = new VoteListCommand();
	         command.excuete(request, response);
	         
	         viewPage = "/vote_list.jsp";
		}else if(commandDo.equals("vote/list.do"){
			command = new VoteListCommand();
	         command.excuete(request, response);
	         
	         viewPage = "/vote_list.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
