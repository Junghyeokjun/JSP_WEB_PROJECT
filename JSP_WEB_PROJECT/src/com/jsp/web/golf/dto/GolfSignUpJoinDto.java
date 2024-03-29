package com.jsp.web.golf.dto;

//SELECT class.regist_month,member.c_no,member.c_name,teacher.class_name,class.class_area,class.tuition,member.grade
//FROM TBL_CLASS_202201 class, TBL_MEMBER_202201 member, TBL_TEACHER_202201 teacher
//where class.C_NO=member.C_NO and class.teacher_code=teacher.teacher_code
//ORDER by class.regist_month asc, member.c_no asc;

public class GolfSignUpJoinDto {
	private String registMonth;
	private String cNo;
	private String cName;
	private String className;
	private String classArea;
	private int tuition;
	private String grade;
	
	public GolfSignUpJoinDto() {
		
	}

	public GolfSignUpJoinDto(String registMonth, String cNo, String cName, String className, String classArea,
			int tuition, String grade) {
		this.registMonth = registMonth;
		this.cNo = cNo;
		this.cName = cName;
		this.className = className;
		this.classArea = classArea;
		this.tuition = tuition;
		this.grade = grade;
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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
	
}
