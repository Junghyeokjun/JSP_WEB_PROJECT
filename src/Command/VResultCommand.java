package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.VCommand;
import Dao.VoteDao;
import Dto.VoteResult;

public class VResultCommand implements VCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		List<VoteResult> vrs = dao.Vresult();
		System.out.println("VoteResult.do ..");		
		request.setAttribute("vrs", vrs);
	}

}
