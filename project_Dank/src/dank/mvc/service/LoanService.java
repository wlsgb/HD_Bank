package dank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public void addloanaplication(LoanApplicationVO avo,LoanCheckVO vo) {
		loanDao.insertLoanCheck(vo);
		loanDao.insertLoanApllication(avo);
	}
	
	public void fileupload(LoanFileVO vo) {
		loanDao.fileupload(vo);
		loanDao.stateupdate(vo.getLc_num());
	}
	
	public void startrepay(LoanRepayVO vo) {
		loanDao.loanstart(vo.getLc_num());
		loanDao.loanrepaystart(vo);
	}
	
}
