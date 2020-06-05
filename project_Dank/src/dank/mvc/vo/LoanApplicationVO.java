package dank.mvc.vo;

public class LoanApplicationVO {

	private int lc_num,la_hamount;
	private String la_startdate,la_livingterm,la_repayterm,lr_type;
	public int getLc_num() {
		return lc_num;
	}
	public void setLc_num(int lc_num) {
		this.lc_num = lc_num;
	}
	public int getLa_hamount() {
		return la_hamount;
	}
	public void setLa_hamount(int la_hamount) {
		this.la_hamount = la_hamount;
	}
	public String getLa_startdate() {
		return la_startdate;
	}
	public void setLa_startdate(String la_startdate) {
		this.la_startdate = la_startdate;
	}
	public String getLa_livingterm() {
		return la_livingterm;
	}
	public void setLa_livingterm(String la_livingterm) {
		this.la_livingterm = la_livingterm;
	}
	public String getLa_repayterm() {
		return la_repayterm;
	}
	public void setLa_repayterm(String la_repayterm) {
		this.la_repayterm = la_repayterm;
	}
	public String getLr_type() {
		return lr_type;
	}
	public void setLr_type(String lr_type) {
		this.lr_type = lr_type;
	}
	
	
}
