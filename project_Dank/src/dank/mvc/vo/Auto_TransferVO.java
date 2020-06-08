package dank.mvc.vo;

public class Auto_TransferVO {
//	"AT_CODE"	number		NOT NULL,
//	"AT_DPS_AC"	varchar2(30)		NOT NULL,
//	"AT_SET_MONY"	number		NOT NULL,
//	"AT_INTERV"	number		NOT NULL,
//	"AT_STARTDT"	varchar2(30)		NOT NULL,
//	"AT_STOPDT"	varchar2(30)		NOT NULL
	
	private int at_code,at_set_mony,at_interv;
	private String at_dps_ac,at_startdt,at_stopdt;
	public int getAt_code() {
		return at_code;
	}
	public void setAt_code(int at_code) {
		this.at_code = at_code;
	}
	public int getAt_set_mony() {
		return at_set_mony;
	}
	public void setAt_set_mony(int at_set_mony) {
		this.at_set_mony = at_set_mony;
	}
	public int getAt_interv() {
		return at_interv;
	}
	public void setAt_interv(int at_interv) {
		this.at_interv = at_interv;
	}
	public String getAt_dps_ac() {
		return at_dps_ac;
	}
	public void setAt_dps_ac(String at_dps_ac) {
		this.at_dps_ac = at_dps_ac;
	}
	public String getAt_startdt() {
		return at_startdt;
	}
	public void setAt_startdt(String at_startdt) {
		this.at_startdt = at_startdt;
	}
	public String getAt_stopdt() {
		return at_stopdt;
	}
	public void setAt_stopdt(String at_stopdt) {
		this.at_stopdt = at_stopdt;
	}
	

}
