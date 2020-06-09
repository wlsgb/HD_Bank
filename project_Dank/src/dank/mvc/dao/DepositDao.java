package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.deposit.AccountVO;



@Repository
public class DepositDao {
	@Autowired
	private SqlSessionTemplate ss;
	
//	public SavingVO getSavingQuaDetail(int sav_code) {
//		return ss.selectOne("deposit.savingDetail",sav_code);
//	}
	
	public List<AccountVO> getaclist(int mem_code){
		return ss.selectList("deposit.acinquery", mem_code);
	}
}
