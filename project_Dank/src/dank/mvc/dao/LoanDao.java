package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanProductVO;

@Repository
public class LoanDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<LoanProductVO> getLoanProductList(){
		return ss.selectList("loan.product");
	}
	
	public LoanProductVO getProductInfo(int lp_num) {
		return ss.selectOne("loan.productinfo", lp_num);
	}
	
	public void insertLoanCheck(int lp_num) {
		ss.insert("loan.check", lp_num);
	}
	public void insertLoanApllication(LoanApplicationVO avo) {
		ss.insert("loan.application", avo);
	}
	public List<LoanCheckVO> checkdetailList() {
		return ss.selectList("loan.checkdetaillist");
	}
	
	public LoanCheckVO checkdetail(int lc_num) {
		return ss.selectOne("loan.checkdetail",lc_num);
	}
	
	public void fileupload(LoanFileVO vo) {
		ss.insert("loan.fileupload", vo);
	}
	public void stateupdate(int lc_num) {
		ss.update("loan.stateupdate",lc_num);
	}
}
