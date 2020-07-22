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
import dank.mvc.vo.LoanRepayVO;


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
	
	public void startrepay(LoanRepayVO vo,String trmoney,Map<String, String> mapmy,Map<String, String> mapmysp,
			Map<String, String> mapyour,Map<String, String> mapyoursp) {
		bangkingdao.trpluswit(trmoney);
		bangkingdao.trpluswittr(mapmy);
		bangkingdao.trplusspwitadmin(mapmysp);
		bangkingdao.trtrwitupbaladmin(mapmy);
		
		bangkingdao.trplusdep(trmoney);
		bangkingdao.trplusdeptr(mapyour);
		bangkingdao.trplusspdep(mapyoursp);
		bangkingdao.trtrdepupbal(mapyour);
		
		loanDao.loanstart(vo.getLc_num());
		loanDao.loanrepaystart(vo);
	}
	
	public void repayloan(String trmoney,Map<String, String> mapmy,Map<String, String> mapmysp,
			Map<String, String> mapyour,Map<String, String> mapyoursp,LoanRepayVO vo) {
		bangkingdao.trpluswit(trmoney);
		bangkingdao.trpluswittr(mapmy);
		bangkingdao.trplusspwit(mapmysp);
		bangkingdao.trtrwitupbal(mapmy);
		
		bangkingdao.trplusdep(trmoney);
		bangkingdao.trplusdeptr(mapyour);
		bangkingdao.trplusspdepadmin(mapyoursp);
		bangkingdao.trtrdepupbaladmin(mapyour);
		
		
		loanDao.repayloan(vo);
	}
	

}
