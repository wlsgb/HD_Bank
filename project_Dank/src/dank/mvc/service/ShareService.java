package dank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.ShareDao;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.Account_ClientVO;

@Service
@Transactional
public class ShareService {
	@Autowired
	private ShareDao shareDao;
	public void newAccount(AccountVO accountVO, Account_ClientVO clientVO) {
		shareDao.addShareAccount(accountVO);
		shareDao.addAcClient(clientVO);
	}

	public void newAccount_for_share(AccountVO account, Account_ClientVO clientVO1) {
		shareDao.addShareAccount(account);
		shareDao.addAcClient(clientVO1);
		
	}
}
