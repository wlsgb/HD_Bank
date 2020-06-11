package dank.mvc.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WithdrawDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	public int checkac(int ac_num) {
		System.out.println("checkac");
		return ss.selectOne("withdraw.checkac", ac_num);
	}
	
	public int checkbal(Map<String, Integer> paramckbal) {
		System.out.println("checkbalance");
		return ss.selectOne("withdraw.checkbalance", paramckbal);
	}
	
	public void pluswit(int wit_money) {
		System.out.println("pluswit");
		ss.insert("withdraw.pluswit", wit_money);
	}
	public void plussp(Map<String, String> paramapsp ) {
		System.out.println("plussp");
		ss.insert("withdraw.plussp", paramapsp );
	}
	public void witupbalance(Map<String, Integer> paramapbal) {
		System.out.println("witupbalance");
		ss.update("withdraw.witupbalance", paramapbal);
	}
}
