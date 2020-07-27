package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.FilenameVO;
import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanProductVO;
import dank.mvc.vo.LoanRepayLogVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.deposit.AccountVO;


@Repository
public class LoanDao {
	@Autowired
	private SqlSessionTemplate ss;
	//최호현
	//대출상품정보
	public List<LoanProductVO> getLoanProductList(){
		return ss.selectList("loan.product");
	}
	//대출상품디테일
	public LoanProductVO getProductInfo(int lp_num) {
		return ss.selectOne("loan.productinfo", lp_num);
	}
	//대출신청(대출정보입력)
	public void insertLoanCheck(LoanCheckVO vo) {
		ss.insert("loan.check", vo);
	}
	//대출신청(대출신청정보입력)
	public void insertLoanApllication(LoanApplicationVO avo) {
		ss.insert("loan.application", avo);
	}
	//신청대출 리스트
	public List<LoanCheckVO> checkdetailList(int mem_code) {
		return ss.selectList("loan.checkdetaillist",mem_code);
	}
	//신청대출 디테일
	public LoanCheckVO checkdetail(LoanCheckVO vo) {
		return ss.selectOne("loan.checkdetail",vo);
	}
	//서류제출
	public void fileupload(LoanFileVO vo) {
		ss.insert("loan.fileupload", vo);
	}
	//서류 보완 및 재 제출
	public void refileupload(LoanFileVO vo) {
		ss.update("loan.refileupload", vo);
	}
	//대출상태 변경
	public void stateupdate(int lc_num) {
		ss.update("loan.stateupdate",lc_num);
	}
	//서류 제출을 위한 홈
	public LoanFileVO fileuploadhome(int mem_code) {
		return ss.selectOne("loan.fileuploadhome",mem_code);
	}
	//제출 서류 확인
	public LoanFileVO filedetail(int lc_num) {
		return ss.selectOne("loan.filedetail",lc_num);
	}
	//대출 실행(대출 상태 변경)
	public void loanstart(int lc_num) {
		ss.update("loan.loanstart", lc_num);
	}
	//대출 실행(대출 상환 정보 입력)
	public void loanrepaystart(LoanRepayVO vo) {
		ss.insert("loan.loanrepay", vo);
	}
	//대출 상환 위한 예금계좌 가져오기
	public List<AccountVO> repayaccount(int mem_code) {
		return ss.selectList("loan.selectaccount",mem_code);
	}
	//대출 상환하기
	public void repayloan(LoanRepayVO vo) {
		ss.update("loan.repayloan",vo);
	}  
	//대출 상환  로그
	public void repaylog(LoanRepayLogVO vo) {
		ss.insert("loan.repaylog", vo);
	}
	public int balance(int lc_num) {
		return ss.selectOne("loan.balance",lc_num);
	}
	public void loanend(int lc_num) {
		ss.update("loan.end",lc_num);
		
	}
	
	public List<FilenameVO> filelist(){
		return ss.selectList("loan.filename");
	}

}
