package com.jsp.web.golf.dto;

/*	
  	C_NO    NOT NULL CHAR(5)      
	C_NAME           VARCHAR2(15) 
	PHONE            VARCHAR2(11) 
	ADDRESS          VARCHAR2(50) 
	GRADE            VARCHAR2(6)
*/

public class GolfMemberDto {
	private String cNo;
	private String cName;
	private String phone;
	private String address;
	private String grade;
	
	public GolfMemberDto() {
		
	}

	public GolfMemberDto(String cNo, String cName, String phone, String address, String grade) {
		this.cNo = cNo;
		this.cName = cName;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
