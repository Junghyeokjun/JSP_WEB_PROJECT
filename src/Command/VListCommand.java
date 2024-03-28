package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.VCommand;
import Dao.VoteDao;
import Dto.VoteDto;
import Dto.VoteMember;

public class VListCommand implements VCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		List<VoteDto> vdtos = dao.Vlist();
		System.out.println("VListCommand.do ..");		
		request.setAttribute("vdtos", vdtos);
		System.out.println("vdtos"+vdtos);	

		
	}
}
