package main.java.dank.vo.security;

import main.java.dank.vo.MemberVO;

public class Otp_RegVO {

	private int otp_code, mem_code;
	private String otp_certify;
	
	private MemberVO memberVO;

	public int getOtp_code() {
		return otp_code;
	}

	public void setOtp_code(int otp_code) {
		this.otp_code = otp_code;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public String getOtp_certify() {
		return otp_certify;
	}

	public void setOtp_certify(String otp_certify) {
		this.otp_certify = otp_certify;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	
}
