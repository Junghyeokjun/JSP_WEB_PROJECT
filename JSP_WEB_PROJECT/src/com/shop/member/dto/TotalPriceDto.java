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
	
	// 화면에 노출되는 등급 표시하기(따로 메서드 활용)
	public String getMembergrade() {
		String meaning = null;
		if(this.grade.equals("A"))
			meaning = "VIP";
		else if(this.grade.equals("B"))
			meaning = "일반";
		else if(this.grade.equals("C"))
			meaning = "직원";
		return meaning;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}	
}
