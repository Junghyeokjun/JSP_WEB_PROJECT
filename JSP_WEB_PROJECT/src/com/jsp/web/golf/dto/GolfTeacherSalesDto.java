package com.jsp.web.golf.dto;


public class GolfTeacherSalesDto {
	private String teacherCode;
	private String className;
	private String teacherName;
	private int tuition;
	
	public GolfTeacherSalesDto(){
		
	}

	public GolfTeacherSalesDto(String teacherCode, String className, String teacherName, int tuition) {
		this.teacherCode = teacherCode;
		this.className = className;
		this.teacherName = teacherName;
		this.tuition = tuition;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
	
	
	
	
	
}
