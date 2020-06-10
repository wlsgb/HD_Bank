
package dank.mvc.vo;

public class MemberVO {

	private int mem_code,mem_pri_chk,mem_email_chk;
	private String mem_email, mem_pwd, mem_name, mem_phn, mem_in_date, mem_birth, mem_gender, mem_loc;

	 

	public int getMem_email_chk() {
		return mem_email_chk;
	}

	public void setMem_email_chk(int mem_email_chk) {
		this.mem_email_chk = mem_email_chk;
	}

	public String getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public int getMem_pri_chk() {
		return mem_pri_chk;
	}

	public void setMem_pri_chk(int mem_pri_chk) {
		this.mem_pri_chk = mem_pri_chk;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phn() {
		return mem_phn;
	}

	public void setMem_phn(String mem_phn) {
		this.mem_phn = mem_phn;
	}

	public String getMem_in_date() {
		return mem_in_date;
	}

	public void setMem_in_date(String mem_in_date) {
		this.mem_in_date = mem_in_date;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_loc() {
		return mem_loc;
	}

	public void setMem_loc(String mem_loc) {
		this.mem_loc = mem_loc;
	}


}