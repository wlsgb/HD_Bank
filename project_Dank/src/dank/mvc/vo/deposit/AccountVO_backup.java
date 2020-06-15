package dank.mvc.vo.deposit;

public class AccountVO_backup {
//	CREATE TABLE "ACCOUNT" (
//			"AC_CODE"	number		NOT NULL,
//			"MEM_CODE"	number		NOT NULL,
//			"AC_NUM"	char(10)		NOT NULL,
//			"AC_PWD"	char(4)		NOT NULL,
//			"AC_START_DATE"	date		NOT NULL,
//			"AC_END_DATE"	date		NULL,
//			"AC_BALANCE"	number		NOT NULL,
//			"PRO_CODE"	number		NOT NULL
//		);
	private int ac_code,mem_code,ac_balance,pro_code;
	private String ac_num,ac_pwd,ac_start_date,ac_end_date;
	
	private ProductVO product;
	private SavingVO saving;
	private Installment_savingVO ins;
	
	
	
	
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	public SavingVO getSaving() {
		return saving;
	}
	public void setSaving(SavingVO saving) {
		this.saving = saving;
	}
	public Installment_savingVO getIns() {
		return ins;
	}
	public void setIns(Installment_savingVO ins) {
		this.ins = ins;
	}
	public int getAc_code() {
		return ac_code;
	}
	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}
	public int getMem_code() {
		return mem_code;
	}
	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}
	public int getAc_balance() {
		return ac_balance;
	}
	public void setAc_balance(int ac_balance) {
		this.ac_balance = ac_balance;
	}
	public int getPro_code() {
		return pro_code;
	}
	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}
	public String getAc_num() {
		return ac_num;
	}
	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}
	public String getAc_pwd() {
		return ac_pwd;
	}
	public void setAc_pwd(String ac_pwd) {
		this.ac_pwd = ac_pwd;
	}
	public String getAc_start_date() {
		return ac_start_date;
	}
	public void setAc_start_date(String ac_start_date) {
		this.ac_start_date = ac_start_date;
	}
	public String getAc_end_date() {
		return ac_end_date;
	}
	public void setAc_end_date(String ac_end_date) {
		this.ac_end_date = ac_end_date;
	}
}
