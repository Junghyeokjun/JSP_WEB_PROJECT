package com.shop.member.dto;

public class TotalPriceDto {
	// 조인한 두 테이블을 활용
	
	private int memberNum;
	private String memberName;
	private String grade;
	private int totalPrice;
	
	
	public TotalPriceDto(int memberNum, String memberName, String grade, int totalPrice) {	
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.grade = grade;
		this.totalPrice = totalPrice;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

	
	
}
