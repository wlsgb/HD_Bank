package main.java.dank.vo.deposit;

import main.java.dank.vo.EmployeeVO;

public class Account_AdminVO {
	private int ac_code, hd_code;
	private EmployeeVO employeeVO;
	private main.java.dank.vo.deposit.AccountVO accountVO;

	public int getAc_code() {
		return ac_code;
	}

	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}

	public int getHd_code() {
		return hd_code;
	}

	public void setHd_code(int hd_code) {
		this.hd_code = hd_code;
	}

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public main.java.dank.vo.deposit.AccountVO getAccountVO() {
		return accountVO;
	}

	public void setAccountVO(main.java.dank.vo.deposit.AccountVO accountVO) {
		this.accountVO = accountVO;
	}

}
