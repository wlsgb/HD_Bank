package dank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.LoanDao;
import dank.mvc.vo.LoanApplicationVO;


@Service
@Transactional
public class LoanService {
	@Autowired
	private LoanDao loanDao;
	
	public void addloanaplication(LoanApplicationVO avo,int lp_num) {
		loanDao.insertLoanCheck(lp_num);
		loanDao.insertLoanApllication(avo);
	}
	
}
