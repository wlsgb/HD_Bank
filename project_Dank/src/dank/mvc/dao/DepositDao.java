package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import dank.mvc.vo.deposit.Installment_savingVO;
import dank.mvc.vo.deposit.SavingVO;

@Repository
public class DepositDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	// 비밀번호 체크
	public int pwdChk(int acNum) {
		return ss.selectOne("deposit.accountPwChk",acNum);
	}
	//특정 예금상품 조회
	public SavingVO getSavingQuaDetail(int sav_code) {
		return ss.selectOne("deposit.savingDetail",sav_code);
	}
	//특정 적금상품 조회
	public Installment_savingVO getInsQuaDetail(int ins_code) {
		return ss.selectOne("deposit.insDetail",ins_code);
	}
	//예금상품 리스트  조회
	public List<SavingVO> getSavlist(){
		return ss.selectList("deposit.savlist");
	}
	//적금상품 리스트 조회
	public List<Installment_savingVO> getInslist(){
		return ss.selectList("deposit.inslist");

	}
}
