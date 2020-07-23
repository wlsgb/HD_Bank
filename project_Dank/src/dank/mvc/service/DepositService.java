package dank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.DepositDao;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.Account_ClientVO;
import dank.mvc.vo.deposit.TransferDTO;

@Service
@Transactional
public class DepositService {
	@Autowired
	private DepositDao depositDao;
	@Autowired
	private BangkingDao bangkingdao;
	
	public void newAccount(AccountVO accountVO, Account_ClientVO clientVO) {
		depositDao.addAccount(accountVO);
		depositDao.addAcClient(clientVO);
	}
	
	//∞Ë¡¬ ¿Ã√º,ªË¡¶
	public String cancelComplete(int ac_code,TransferDTO my_tr,TransferDTO your_tr) {
		
		//∞Ë¡¬ ¿Ã√º
		bangkingdao.trpluswittr(my_tr);
		bangkingdao.trplusspwit(my_tr);
		bangkingdao.trtrwitupbal(my_tr);
		
		bangkingdao.trplusdeptr(your_tr);
		bangkingdao.trplusspdep(your_tr);
		bangkingdao.trtrdepupbal(your_tr);
		
		//∞Ë¡¬ ªË¡¶
		depositDao.delAccount(ac_code);
		
		return "deposit_new/cancel_success";
	}
	
}
