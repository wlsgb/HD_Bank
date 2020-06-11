package dank.mvc.vo.deposit;

public class AccountHistoryVO {
	
	private int r_num;
	private String dealdate,dep_money,wit_money,balance,name;
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getDealdate() {
		return dealdate;
	}
	public void setDealdate(String dealdate) {
		this.dealdate = dealdate;
	}
	public String getDep_money() {
		return dep_money;
	}
	public void setDep_money(String dep_money) {
		this.dep_money = dep_money;
	}
	public String getWit_money() {
		return wit_money;
	}
	public void setWit_money(String wit_money) {
		this.wit_money = wit_money;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
