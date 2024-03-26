package com.jsp.web.golf.dto;

/*
	REGIST_MONTH NOT NULL VARCHAR2(6)  
	C_NO         NOT NULL CHAR(5)      
	CLASS_AREA            VARCHAR2(15) 
	TUITION               NUMBER(8)    
	TEACHER_CODE          CHAR(3) 
 */

public class GolfClassDto {
	private String registMonth;
	private String cNo;
	private String classArea;
	private int tuition;
	private String teacherCode;
	
	public GolfClassDto() {
		
	}

	public GolfClassDto(String registMonth, String cNo, String classArea, int tuition, String teacherCode) {
		this.registMonth = registMonth;
		this.cNo = cNo;
		this.classArea = classArea;
		this.tuition = tuition;
		this.teacherCode = teacherCode;
	}

	public String getRegistMonth() {
		return registMonth;
	}

	public void setRegistMonth(String registMonth) {
		this.registMonth = registMonth;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getClassArea() {
		return classArea;
	}

	public void setClassArea(String classArea) {
		this.classArea = classArea;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	
	
}
