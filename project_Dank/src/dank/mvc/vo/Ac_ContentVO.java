package dank.mvc.vo;

public class Ac_ContentVO {
//	"ACC_CODE"	number		NOT NULL,
//	"AC_NUM"	number		NOT NULL,
//	"DEP_CODE"	number		NULL,
//	"WIT_CODE"	number		NULL,
//	"ACC_NAME"	varchar2(30)		NULL,
//	"AT_CODE"	number		NULL
	
	private int acc_code,ac_num,dep_code,wit_code,at_code;
	private String acc_name;
	public int getAcc_code() {
		return acc_code;
	}
	public void setAcc_code(int acc_code) {
		this.acc_code = acc_code;
	}
	public int getAc_num() {
		return ac_num;
	}
	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
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
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	
	
	
}
