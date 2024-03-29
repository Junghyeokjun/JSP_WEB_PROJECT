package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VoteDao;

public class VoteCommand implements VCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm");
		
		System.out.println("v_confirm"+v_confirm);
		VoteDao dao = new VoteDao();
		dao.write(v_jumin, v_name, m_no,v_time,v_area,v_confirm);
		request.setAttribute("v_jumin",v_jumin);

		
	}
}
