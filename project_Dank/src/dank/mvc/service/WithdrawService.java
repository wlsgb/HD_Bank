package dank.mvc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.WithdrawDao;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class WithdrawService {
	
	@Autowired
	private WithdrawDao withdrawdao;
	
	public void withdrawprocess(int money,Map<String, String> paramapsp,Map<String, Integer> paramapbal) {
		withdrawdao.pluswit(money);
		withdrawdao.plussp(paramapsp);
		withdrawdao.witupbalance(paramapbal);
	}

}
