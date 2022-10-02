package main.java.dank.vo.deposit;

public class ProductVO {
	//	CREATE TABLE "PRODUCT" (
	//			"PRO_CODE"	number		NOT NULL,
	//			"INS_CODE"	number		NULL,
	//			"SAV_CODE"	number		NOT NULL
	//		);
	private int pro_code, ins_code, sav_code;
	private main.java.dank.vo.deposit.SavingVO savingVO;
	private main.java.dank.vo.deposit.Installment_savingVO installment_savingVO;

	public main.java.dank.vo.deposit.SavingVO getSavingVO() {
		return savingVO;
	}

	public void setSavingVO(main.java.dank.vo.deposit.SavingVO savingVO) {
		this.savingVO = savingVO;
	}

	public main.java.dank.vo.deposit.Installment_savingVO getInstallment_savingVO() {
		return installment_savingVO;
	}

	public void setInstallment_savingVO(main.java.dank.vo.deposit.Installment_savingVO installment_savingVO) {
		this.installment_savingVO = installment_savingVO;
	}

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
