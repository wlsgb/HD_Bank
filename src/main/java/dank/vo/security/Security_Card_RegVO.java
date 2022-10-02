package main.java.dank.vo.security;

import main.java.dank.vo.MemberVO;

public class Security_Card_RegVO {

	private int scr_code, mem_code, sc_code, scr_certify;
	private main.java.dank.vo.security.Security_CardVO secCard;
	private MemberVO memberVO;

	public int getScr_certify() {
		return scr_certify;
	}

	public void setScr_certify(int scr_certify) {
		this.scr_certify = scr_certify;
	}

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

	public int getSc_code() {
		return sc_code;
	}

	public void setSc_code(int sc_code) {
		this.sc_code = sc_code;
	}

	public main.java.dank.vo.security.Security_CardVO getSecCard() {
		return secCard;
	}

	public void setSecCard(main.java.dank.vo.security.Security_CardVO secCard) {
		this.secCard = secCard;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

}
