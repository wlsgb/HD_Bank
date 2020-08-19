package dank.mvc.vo;

public class HDCardVO {

	private String card_num, card_type, valid_thru;
	private int mem_code, ac_code;
	
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getValid_thru() {
		return valid_thru;
	}
	public void setValid_thru(String valid_thru) {
		this.valid_thru = valid_thru;
	}
	public int getMem_code() {
		return mem_code;
	}
	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}
	public int getAc_code() {
		return ac_code;
	}
	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}
	
}
