package com.shop.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDao { 
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static String id = "scott";
	private static String pw = "tiger";

	public ShoppingDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			
		}
	}
	
// 	참조 코드
//	public List<DeptVo> deptList(){
//		List<DeptVo> depts = new ArrayList<DeptVo>();
//		
//		Connection connection;
//		Statement statement;
//		ResultSet rs;
//		
//		String sql = "select * from dept01";
//		try{
//			Class.forName(driver);
//			connection = DriverManager.getConnection(url,id,pw);
//			statement = connection.createStatement();
//			rs = statement.executeQuery(sql);
//			while(rs.next()){
//				int deptno = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				
//				DeptVo vo = new DeptVo(deptno,dname,loc);
//				
//				depts.add(vo);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return depts;
//	}
	
}
