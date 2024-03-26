package com.jsp.web.golf.dto;

/*
	TEACHER_CODE       NOT NULL CHAR(3)      
	TEACHER_NAME        		VARCHAR2(15) 
	CLASS_NAME                  VARCHAR2(20) 
	CLASS_PRICE                 NUMBER(8)    
	TEACHER_REGIST_DATE         VARCHAR2(8)
*/  
public class GolfTeacherDto {
	private String teacherCode;
	private String teacherName;
	private String className;
	private int classPrice;
	private String teacherRegistDate;
	
	public GolfTeacherDto(){
		
	}
	
	
	public GolfTeacherDto(String teacherCode, String teacherName, String className, int classPrice,
			String teacherRegistDate) {
		this.teacherCode = teacherCode;
		this.teacherName = teacherName;
		this.className = className;
		this.classPrice = classPrice;
		this.teacherRegistDate = teacherRegistDate;
	}
	
	public String getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}
	public String getTeacherRegistDate() {
		return teacherRegistDate;
	}
	public void setTeacherRegistDate(String teacherRegistDate) {
		this.teacherRegistDate = teacherRegistDate;
	}
	
	
}
