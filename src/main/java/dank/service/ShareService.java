package main.java.dank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.dank.dao.ShareDao;
import main.java.dank.vo.deposit.AccountVO;
import main.java.dank.vo.deposit.Account_ClientVO;

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
