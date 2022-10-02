package main.java.dank.vo.deposit;

import main.java.dank.vo.MemberVO;

public class Account_ClientVO {
	private int ac_code, mem_code, pro_code;
	private MemberVO memberVO;
	private main.java.dank.vo.deposit.AccountVO accountVO;
	private main.java.dank.vo.deposit.ProductVO productVO;

	public int getAc_code() {

		return ac_code;
	}

	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public int getPro_code() {
		return pro_code;
	}

	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public main.java.dank.vo.deposit.AccountVO getAccountVO() {
		return accountVO;
	}

	public void setAccountVO(main.java.dank.vo.deposit.AccountVO accountVO) {
		this.accountVO = accountVO;
	}

	public main.java.dank.vo.deposit.ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(main.java.dank.vo.deposit.ProductVO productVO) {
		this.productVO = productVO;
	}

}
