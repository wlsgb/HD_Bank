package main.java.dank.vo.deposit;

public class Installment_savingVO {
	private int ins_code, ins_online, ins_interestrate, ins_droprate, ins_putmoney, ins_term, shac_code, qua_code;
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

	public int getIns_putmoney() {
		return ins_putmoney;
	}

	public void setIns_putmoney(int ins_putmoney) {
		this.ins_putmoney = ins_putmoney;
	}

	public int getIns_term() {
		return ins_term;
	}

	public void setIns_term(int ins_term) {
		this.ins_term = ins_term;
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
