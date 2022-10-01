package main.java.dank.vo.deposit;

public class Shared_savingVO {
//	CREATE TABLE "SHARED_SAVING" (
//			"SHAS_CODE"	number		NOT NULL,
//			"SHAS_COUNT"	NUMBER	DEFAULT 2	NOT NULL,
//			"SHAS_MASTAR"	NUMBER	DEFAULT 1	NOT NULL
//		);
	private int shas_code, shas_count, shas_master;
	private SavingVO savingVO;
	private QualificationVO qualificationVO;
	public QualificationVO getQualificationVO() {
		return qualificationVO;
	}

	public void setQualificationVO(QualificationVO qualificationVO) {
		this.qualificationVO = qualificationVO;
	}

	public SavingVO getSavingVO() {
		return savingVO;
	}

	public void setSavingVO(SavingVO savingVO) {
		this.savingVO = savingVO;
	}

	public int getShas_code() {
		return shas_code;
	}

	public void setShas_code(int shas_code) {
		this.shas_code = shas_code;
	}

	public int getShas_count() {
		return shas_count;
	}

	public void setShas_count(int shas_count) {
		this.shas_count = shas_count;
	}

	public int getShas_master() {
		return shas_master;
	}

	public void setShas_master(int shas_master) {
		this.shas_master = shas_master;
	}

}
