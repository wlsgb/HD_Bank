package main.java.dank.vo;

public class Curr_VisitorVO {
	private int cv_code, mem_code;
	private String cv_ip, cv_time, cv_page, cv_url, cv_referer, cv_agent;
	private main.java.dank.vo.MemberVO memberVO;

	public int getCv_code() {
		return cv_code;
	}

	public void setCv_code(int cv_code) {
		this.cv_code = cv_code;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public String getCv_ip() {
		return cv_ip;
	}

	public void setCv_ip(String cv_ip) {
		this.cv_ip = cv_ip;
	}

	public String getCv_time() {
		return cv_time;
	}

	public void setCv_time(String cv_time) {
		this.cv_time = cv_time;
	}

	public String getCv_page() {
		return cv_page;
	}

	public void setCv_page(String cv_page) {
		this.cv_page = cv_page;
	}

	public String getCv_url() {
		return cv_url;
	}

	public void setCv_url(String cv_url) {
		this.cv_url = cv_url;
	}

	public String getCv_referer() {
		return cv_referer;
	}

	public void setCv_referer(String cv_referer) {
		this.cv_referer = cv_referer;
	}

	public String getCv_agent() {
		return cv_agent;
	}

	public void setCv_agent(String cv_agent) {
		this.cv_agent = cv_agent;
	}

	public main.java.dank.vo.MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(main.java.dank.vo.MemberVO memberVO) {
		this.memberVO = memberVO;
	}
}
