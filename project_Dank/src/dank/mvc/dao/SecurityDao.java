package dank.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.security.Security_CardVO;
import dank.mvc.vo.security.Security_Card_RegVO;



@Repository
public class SecurityDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	public void otpCreate(HashMap<String, Object> map) {
		ss.insert("security.otpReg", map);
	}
	
	public int otpCheck(int num) {
		return ss.selectOne("security.otpChk", num);
	}
	
	// vo에 값을 넣고 데이터 테이블에 값을 넣어준다.
	public void cardCreate(Security_CardVO vo) {
		ss.insert("security.cardCreat",vo);
	}
	
	public int priCodeChk(Security_CardVO vo) {
		return ss.selectOne("security.priCodeChk", vo);
	}
	
	public void securityCardReq(Security_Card_RegVO vo) {
		ss.insert("security.cardReg",vo);
	}
	
	public int scrNumChk(int num) {
		return ss.selectOne("security.scrNumChk", num);
	}
	
	public Security_Card_RegVO securityCardDetail(int num) {
		
		return ss.selectOne("security.secCardDetail", num);
	}
}
