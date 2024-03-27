package com.shop.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shop.member.dto.MemberDto;
import com.shop.member.dto.TotalPriceDto;

public class ShoppingDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String user = "scott";
	private String password = "tiger";

	public ShoppingDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {

		}
	}

	// String -> Timestamp
	public Timestamp strToTs(String joinDateStr) {
		Timestamp timestamp = null;
		try {
            // SimpleDateFormat을 사용하여 문자열을 날짜로 파싱
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(joinDateStr);

            // Date 객체를 long 값으로 변환
            long timeInMillis = parsedDate.getTime();

            // Timestamp 객체 생성
            timestamp = new Timestamp(timeInMillis);

            // 변환된 Timestamp 객체 사용
            System.out.println("Timestamp: " + timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }		
		return timestamp;
	}
	
	// 가입 페이지에 전달하는, 자동 시퀀스 값
	public int memberNo() {
		// 회원 번호를 저장하는 변수
		int memberNum = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select MEMBER_TBL_SEQ.nextval memberNo from dual";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberNum = rs.getInt("memberNo");
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
		return memberNum;
	}
	
	public void insertMember(MemberDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		String sql =  "insert into "
					+ "member_tbl_02(MEMBERNUM, MEMBERNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) "
					+ "values (?,?,?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMemberNum());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setTimestamp(5, member.getJoinDate());
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

		String sql = "select * from member_tbl_02";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// dto에 넣고, 이를 리스트에 추가
				int memberNum = rs.getInt("memberNum");
				String memberName = rs.getString("memberName");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Timestamp joinDate = rs.getTimestamp("joinDate");
				String grade = rs.getString("grade");
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
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNumInt);			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// dto에 넣고, 이를 리스트에 추가
				int memberNum = rs.getInt("memberNum");
				String memberName = rs.getString("memberName");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Timestamp joinDate = rs.getTimestamp("joinDate");
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
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// dto에 넣고, 이를 리스트에 추가
				int memberNum = rs.getInt("memberNum");
				String memberName = rs.getString("memberName");;
				String grade = rs.getString("grade");
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
	public void updateMember(MemberDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member_tbl_02 set phone = ?, address = ?, city = ? where memberNum = ?";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPhone());
			pstmt.setString(2, member.getAddress());
			pstmt.setString(3, member.getCity());
			pstmt.setInt(4, member.getMemberNum());
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
