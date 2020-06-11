package dank.mvc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.DepositDaosy;


@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class DepositServicesy {
	@Autowired
	private DepositDaosy depositdaosy;
	
	public void depositprocess(int money,Map<String, String> paramapsp,Map<String, Integer> paramapbal) {
		depositdaosy.plusdep(money);
		depositdaosy.plussp(paramapsp);
		depositdaosy.depupbalance(paramapbal);
	}

}
