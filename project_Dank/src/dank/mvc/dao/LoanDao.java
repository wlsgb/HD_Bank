package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanProductVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.deposit.AccountVO;



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
	
	public void insertLoanCheck(LoanCheckVO vo) {
		ss.insert("loan.check", vo);
	}
	public void insertLoanApllication(LoanApplicationVO avo) {
		ss.insert("loan.application", avo);
	}
	public List<LoanCheckVO> checkdetailList(int mem_code) {
		return ss.selectList("loan.checkdetaillist",mem_code);
	}
	
	public LoanCheckVO checkdetail(LoanCheckVO vo) {
		return ss.selectOne("loan.checkdetail",vo);
	}
	
	public void fileupload(LoanFileVO vo) {
		ss.insert("loan.fileupload", vo);
	}
	public void refileupload(LoanFileVO vo) {
		ss.update("loan.refileupload", vo);
	}
	
	public void stateupdate(int lc_num) {
		ss.update("loan.stateupdate",lc_num);
	}
	public LoanFileVO fileuploadhome(int mem_code) {
		return ss.selectOne("loan.fileuploadhome",mem_code);
	}
	public LoanFileVO filedetail(int lc_num) {
		return ss.selectOne("loan.filedetail",lc_num);
	}
	public void loanstart(int lc_num) {
		ss.update("loan.loanstart", lc_num);
	}
	public void loanrepaystart(LoanRepayVO vo) {
		ss.insert("loan.loanrepay", vo);
	}
	public List<AccountVO> repayaccount(int mem_code) {
		return ss.selectList("loan.selectaccount",mem_code);
	}
}
