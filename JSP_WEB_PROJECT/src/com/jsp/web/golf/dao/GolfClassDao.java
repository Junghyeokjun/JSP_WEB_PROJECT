package com.jsp.web.golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp.web.golf.dto.GolfClassDto;

public class GolfClassDao {
	private DataSource dataSource = null;

	public GolfClassDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
		}
	}
	public List<GolfClassDto> list() {

		List<GolfClassDto> dtos = new ArrayList<GolfClassDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "select * from TBL_CLASS_202201";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String registMonth = rs.getString("REGIST_MONTH");
				String cNo = rs.getString("C_NO");
				String classArea = rs.getString("CLASS_AREA");
				int tuition = rs.getInt("TUITION");
				String teacherCode = rs.getString("TEACHER_CODE");

				GolfClassDto dto = new GolfClassDto(registMonth,cNo,classArea,tuition,teacherCode);
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
	public List<GolfClassDto> distinctList() {

		List<GolfClassDto> dtos = new ArrayList<GolfClassDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "select distinct CLASS_AREA from TBL_CLASS_202201";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String registMonth = null;
				String cNo = null;
				String classArea = rs.getString("CLASS_AREA");
				int tuition = 0;
				String teacherCode = null;

				GolfClassDto dto = new GolfClassDto(registMonth,cNo,classArea,tuition,teacherCode);
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

	public int apply(GolfClassDto dto) {

		Connection conn = null;
		PreparedStatement psmt = null;
		int rn=0;
		
		String sql = "insert into TBL_CLASS_202201 values(?,?,?,?,?)";

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println(dto.getRegistMonth());
			System.out.println(dto.getcNo());
			System.out.println(dto.getClassArea());
			System.out.println(dto.getTuition());
			System.out.println(dto.getTeacherCode());
			psmt.setString(1, dto.getRegistMonth());
			psmt.setString(2, dto.getcNo());
			psmt.setString(3, dto.getClassArea());
			psmt.setInt(4, dto.getTuition());
			psmt.setString(5, dto.getTeacherCode());

			rn = psmt.executeUpdate();
			System.out.println("apply 된 갯수" + rn);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return rn;
	}
}
