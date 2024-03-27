package com.shop.member.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MemberDto {
	// 고객 정보
	private int memberNum;
	private String memberName;
	private String phone;
	private String address;
	private Timestamp joinDate;
	private String grade;
	private String city;
	
	
	public MemberDto(int memberNum, String memberName, String phone, String address, Timestamp joinDate, String grade,
			String city) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.phone = phone;
		this.address = address;
		this.joinDate = joinDate;
		this.grade = grade;
		this.city = city;
	}
	
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	// 화면에 노출되는 등급 표시하기(따로 메서드 활용)
	public String getMemberGrade() {
		String meaning = null;
		if(this.grade.equals("A"))
			meaning = "VIP";
		else if(this.grade.equals("B"))
			meaning = "일반";
		else if(this.grade.equals("C"))
			meaning = "직원";
		return meaning;
	}
	
	// 화면에 보여줄 날짜 형식으로 보여주기
	public String getListbdate() {
		SimpleDateFormat listDate = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = listDate.format(joinDate);
		return dateFormat;
	}	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
