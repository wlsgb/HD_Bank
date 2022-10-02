package main.java.dank.vo;

public class LoanCheckVO {
	private int lc_num, mem_code, hd_code, lp_num;
	private String lc_state;
	private main.java.dank.vo.LoanApplicationVO loanApplicationVO;
	private main.java.dank.vo.LoanProductVO loanProductVO;
	private main.java.dank.vo.LoanRepayVO loanRepayVO;

	public main.java.dank.vo.LoanRepayVO getLoanRepayVO() {
		return loanRepayVO;
	}

	public void setLoanRepayVO(main.java.dank.vo.LoanRepayVO loanRepayVO) {
		this.loanRepayVO = loanRepayVO;
	}

	public main.java.dank.vo.LoanProductVO getLoanProductVO() {
		return loanProductVO;
	}

	public void setLoanProductVO(main.java.dank.vo.LoanProductVO loanProductVO) {
		this.loanProductVO = loanProductVO;
	}

	public main.java.dank.vo.LoanApplicationVO getLoanApplicationVO() {
		return loanApplicationVO;
	}

	public void setLoanApplicationVO(main.java.dank.vo.LoanApplicationVO loanApplicationVO) {
		this.loanApplicationVO = loanApplicationVO;
	}

	public int getLc_num() {
		return lc_num;
	}

	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public int getHd_code() {
		return hd_code;
	}

	public void setHd_code(int hd_code) {
		this.hd_code = hd_code;
	}

	public int getLp_num() {
		return lp_num;
	}

	public void setLp_num(int lp_num) {
		this.lp_num = lp_num;
	}

	public String getLc_state() {
		return lc_state;
	}

	public void setLc_state(String lc_state) {
		this.lc_state = lc_state;
	}

}
