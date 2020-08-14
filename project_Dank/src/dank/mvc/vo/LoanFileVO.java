package dank.mvc.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class LoanFileVO {
	private int lf_num,lc_num;
	private String lf_name, lf_oriname,lf_sysdate;
	private MultipartFile mfile;
	private List<LoanFileVO> list;
	
	
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public List<LoanFileVO> getList() {
		return list;
	}
	public void setList(List<LoanFileVO> list) {
		this.list = list;
	}
	public int getLf_num() {
		return lf_num;
	}
	public void setLf_num(int lf_num) {
		this.lf_num = lf_num;
	}
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public String getLf_name() {
		return lf_name;
	}
	public void setLf_name(String lf_name) {
		this.lf_name = lf_name;
	}
	public String getLf_oriname() {
		return lf_oriname;
	}
	public void setLf_oriname(String lf_oriname) {
		this.lf_oriname = lf_oriname;
	}
	public String getLf_sysdate() {
		return lf_sysdate;
	}
	public void setLf_sysdate(String lf_sysdate) {
		this.lf_sysdate = lf_sysdate;
	}
	
}
