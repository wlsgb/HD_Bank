package main.java.dank.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.security.Security_CardVO;
import main.java.dank.vo.security.Security_Card_RegVO;



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
	
	// vo�� ���� �ְ� ������ ���̺� ���� �־��ش�.
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
