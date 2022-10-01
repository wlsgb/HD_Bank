package main.java.dank.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.dank.dao.BangkingDao;
import main.java.dank.dao.DepositDao;
import main.java.dank.dao.HDPayDao;
import main.java.dank.vo.PaymentVO;
import main.java.dank.vo.deposit.AccountVO;
import main.java.dank.vo.deposit.Account_ClientVO;
import main.java.dank.vo.deposit.TransferDTO;

@Service
@Transactional
public class DepositService {
	@Autowired
	private DepositDao depositDao;
	@Autowired
	private BangkingDao bangkingdao;
	@Autowired
	private HDPayDao payDao;
	
	public void newAccount(AccountVO accountVO, Account_ClientVO clientVO) {
		depositDao.addAccount(accountVO);
		depositDao.addAcClient(clientVO);
	}
	
	//���� ��ü,����
	public String cancelComplete(int ac_code,TransferDTO my_tr,TransferDTO your_tr) {
		
		//���� ��ü
		bangkingdao.trpluswittr(my_tr);
		bangkingdao.trplusspwit(my_tr);
		bangkingdao.trtrwitupbal(my_tr);
		
		bangkingdao.trplusdeptr(your_tr);
		bangkingdao.trplusspdep(your_tr);
		bangkingdao.trtrdepupbal(your_tr);
		
		//���� ����
		depositDao.delAccount(ac_code);
		
		return "deposit_new/cancel_success";
	}
	
	public void payment(String money,Map<String, String> paramapsp,Map<String, String> paramapbal,PaymentVO vo) {
		bangkingdao.witpluswit(money);
		bangkingdao.witplussp(paramapsp);
		bangkingdao.witwitupbalance(paramapbal);
		payDao.pay(vo);
	}
}
