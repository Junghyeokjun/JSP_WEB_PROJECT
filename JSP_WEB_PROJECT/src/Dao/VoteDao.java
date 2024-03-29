package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Dto.VoteMember;
import Dto.VoteResult;
import Dto.VoteDto;


public class VoteDao {
private DataSource dataSource = null;
	
	public VoteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<VoteMember> list() {
		List<VoteMember> vmems = new ArrayList<VoteMember>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT \r\n" + 
					"    m_no,\r\n" + 
					"    m_name,\r\n" + 
					"    p_name,\r\n" + 
					"    CASE p_school\r\n" + 
					"        WHEN '1' THEN '고졸'\r\n" + 
					"        WHEN '2' THEN '학사'\r\n" + 
					"        WHEN '3' THEN '석사'\r\n" + 
					"        WHEN '4' THEN '박사'\r\n" + 
					"        ELSE '알 수 없음'\r\n" + 
					"    END AS p_school,\r\n" + 
					"    SUBSTR(m_jumin, 1, 6) || '-' || SUBSTR(m_jumin, 7) AS m_jumin,\r\n" + 
					"    m_city,\r\n" + 
					"    p_tel1 ||'-' || p_tel2 ||'-' || p_tel3 AS p_tel\r\n" + 
					"FROM \r\n" + 
					"    tbl_member_202403 \r\n" + 
					"JOIN \r\n" + 
					"    tbl_party_202403 ON tbl_member_202403.p_code = tbl_party_202403.p_code";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("VoteMember.list");

			while(rs.next()) {
				String m_no = rs.getString("m_no");
				String m_name = rs.getString("m_name");
				String p_name = rs.getString("p_name");
				String p_school = rs.getString("p_school");
				String m_jumin = rs.getString("m_jumin");
				String m_city = rs.getString("m_city");		
				String p_tel = rs.getString("p_tel");		

				System.out.println("VoteMember.list");
				VoteMember vmem = new  VoteMember(m_no, m_name, p_name,	 p_school, m_jumin, m_city,p_tel);
				vmems.add(vmem);				
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(psmt != null)
					psmt.close();
				if(conn != null)
					conn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}			
		return vmems;
	}
//	public String selectMember(HttpServletRequest request, HttpServletResponse response) {
//	  	
//		ArrayList<VoteMember> list = new ArrayList<VoteMember>();
//		
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			
//			//후보 조회 화면 쿼리
//			String sql = "SELECT ";
//			       sql+= " M.m_no, ";
//			       sql+= " M.m_name, ";
//			       sql+= " P.p_name, ";
//			       sql+= " DECODE(M.p_school,'1','고졸','2','학사','3','석사','박사') p_school, ";
//			       sql+= " substr(M.m_jumin,1,6)|| ";
//			       sql+= " '-'||substr(M.m_jumin,7) m_jumin, ";
//			       sql+= " M.m_city, ";
//			       sql+= " substr(P.p_tel1,1,2)||'-'||P.p_tel2||'-'||";
//			       sql+= " (substr(P.p_tel3,4)||";
//			       sql+= "  substr(P.p_tel3,4)||";
//			       sql+= "  substr(P.p_tel3,4)||";
//			       sql+= "  substr(P.p_tel3,4)) p_tel ";
//			       sql+= " FROM tbl_member_202005 M, tbl_party_202005 P ";
//			       sql+= " WHERE M.p_code = P.p_code";
//			 ps = conn.prepareStatement(sql);
//			 rs = ps.executeQuery();
//			 
//			 while(rs.next()) {
//				 VoteMember member = new VoteMember();
//				 member.setM_no(rs.getString(1));
//				 member.setM_name(rs.getString(2));
//				 member.setP_name(rs.getString(3));
//				 member.setP_school(rs.getString(4));
//				 member.setM_jumin(rs.getString(5));
//				 member.setM_city(rs.getString(6));
//				 member.setP_tel(rs.getString(7));
//				 
//				 list.add(member);
//			 }
//			 request.setAttribute("list",list);
//				conn.close();
//				ps.close();
//				rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "memberList.jsp";
//	}
	
//	public String selectAll(HttpServletRequest request, HttpServletResponse response){
//		 	
//		ArrayList<VoteDto> list = new ArrayList<VoteDto>();
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			conn = dataSource.getConnection();
//			
//		//투표검수조회 화면 쿼리
//		String sql = "SELECT v_name,";
//		       sql+= " '19'||substr(v_jumin,1,2)||";
//		       sql+= " '년'||substr(v_jumin,3,2)||";
//		       sql+= " '월'||substr(v_jumin,5,2)||";
//		       sql+= " '일생' v_jumin,";
//		       sql+= " '만 '||(to_number(to_char(sysdate,'yyyy'))";
//		       sql+= " - to_number('19'||substr(v_jumin,1,2)))||'세' v_age,";
//		       sql+= " DECODE(substr(v_jumin,7,1),'1','남','여') v_gender, ";		   
//		       sql+= " m_no, ";
//		       sql+= " substr(v_time,1,2)||':'||substr(v_time,3,2) v_time, ";
//		       sql+= " DECODE(v_confirm,'Y','확인','미확인') v_confirm ";
//		       sql+= " FROM tbl_vote_202005 ";
//		       sql+= " WHERE v_area='제1투표장'";
//		ps = conn.prepareStatement(sql); // 명령어를 보낸다.
//		rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			VoteDto vote = new VoteDto();
//			
//			vote.setV_name(rs.getString(1));
//			vote.setV_jumin(rs.getString(2));
//			vote.setV_age(rs.getString(3));
//			vote.setV_gender(rs.getString(4));
//			vote.setM_no(rs.getString(5));
//			vote.setV_time(rs.getString(6));
//			vote.setV_confirm(rs.getString(7));
//			
//			list.add(vote);
//		}
//		request.setAttribute("list",list);
//		conn.close();
//		ps.close();
//		rs.close();
//		
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		return "voteList.jsp";
//	}
//	public String selectResult(HttpServletRequest request, HttpServletResponse response) {
//		   	
//		ArrayList<VoteResult> list = new ArrayList<VoteResult>();
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			conn = dataSource.getConnection();
//			//후보자 등수 화면 쿼리
//			String sql = "SELECT ";
//			       sql+= " M.m_no, M.m_name, count(*) AS v_total";
//			       sql+= " FROM tbl_member_202005 M, tbl_vote_202005 V";
//			       sql+= " WHERE M.m_no = V.m_no AND V.v_confirm = 'Y' ";
//			       sql+= " GROUP BY M.m_no, M.m_name";
//			       sql+= " ORDER BY v_total DESC";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				VoteResult result = new VoteResult();
//				
//				result.setM_no(rs.getString(1));
//				result.setM_name(rs.getString(2));
//				result.setV_total(rs.getString(3));
//				list.add(result);
//			}
//			request.setAttribute("list",list);
//			conn.close();
//			ps.close();
//			rs.close();		
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		return "voteResult.jsp";
//	}
//	public int insertVote(HttpServletRequest request, HttpServletResponse response) {
//		
//		int result = 0;
//		Connection conn = null;
//		PreparedStatement ps = null;
//
//		
//		try {
//			conn = dataSource.getConnection();
//			String v_jumin = request.getParameter("v_jumin");
//			String v_name = request.getParameter("v_name");
//			String m_no = request.getParameter("m_no");
//			String v_time = request.getParameter("v_time");
//			String v_area = request.getParameter("v_area");
//			String v_confirm = request.getParameter("v_confirm");
//			
//			String sql = "INSERT INTO tbl_vote_202005 VALUES(?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, v_jumin);
//			ps.setString(2, v_name);
//			ps.setString(3, m_no);
//			ps.setString(4, v_time);
//			ps.setString(5, v_area);
//			ps.setString(6, v_confirm);
//			
//			result = ps.executeUpdate(); // 0실패, 1성공
//			System.out.println(result);	
//			conn.close();
//			ps.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//		return result;
//	}
}
