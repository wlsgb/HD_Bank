package main.java.dank.vo.deposit;

public class AccountVO {
	private int ac_code, ac_balance;
	private String ac_num, ac_pwd, ac_name, ac_start_date, end_date;
	private main.java.dank.vo.deposit.ProductVO productVO;
	private main.java.dank.vo.deposit.Account_ClientVO account_ClientVO;
	private main.java.dank.vo.deposit.SavingVO saving;
	private main.java.dank.vo.deposit.Installment_savingVO ins;

	public main.java.dank.vo.deposit.Account_ClientVO getAccount_ClientVO() {
		return account_ClientVO;
	}

	public void setAccount_ClientVO(main.java.dank.vo.deposit.Account_ClientVO account_ClientVO) {
		this.account_ClientVO = account_ClientVO;
	}

	public main.java.dank.vo.deposit.ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(main.java.dank.vo.deposit.ProductVO productVO) {
		this.productVO = productVO;
	}

	public main.java.dank.vo.deposit.SavingVO getSaving() {
		return saving;
	}

	public void setSaving(main.java.dank.vo.deposit.SavingVO saving) {
		this.saving = saving;
	}

	public main.java.dank.vo.deposit.Installment_savingVO getIns() {
		return ins;
	}

	public void setIns(main.java.dank.vo.deposit.Installment_savingVO ins) {
		this.ins = ins;
	}

	public int getAc_code() {
		return ac_code;
	}

	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}

	public int getAc_balance() {
		return ac_balance;
	}

	public void setAc_balance(int ac_balance) {
		this.ac_balance = ac_balance;
	}

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public String getAc_pwd() {
		return ac_pwd;
	}

	public void setAc_pwd(String ac_pwd) {
		this.ac_pwd = ac_pwd;
	}

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public String getAc_start_date() {
		return ac_start_date;
	}

	public void setAc_start_date(String ac_start_date) {
		this.ac_start_date = ac_start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
}
