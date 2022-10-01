package main.java.dank.vo;

public class LoanRepayVO {
	private int lc_num,lr_amount,lr_balance,lr_interest,lr_repaydate;
	private String lr_firstdate,lr_startdate,lr_reaccount;
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public int getLr_amount() {
		return lr_amount;
	}
	public void setLr_amount(int lr_amount) {
		this.lr_amount = lr_amount;
	}
	public int getLr_balance() {
		return lr_balance;
	}
	public void setLr_balance(int lr_balance) {
		this.lr_balance = lr_balance;
	}
	public int getLr_interest() {
		return lr_interest;
	}
	public void setLr_interest(int lr_interest) {
		this.lr_interest = lr_interest;
	}
	public int getLr_repaydate() {
		return lr_repaydate;
	}
	public void setLr_repaydate(int lr_repaydate) {
		this.lr_repaydate = lr_repaydate;
	}
	
	public String getLr_reaccount() {
		return lr_reaccount;
	}
	public void setLr_reaccount(String lr_reaccount) {
		this.lr_reaccount = lr_reaccount;
	}
	public String getLr_firstdate() {
		return lr_firstdate;
	}
	public void setLr_firstdate(String lr_firstdate) {
		this.lr_firstdate = lr_firstdate;
	}
	public String getLr_startdate() {
		return lr_startdate;
	}
	public void setLr_startdate(String lr_startdate) {
		this.lr_startdate = lr_startdate;
	}
	
}
