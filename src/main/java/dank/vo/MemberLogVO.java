package main.java.dank.vo;

public class MemberLogVO {
	private int ml_code, mem_code;
	private String ml_ip, ml_check, ml_time;

	public int getMl_code() {
		return ml_code;
	}

	public void setMl_code(int ml_code) {
		this.ml_code = ml_code;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public String getMl_ip() {
		return ml_ip;
	}

	public void setMl_ip(String ml_ip) {
		this.ml_ip = ml_ip;
	}

	public String getMl_check() {
		return ml_check;
	}

	public void setMl_check(String ml_check) {
		this.ml_check = ml_check;
	}

	public String getMl_time() {
		return ml_time;
	}

	public void setMl_time(String ml_time) {
		this.ml_time = ml_time;
	}
}
