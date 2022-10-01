package main.java.dank.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.MemberVO;
import main.java.dank.vo.deposit.AccountVO;
import main.java.dank.vo.deposit.Account_ClientVO;
import main.java.dank.vo.deposit.Installment_savingVO;
import main.java.dank.vo.deposit.SavingVO;

@Repository
public class DepositDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	// ��й�ȣ üũ
	public int pwdChk(String acNum) {
		return ss.selectOne("deposit.accountPwChk",acNum);
	}
	//Ư�� ���ݻ�ǰ ��ȸ
	public SavingVO getSavingQuaDetail(int sav_code) {
		return ss.selectOne("deposit.savingDetail",sav_code);
	}
	//Ư�� ���ݻ�ǰ ��ȸ
	public Installment_savingVO getInsQuaDetail(int ins_code) {
		return ss.selectOne("deposit.insDetail",ins_code);
	}
	//���ݻ�ǰ ����Ʈ  ��ȸ
	public List<SavingVO> getSavlist(){
		return ss.selectList("deposit.savlist");
	}
	//���ݻ�ǰ ����Ʈ ��ȸ
	public List<Installment_savingVO> getInslist(){
		return ss.selectList("deposit.inslist");
	}
	//���¹�ȣ�� ������ ���� Ȯ��
	public boolean existAc(String ac_num){
		int exist = ss.selectOne("deposit.existAc",ac_num);
		if(exist>0) {
			return true; //���°� ������ true
		}else{
			return false; //���°� ������ false
		}
	}
	//���� ��ȣ�� ȸ�� ��ȸ
	public MemberVO getMember(String ac_num){
		return ss.selectOne("deposit.numToName",ac_num);
	}
	//���� ����
	public void addAccount(AccountVO accountVO) {
		ss.insert("deposit.addAccount",accountVO);
	}

	
	//���� ����
	public void addAcClient(Account_ClientVO clientVO) {
		ss.insert("deposit.addAcClient",clientVO);
	}
	//���� ����ȸ
	public AccountVO getAcdetail(int ac_code){
		return ss.selectOne("bangking.acdetail",ac_code);
	}
	//���� ����
	public void delAccount(int ac_code) {
		ss.delete("deposit.delAccount",ac_code);
	}
	
	//�ֽ�
	public boolean seleStock(Map<String,String> sotck_bool) {
		
		int stockBool = ss.selectOne("deposit.seleStock",sotck_bool);
		//System.out.println("seleStock Count:"+stockBool);
		
		if(stockBool > 0) {
			return false;
		}else {
			return true;
		}
	}

}
