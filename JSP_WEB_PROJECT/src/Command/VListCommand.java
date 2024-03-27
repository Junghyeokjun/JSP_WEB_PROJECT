package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDao;
import Dto.VoteMember;


public class VListCommand implements VCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		List<VoteMember> vmems = dao.list();
		System.out.println("VListCommand.do ..");		
		request.setAttribute("vmems", vmems);
		
		
	}

}
