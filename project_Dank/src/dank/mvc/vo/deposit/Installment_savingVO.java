package dank.mvc.vo.deposit;

public class Installment_savingVO {
//	CREATE TABLE "INSTALLMENT_SAVING" (
//			"INS_CODE"	number		NOT NULL,
//			"INS_NAME"	varchar2(50)		NOT NULL,
//			"INS_ONLINE"	number		NOT NULL,
//			"INS_INTERESTRATE"	number		NOT NULL,
//			"INS_DROPRATE"	number		NOT NULL,
//			"INS_MONMONEY"	number		NOT NULL,
//			"INS_SLCTEDTERM"	NUMBER		NOT NULL,
//			"SHAC_CODE"	number	DEFAULT 0	NULL,
//			"QUA_CODE"	number		NOT NULL
//		);
	private int ins_code,ins_online,ins_interestrate,ins_droprate,ins_monmoney,ins_slctedterm,shac_code,qua_code;
	private String ins_name;
	private QualificationVO qualificationVO;
	
	public QualificationVO getQualificationVO() {
		return qualificationVO;
	}
	public void setQualificationVO(QualificationVO qualificationVO) {
		this.qualificationVO = qualificationVO;
	}
	public int getIns_code() {
		return ins_code;
	}
	public void setIns_code(int ins_code) {
		this.ins_code = ins_code;
	}
	public int getIns_online() {
		return ins_online;
	}
	public void setIns_online(int ins_online) {
		this.ins_online = ins_online;
	}
	public int getIns_interestrate() {
		return ins_interestrate;
	}
	public void setIns_interestrate(int ins_interestrate) {
		this.ins_interestrate = ins_interestrate;
	}
	public int getIns_droprate() {
		return ins_droprate;
	}
	public void setIns_droprate(int ins_droprate) {
		this.ins_droprate = ins_droprate;
	}
	public int getIns_monmoney() {
		return ins_monmoney;
	}
	public void setIns_monmoney(int ins_monmoney) {
		this.ins_monmoney = ins_monmoney;
	}
	public int getIns_slctedterm() {
		return ins_slctedterm;
	}
	public void setIns_slctedterm(int ins_slctedterm) {
		this.ins_slctedterm = ins_slctedterm;
	}
	public int getShac_code() {
		return shac_code;
	}
	public void setShac_code(int shac_code) {
		this.shac_code = shac_code;
	}
	public int getQua_code() {
		return qua_code;
	}
	public void setQua_code(int qua_code) {
		this.qua_code = qua_code;
	}
	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	
}
