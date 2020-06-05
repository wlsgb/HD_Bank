package dank.mvc.vo;

public class BalanceVO {
//	"Key"	number		NOT NULL,
//	"DEP_CODE"	number		NULL,
//	"WIT_CODE"	number		NULL
	private int key,dep_code,wit_code;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
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
	
}
