package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
