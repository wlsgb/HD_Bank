package dank.mvc.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepositDaosy {

	
	@Autowired
	private SqlSessionTemplate ss;
	
	public int checkac(int ac_num) {
		System.out.println("checkac");
		return ss.selectOne("depositsy.checkac", ac_num);
	}
	public void plusdep(int dep_money) {
		System.out.println("plusdep");
		ss.insert("depositsy.plusdep", dep_money);
	}
	public void plussp(Map<String, String> paramapsp ) {
		System.out.println("plussp");
		ss.insert("depositsy.plussp", paramapsp );
	}
	public void depupbalance(Map<String, Integer> paramapbal) {
		System.out.println("depupbalance");
		ss.update("depositsy.depupbalance", paramapbal);
	}
	
}
