package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.Account_ClientVO;
import dank.mvc.vo.deposit.Installment_savingVO;
import dank.mvc.vo.deposit.SavingVO;
import dank.mvc.vo.deposit.Shared_savingVO;

@Repository
public class DepositDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	// 비밀번호 체크
	public int pwdChk(String acNum) {
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
	//계좌번호로 계좌의 존재 확인
	public boolean existAc(String ac_num){
		int exist = ss.selectOne("deposit.existAc",ac_num);
		if(exist>0) {
			return true; //계좌가 있으면 true
		}else{
			return false; //계좌가 없으면 false
		}
	}
	//계좌 번호로 회원 조회
	public MemberVO getMember(String ac_num){
		return ss.selectOne("deposit.numToName",ac_num);
	}
	//계좌 생성
	public void addAccount(AccountVO accountVO) {
		ss.insert("deposit.addAccount",accountVO);
	}

	
	//계좌 생성
	public void addAcClient(Account_ClientVO clientVO) {
		ss.insert("deposit.addAcClient",clientVO);
	}
	//계좌 상세조회
	public AccountVO getAcdetail(int ac_code){
		return ss.selectOne("bangking.acdetail",ac_code);
	}
	//계좌 삭제
	public void delAccount(int ac_code) {
		ss.delete("deposit.delAccount",ac_code);
	}

}
