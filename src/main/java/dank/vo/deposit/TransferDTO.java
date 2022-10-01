package main.java.dank.vo.deposit;
/*
 * 
 * mapmy.put("ac_num", myac);
		mapmy.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		mapmy.put("at_dps_ac", yourac);
		mapmy.put("at_set_mony", trmoney);
 * */
public class TransferDTO {

	private String ac_num,mem_code,at_dps_ac,at_set_mony,sp_name;
	
	//�ڵ���ü�� �ʿ��ؼ� �׳� �־��(service if �ɸ���)
	private String ata_code;
	
	//HD_Code?
	private String hd_code;
	
	public String getHd_code() {
		return hd_code;
	}

	public void setHd_code(String hd_code) {
		this.hd_code = hd_code;
	}

	public String getAta_code() {
		return ata_code;
	}

	public void setAta_code(String ata_code) {
		this.ata_code = ata_code;
	}

	public String getSp_name() {
		return sp_name;
	}

	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public String getMem_code() {
		return mem_code;
	}

	public void setMem_code(String mem_code) {
		this.mem_code = mem_code;
	}

	public String getAt_dps_ac() {
		return at_dps_ac;
	}

	public void setAt_dps_ac(String at_dps_ac) {
		this.at_dps_ac = at_dps_ac;
	}

	public String getAt_set_mony() {
		return at_set_mony;
	}

	public void setAt_set_mony(String at_set_mony) {
		this.at_set_mony = at_set_mony;
	}
}
