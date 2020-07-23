package dank.mvc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.LoanDao;
import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanRepayLogVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.deposit.TransferDTO;


@Service
@Transactional
public class LoanService {
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private BangkingDao bangkingdao;
	public void addloanaplication(LoanApplicationVO avo,LoanCheckVO vo) {
		loanDao.insertLoanCheck(vo);
		loanDao.insertLoanApllication(avo);
	}
	
	public void fileupload(LoanFileVO vo) {
		loanDao.fileupload(vo);
		loanDao.stateupdate(vo.getLc_num());
	}
	
	public void startrepay(LoanRepayVO vo,TransferDTO my_tr,TransferDTO your_tr) {
		bangkingdao.trpluswit(my_tr.getAt_set_mony());
		bangkingdao.trpluswittr(my_tr);
		bangkingdao.trplusspwitadmin(my_tr);
		bangkingdao.trtrwitupbaladmin(my_tr);
		
		bangkingdao.trplusdep(your_tr.getAt_set_mony());
		bangkingdao.trplusdeptr(your_tr);
		bangkingdao.trplusspdep(your_tr);
		bangkingdao.trtrdepupbal(your_tr);
		
		loanDao.loanstart(vo.getLc_num());
		loanDao.loanrepaystart(vo);
	}
	
	public void repayloan(TransferDTO my_tr,TransferDTO your_tr,LoanRepayVO vo,LoanRepayLogVO logVO) {
		bangkingdao.trpluswit(my_tr.getAt_set_mony());
		bangkingdao.trpluswittr(my_tr);
		bangkingdao.trplusspwit(my_tr);
		bangkingdao.trtrwitupbal(my_tr);

		
		bangkingdao.trplusdep(your_tr.getAt_set_mony());
		bangkingdao.trplusdeptr(your_tr);
		bangkingdao.trplusspdepadmin(your_tr);
		bangkingdao.trtrdepupbaladmin(your_tr);
		
		
		loanDao.repayloan(vo);
		loanDao.repaylog(logVO);
		
		
		//¥Î√‚¿‹æ◊
				int after = loanDao.balance(vo.getLc_num());
				if(after <= 0 ) {
					loanDao.loanend(vo.getLc_num());
				}
	}
	

}
