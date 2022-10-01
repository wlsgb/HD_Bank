package dank.mvc.vo.deposit;

public class Shared_challengeVO {
//	CREATE TABLE "SHARED_CHALLENGE" (
//			"SHAC_CODE"	number		NOT NULL,
//			"SHAC_MANNUM"	number	DEFAULT 2	NOT NULL,
//			"SHAC_MASTER"	NUMBER	DEFAULT 1	NOT NULL
//		);
	private int shac_code,shac_mannum,shac_master;

	public int getShac_code() {
		return shac_code;
	}

	public void setShac_code(int shac_code) {
		this.shac_code = shac_code;
	}

	public int getShac_mannum() {
		return shac_mannum;
	}

	public void setShac_mannum(int shac_mannum) {
		this.shac_mannum = shac_mannum;
	}

	public int getShac_master() {
		return shac_master;
	}

	public void setShac_master(int shac_master) {
		this.shac_master = shac_master;
	}
}
