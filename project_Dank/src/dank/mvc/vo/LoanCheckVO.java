package dank.mvc.vo;

public class LoanCheckVO {
	private int lc_num,mem_code,hd_code,lp_num;
	private String lc_state;
	private LoanApplicationVO loanApplicationVO;
	private LoanProductVO loanProductVO;
	
	
	
	public LoanProductVO getLoanProductVO() {
		return loanProductVO;
	}
	public void setLoanProductVO(LoanProductVO loanProductVO) {
		this.loanProductVO = loanProductVO;
	}
	public LoanApplicationVO getLoanApplicationVO() {
		return loanApplicationVO;
	}
	public void setLoanApplicationVO(LoanApplicationVO loanApplicationVO) {
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
