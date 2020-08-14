package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.Account_ClientVO;
import dank.mvc.vo.deposit.Shared_savingVO;

@Repository
public class ShareDao {
	@Autowired
	private SqlSessionTemplate ss;

	public List<Shared_savingVO> getSharelist() {
		// TODO Auto-generated method stub
		return ss.selectList("shvo.sharelist");
	}

	public Shared_savingVO getShasQuaDetail(int shas_code) {
		return ss.selectOne("shvo.shasDetail", shas_code);
	}

	public void addShareAccount(AccountVO accountVO) {
		ss.insert("shvo.addShareAccount", accountVO);
	}

	public void addAcClient(Account_ClientVO clientVO) {
		ss.insert("shvo.addAcClient", clientVO);

	}

	public List<AccountVO> getAdditionalList(String mem_email) {
		// TODO Auto-generated method stub
		return ss.selectList("shvo.getAdditionalList",mem_email);
	}

}
