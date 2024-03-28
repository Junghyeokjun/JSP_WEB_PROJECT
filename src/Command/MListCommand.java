package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDao;
import Dto.VoteMember;


public class MListCommand implements VCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		List<VoteMember> vmems = dao.Mlist();
		System.out.println("MListCommand.do ..");		
		request.setAttribute("vmems", vmems);
		
		
	}

}