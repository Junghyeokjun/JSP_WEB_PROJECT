package com.shop.member.dao;

//import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.shop.member.dto.MemberDto;
import com.shop.member.dto.TotalPriceDto;

public class ShoppingDao {
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
//	private String user = "scott";
//	private String password = "tiger";
//
//	public ShoppingDao() {
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//
//		}
//	}
	
	DataSource dataSource = null;	
	
	public ShoppingDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			
		}
	}
	
	// 화면에 노출되는 등급 표시하기(따로 메서드 활용) 
	public String gradeFormat(String grade) {
		String meaning = null;
		if(grade.equals("A"))
			meaning = "VIP";
		else if(grade.equals("B"))
			meaning = "일반";
		else if(grade.equals("C"))
			meaning = "직원";
		return meaning;
	}
	
	// 화면에 보여줄 날짜 형식으로 바꿔주기 
	// Timestamp -> String
	public String listPageDateFmt(Timestamp joinDate) {
		SimpleDateFormat listDate = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = listDate.format(joinDate);
		return dateFormat;
	}	
	
	// 회원가입 페이지에 보여줄, 날짜형식으로 바꿔주기 
	public String joinPageDateFmt(Timestamp joinDate) {
		SimpleDateFormat listDate = new SimpleDateFormat("yyyyMMdd");
		String dateFormat = listDate.format(joinDate);
		return dateFormat;
	}
	
	// String -> Timestamp
	public Timestamp strToTs(String joinDateStr) {
	    try {
	        // SimpleDateFormat을 사용하여 문자열을 Timestamp로 변환
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        // 문자열을 Date 객체로 파싱
	        Date parsedDate = dateFormat.parse(joinDateStr);
	        // Date 객체를 Timestamp로 변환
	        Timestamp timestamp = new Timestamp(parsedDate.getTime());
	        // 변환된 Timestamp 객체 반환
	        System.out.println("Timestamp: " + timestamp);
	        return timestamp;
	    } catch (ParseException e) {
	        // 예외 처리: 변환에 실패한 경우
	        e.printStackTrace();
	        return null;
	    }
	}
	
	// 가입 페이지에 전달하는, 자동 시퀀스와 날짜 값
	public MemberDto joinPageSet() {
		
		MemberDto newMemberSet = new MemberDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//  MEMBER_TBL_SEQ.nextval 은 활용하지 않을 예정. 
		// 	String sql = "select MEMBER_TBL_SEQ.nextval memberNo, sysdate today from dual";
		// 	시퀀스 생성도 진행해야 하기 때문. 해당 부분은 요구사항에 없으므로 취소함. 
		String sql = "SELECT max(membernum)+1 memberNo, sysdate today  FROM member_tbl_02";

		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int memberNum = rs.getInt("memberNo");
				Timestamp joinDate = rs.getTimestamp("today");
				
				newMemberSet.setMemberNum(memberNum);
				newMemberSet.setJoinDate(joinPageDateFmt(joinDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return newMemberSet;
	}
	
	// 입력 과정
	public void insertMember(MemberDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		String sql =  "insert into "
					+ "member_tbl_02(MEMBERNUM, MEMBERNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) "
					+ "values (?,?,?,?,?,?,?)";
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMemberNum());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setTimestamp(5, strToTs(member.getJoinDate()));
			pstmt.setString(6, member.getGrade());
			pstmt.setString(7, member.getCity());
			int result = pstmt.executeUpdate();
			
			// 입력여부 체크
			System.out.print("is inserted? ");
			if(result < 1 ) {
				System.out.println("N");
			}else {
				System.out.println("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// 멤버들 리스트
	public List<MemberDto> memberList() {
		// dto 객체를 담는 리스트
		List<MemberDto> shopMembers = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member_tbl_02 order by memberNum asc";
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// dto에 넣고, 이를 리스트에 추가
				int memberNum = rs.getInt("memberNum");
				String memberName = rs.getString("memberName");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String joinDate = listPageDateFmt(rs.getTimestamp("joinDate"));
				String grade = gradeFormat( rs.getString("grade"));
				String city = rs.getString("city");

				MemberDto member = new MemberDto(memberNum, memberName, phone, address, joinDate, grade, city);
				shopMembers.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 리스트 리턴
		return shopMembers;
	}

	// 멤버 한 명의 정보
	public MemberDto member(String memberNumStr) {
		int memberNumInt = Integer.valueOf(memberNumStr);
		
		// 멤버 한 명의 정보를 담을 객체
		MemberDto selectedMember = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member_tbl_02 where memberNum = ?";
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNumInt);			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// dto에 넣고, 이를 리스트에 추가
				int memberNum = rs.getInt("memberNum");
				String memberName = rs.getString("memberName");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String joinDate = joinPageDateFmt(rs.getTimestamp("joinDate"));
				String grade = rs.getString("grade");
				String city = rs.getString("city");

				selectedMember = new MemberDto(memberNum, memberName, phone, address, joinDate, grade, city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 리스트 리턴
		return selectedMember;
	}
	
	// 조인된 테이블에서, 매출 리스트 조회
	public List<TotalPriceDto> salesList() {
		List<TotalPriceDto> salesList = new ArrayList<TotalPriceDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql =  "select "
						+ "memb.MEMBERNUM, "
						+ "MEMBERNAME, "
						+ "GRADE, "
						+ "sum(price) total "
					+ "from member_tbl_02 memb, money_tbl_02 mon "
					+ "where memb.MEMBERNUM = mon.membernum "
					+ "group by memb.MEMBERNUM, memb.MEMBERNAME, memb.GRADE "
					+ "order by total desc";
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// dto에 넣고, 이를 리스트에 추가
				int memberNum = rs.getInt("memberNum");
				String memberName = rs.getString("memberName");;
				String grade = gradeFormat(rs.getString("grade")); 
				int totalPrice = rs.getInt("total");
				
				TotalPriceDto memberSales = new TotalPriceDto(memberNum, memberName, grade, totalPrice);				
				salesList.add(memberSales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 리스트 리턴
		return salesList;
	}
	
	
	// 멤버 정보 수정 과정
	public void updateMember(MemberDto member, int thisNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member_tbl_02 set memberNum = ?, memberName = ?, phone = ?, address = ?, joinDate = ?, grade = ?, city = ? where memberNum = ?";
		try {
			//conn = DriverManager.getConnection(url, user, password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMemberNum());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setTimestamp(5, strToTs(member.getJoinDate()));
			pstmt.setString(6, member.getGrade());
			pstmt.setString(7, member.getCity());
			pstmt.setInt(8, thisNum);
			int result = pstmt.executeUpdate();
			
			// 수정여부 체크
			System.out.print("is updated? ");
			if(result < 1 ) {
				System.out.println("N");
			}else {
				System.out.println("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
