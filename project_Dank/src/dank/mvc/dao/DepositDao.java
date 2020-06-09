package dank.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DepositDao {
	@Autowired
	private SqlSessionTemplate ss;
	
//	public SavingVO getSavingQuaDetail(int sav_code) {
//		return ss.selectOne("deposit.savingDetail",sav_code);
//	}
}
