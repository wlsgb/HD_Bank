package dank.mvc.vo.deposit;

public class DepositVO {
//	CREATE TABLE "DEPOSIT" (
//			"DEP_CODE"	number		NOT NULL,
//			"DEP_MONEY"	number		NOT NULL,
//			"DEP_DATE"	date		NOT NULL
//		);
	private int dep_code,dep_money;
	private String dep_date;
	public int getDep_code() {
		return dep_code;
	}
	public void setDep_code(int dep_code) {
		this.dep_code = dep_code;
	}
	public int getDep_money() {
		return dep_money;
	}
	public void setDep_money(int dep_money) {
		this.dep_money = dep_money;
	}
	public String getDep_date() {
		return dep_date;
	}
	public void setDep_date(String dep_date) {
		this.dep_date = dep_date;
	}
}
