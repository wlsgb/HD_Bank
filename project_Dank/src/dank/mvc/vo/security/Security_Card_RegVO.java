package dank.mvc.vo.security;

import dank.mvc.vo.MemberVO;

public class Security_Card_RegVO {

	private int scr_code, mem_code, scr_certify, sc_code;
	private Security_CardVO security_CardVO;
	private MemberVO memberVO;

	public int getScr_code() {
		return scr_code;
	}

	public void setScr_code(int scr_code) {
		this.scr_code = scr_code;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public int getScr_certify() {
		return scr_certify;
	}

	public void setScr_certify(int scr_certify) {
		this.scr_certify = scr_certify;
	}

	public int getSc_code() {
		return sc_code;
	}

	public void setSc_code(int sc_code) {
		this.sc_code = sc_code;
	}

	public Security_CardVO getSecurity_CardVO() {
		return security_CardVO;
	}

	public void setSecurity_CardVO(Security_CardVO security_CardVO) {
		this.security_CardVO = security_CardVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

}
