package main.java.dank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.dank.dao.SecurityDao;
import main.java.dank.vo.security.Security_CardVO;
import main.java.dank.vo.security.Security_Card_RegVO;


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
