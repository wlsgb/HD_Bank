package dank.mvc.vo;

public class LoanRepayLogVO {
	private int lrl_num,lc_num,lrl_amount,lrl_interest,lrl_total;
	String mdate;
	
	
	
	

	public int getLrl_num() {
		return lrl_num;
	}

	public void setLrl_num(int lrl_num) {
		this.lrl_num = lrl_num;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getLc_num() {
		return lc_num;
	}

	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}

	public int getLrl_amount() {
		return lrl_amount;
	}

	public void setLrl_amount(int lrl_amount) {
		this.lrl_amount = lrl_amount;
	}

	public int getLrl_interest() {
		return lrl_interest;
	}

	public void setLrl_interest(int lrl_interest) {
		this.lrl_interest = lrl_interest;
	}

	public int getLrl_total() {
		return lrl_total;
	}

	public void setLrl_total(int lrl_total) {
		this.lrl_total = lrl_total;
	}
	
	
}
