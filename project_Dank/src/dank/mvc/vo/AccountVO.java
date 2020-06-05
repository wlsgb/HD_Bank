package dank.mvc.vo;

public class AccountVO {
	private int ac_num,mem_code,pro_code,ac_balance;
	private String ac_pwd,ac_start_date,ac_end_date;
	
	public int getAc_num() {
		return ac_num;
	}
	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
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
	public int getAc_balance() {
		return ac_balance;
	}
	public void setAc_balance(int ac_balance) {
		this.ac_balance = ac_balance;
	}
	public String getAc_pwd() {
		return ac_pwd;
	}
	public void setAc_pwd(String ac_pwd) {
		this.ac_pwd = ac_pwd;
	}
	public String getAc_start_date() {
		return ac_start_date;
	}
	public void setAc_start_date(String ac_start_date) {
		this.ac_start_date = ac_start_date;
	}
	public String getAc_end_date() {
		return ac_end_date;
	}
	public void setAc_end_date(String ac_end_date) {
		this.ac_end_date = ac_end_date;
	}
	
	
}
