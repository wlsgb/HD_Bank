package dank.mvc.vo.deposit;

public class QualificationVO {
//	CREATE TABLE "QUALIFICATION" (
//			"QUA_CODE"	number		NOT NULL,
//			"QUA_NAME"	VARCHAR(10)		NOT NULL,
//			"QUA_MAXAGE"	NUMBER		NULL,
//			"QUA_MINAGE"	NUMBER		NULL,
//			"QUA_MINMONEY"	NUMBER		NULL,
//			"QUA_MAXMONEY"	NUMBER		NULL,
//			"QUA_MINCAL"	NUMBER		NULL,
//			"QUA_MAXCAL"	NUMBER		NULL
//		);
	private int qua_code,qua_maxage,qua_minage,qua_minmoney,qua_maxmoney,qua_mincal,qua_maxcal;
	private String qua_name;
	public int getQua_code() {
		return qua_code;
	}
	public void setQua_code(int qua_code) {
		this.qua_code = qua_code;
	}
	public int getQua_maxage() {
		return qua_maxage;
	}
	public void setQua_maxage(int qua_maxage) {
		this.qua_maxage = qua_maxage;
	}
	public int getQua_minage() {
		return qua_minage;
	}
	public void setQua_minage(int qua_minage) {
		this.qua_minage = qua_minage;
	}
	public int getQua_minmoney() {
		return qua_minmoney;
	}
	public void setQua_minmoney(int qua_minmoney) {
		this.qua_minmoney = qua_minmoney;
	}
	public int getQua_maxmoney() {
		return qua_maxmoney;
	}
	public void setQua_maxmoney(int qua_maxmoney) {
		this.qua_maxmoney = qua_maxmoney;
	}
	public int getQua_mincal() {
		return qua_mincal;
	}
	public void setQua_mincal(int qua_mincal) {
		this.qua_mincal = qua_mincal;
	}
	public int getQua_maxcal() {
		return qua_maxcal;
	}
	public void setQua_maxcal(int qua_maxcal) {
		this.qua_maxcal = qua_maxcal;
	}
	public String getQua_name() {
		return qua_name;
	}
	public void setQua_name(String qua_name) {
		this.qua_name = qua_name;
	}
	
}
