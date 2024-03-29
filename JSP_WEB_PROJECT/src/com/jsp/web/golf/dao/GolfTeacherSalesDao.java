package com.jsp.web.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp.web.golf.dto.GolfTeacherSalesDto;

public class GolfTeacherSalesDao {
	private DataSource dataSource = null;

	public GolfTeacherSalesDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
		}
	}
	public List<GolfTeacherSalesDto> list() {

		List<GolfTeacherSalesDto> dtos = new ArrayList<GolfTeacherSalesDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		//강사 매출액 산정에 필요한 정보를 받아오는 함수
		String sql = "SELECT TEACHER.TEACHER_CODE,TEACHER.CLASS_NAME,TEACHER.TEACHER_NAME, SUM(CLASS.TUITION) TUITION FROM TBL_CLASS_202201 CLASS, TBL_TEACHER_202201 TEACHER " + 
					 "WHERE CLASS.TEACHER_CODE=TEACHER.TEACHER_CODE " + 
					 "GROUP BY TEACHER.TEACHER_CODE,TEACHER.CLASS_NAME ,TEACHER.TEACHER_NAME " + 
					 "ORDER BY TEACHER.TEACHER_CODE ASC";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String teacherCode = rs.getString("TEACHER_CODE");
				String className = rs.getString("CLASS_NAME");
				String teacherName = rs.getString("TEACHER_NAME");
				int tuition = rs.getInt("TUITION");

				GolfTeacherSalesDto dto = new GolfTeacherSalesDto(teacherCode,className,teacherName,tuition);
				dtos.add(dto);
			}

		} catch (Exception e) {
			System.out.println(e);
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
