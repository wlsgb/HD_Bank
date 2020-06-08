package dank.mvc.vo;

public class SavingVO {
	private int sav_code,sav_interestrate,sav_online,qua_code,shas_code;
	private String sav_name;
	private QualificationVO qualificationVO;
	
	
	public int getSav_code() {
		return sav_code;
	}
	public void setSav_code(int sav_code) {
		this.sav_code = sav_code;
	}
	public int getSav_interestrate() {
		return sav_interestrate;
	}
	public void setSav_interestrate(int sav_interestrate) {
		this.sav_interestrate = sav_interestrate;
	}
	public int getSav_online() {
		return sav_online;
	}
	public void setSav_online(int sav_online) {
		this.sav_online = sav_online;
	}
	public int getQua_code() {
		return qua_code;
	}
	public void setQua_code(int qua_code) {
		this.qua_code = qua_code;
	}
	public String getSav_name() {
		return sav_name;
	}
	public void setSav_name(String sav_name) {
		this.sav_name = sav_name;
	}
	
	
}
