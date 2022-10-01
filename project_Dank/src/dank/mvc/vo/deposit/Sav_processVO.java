package dank.mvc.vo.deposit;

public class Sav_processVO {
//	CREATE TABLE "SAV_PROCESS" (
//			"SP_CODE"	number		NOT NULL,
//			"AC_CODE"	number		NOT NULL,
//			"SP_NAME"	varchar2(30)		NULL,
//			"DEP_CODE"	number		NULL,
//			"WIT_CODE"	number		NULL,
//			"AT_CODE"	number		NULL
//		);
	private int sp_code,ac_code,dep_code,wit_code,at_code,sp_balance;
	public int getSp_balance() {
		return sp_balance;
	}
	public void setSp_balance(int sp_balance) {
		this.sp_balance = sp_balance;
	}
	private String sp_name;
	public int getSp_code() {
		return sp_code;
	}
	public void setSp_code(int sp_code) {
		this.sp_code = sp_code;
	}
	public int getAc_code() {
		return ac_code;
	}
	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}
	public int getDep_code() {
		return dep_code;
	}
	public void setDep_code(int dep_code) {
		this.dep_code = dep_code;
	}
	public int getWit_code() {
		return wit_code;
	}
	public void setWit_code(int wit_code) {
		this.wit_code = wit_code;
	}
	public int getAt_code() {
		return at_code;
	}
	public void setAt_code(int at_code) {
		this.at_code = at_code;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
}
