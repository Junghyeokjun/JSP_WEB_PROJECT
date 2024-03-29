package com.jsp.web.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp.web.golf.dto.GolfTeacherDto;

public class GolfTeacherDao {
	private DataSource dataSource = null;

	public GolfTeacherDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
		}
	}
	public List<GolfTeacherDto> list() {
		//강사 정보를 받아오는 함수
		List<GolfTeacherDto> dtos = new ArrayList<GolfTeacherDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "select * from TBL_TEACHER_202201";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String teacherCode = rs.getString("TEACHER_CODE");
				String teacherName = rs.getString("TEACHER_NAME");
				String className = rs.getString("CLASS_NAME");
				int classPrice = rs.getInt("CLASS_PRICE");
				String teacherRegistDate = rs.getString("TEACHER_REGIST_DATE");

				GolfTeacherDto dto = new GolfTeacherDto(teacherCode,teacherName,className,classPrice,teacherRegistDate);
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
