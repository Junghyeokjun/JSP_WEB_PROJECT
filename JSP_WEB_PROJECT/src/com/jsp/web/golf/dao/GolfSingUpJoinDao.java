package com.jsp.web.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp.web.golf.dto.GolfSignUpJoinDto;

public class GolfSingUpJoinDao {
	private DataSource dataSource = null;

	public GolfSingUpJoinDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
		}
	}
	public List<GolfSignUpJoinDto> list() {
		//수강 신청에 필요한 정보를 받아오는 함수

		List<GolfSignUpJoinDto> dtos = new ArrayList<GolfSignUpJoinDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT CLASS.REGIST_MONTH,MEMBER.C_NO,MEMBER.C_NAME,TEACHER.CLASS_NAME,CLASS.CLASS_AREA,CLASS.TUITION,MEMBER.GRADE " + 
				"FROM TBL_CLASS_202201 CLASS, TBL_MEMBER_202201 MEMBER, TBL_TEACHER_202201 TEACHER " + 
				"where CLASS.C_NO=MEMBER.C_NO and CLASS.TEACHER_CODE=TEACHER.TEACHER_CODE " + 
				"ORDER by CLASS.REGIST_MONTH asc, MEMBER.C_NO asc";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String registMonth=rs.getString("REGIST_MONTH");
				String cNo=rs.getString("C_NO");
				String cName=rs.getString("C_NAME");
				String className=rs.getString("CLASS_NAME");
				String classArea=rs.getString("CLASS_AREA");
				int tuition=rs.getInt("TUITION");
				String grade=rs.getString("GRADE");

				GolfSignUpJoinDto dto = new GolfSignUpJoinDto(registMonth,cNo,cName,className,classArea,tuition,grade);
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
