package dank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import dank.mvc.dao.DepositDao;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.Account_ClientVO;

@Service
@Transactional
public class DepositService {
	@Autowired
	private DepositDao depositDao;
	
	public void newAccount(AccountVO accountVO, Account_ClientVO clientVO) {
		depositDao.addAccount(accountVO);
		depositDao.addAcClient(clientVO);
	}
	
	//∞Ë¡¬ ªË¡¶
	@RequestMapping(value = { "/cancelComplete" })
	public String cancelComplete(int ac_code) {
		
		
		
		depositDao.delAccount(ac_code);
		return "deposit_new/cancel_success";
	}
	
}
