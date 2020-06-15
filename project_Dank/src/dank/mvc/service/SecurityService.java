package dank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.LoanDao;
import dank.mvc.dao.SecurityDao;
import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.security.Security_CardVO;
import dank.mvc.vo.security.Security_Card_RegVO;


@Service
@Transactional
public class SecurityService {
	@Autowired
	private SecurityDao securityDao;
	
	public void createSecurityCard(Security_CardVO security_CardVO,Security_Card_RegVO security_Card_RegVO) {
		securityDao.cardCreate(security_CardVO);
		security_Card_RegVO.setSc_code(security_CardVO.getSc_code());
		securityDao.securityCardReq(security_Card_RegVO);
	}
	
	
}
