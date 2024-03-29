package com.jsp.web.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp.web.golf.dto.GolfMemberDto;

public class GolfMemberDao {
	private DataSource dataSource = null;

	public GolfMemberDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
		}
	}
	public List<GolfMemberDto> list() {
		//회원 정보를 받아오는 함수
		List<GolfMemberDto> dtos = new ArrayList<GolfMemberDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "select * from TBL_Member_202201";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String cNo = rs.getString("C_NO");
				String cName = rs.getString("C_NAME");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String grade = rs.getString("GRADE");

				GolfMemberDto dto = new GolfMemberDto(cNo,cName,phone,address,grade);
				dtos.add(dto);
			}

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}

		return dtos;

	}
	
}
