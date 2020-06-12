package dank.mvc.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.dao.DepositDao;

@Repository
public class AccountNum {
	@Autowired
	private DepositDao depositDao;
	
	public String createAcNum() {
		
		return "";
	}
}
