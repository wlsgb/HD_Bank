package dank.mvc.vo.deposit;

public class ProductVO {
//	CREATE TABLE "PRODUCT" (
//			"PRO_CODE"	number		NOT NULL,
//			"INS_CODE"	number		NULL,
//			"SAV_CODE"	number		NOT NULL
//		);
	private int pro_code,ins_code,sav_code;

	public int getPro_code() {
		return pro_code;
	}

	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}

	public int getIns_code() {
		return ins_code;
	}

	public void setIns_code(int ins_code) {
		this.ins_code = ins_code;
	}

	public int getSav_code() {
		return sav_code;
	}

	public void setSav_code(int sav_code) {
		this.sav_code = sav_code;
	}
	
}
