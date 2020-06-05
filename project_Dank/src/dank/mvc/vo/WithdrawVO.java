package dank.mvc.vo;

public class WithdrawVO {
//	"WIT_CODE"	number		NOT NULL,
//	"WIT_MONEY"	number		NOT NULL,
//	"WIT_DATE"	date		NOT NULL\
	private int wit_code,wit_money;
	private String wit_date;
	public int getWit_code() {
		return wit_code;
	}
	public void setWit_code(int wit_code) {
		this.wit_code = wit_code;
	}
	public int getWit_money() {
		return wit_money;
	}
	public void setWit_money(int wit_money) {
		this.wit_money = wit_money;
	}
	public String getWit_date() {
		return wit_date;
	}
	public void setWit_date(String wit_date) {
		this.wit_date = wit_date;
	}
}
