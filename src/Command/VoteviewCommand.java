package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDao;
import Dto.VoteDto;

public class VoteviewCommand implements VCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String v_jumin = (String)request.getAttribute("v_jumin");
		System.out.println("v_jumin"+v_jumin);	
		VoteDao dao = new VoteDao();
		List<VoteDto> vdtos = dao.voteView(v_jumin);
		request.setAttribute("vdtos", vdtos);
		System.out.println("vdtos"+vdtos);	

	}

}
