package dank.mvc.service;

import java.util.Map;

import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.deposit.TransferDTO;

public abstract class BangkingAbs {

	public abstract void transferprocess(TransferDTO my_tr,TransferDTO your_tr);
	public abstract void startrepay(LoanRepayVO vo,String trmoney,Map<String, String> mapmy,Map<String, String> mapmysp,
			Map<String, String> mapyour,Map<String, String> mapyoursp);
}
