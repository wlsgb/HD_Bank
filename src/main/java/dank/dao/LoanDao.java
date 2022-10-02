package main.java.dank.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.FilenameVO;
import main.java.dank.vo.LoanApplicationVO;
import main.java.dank.vo.LoanCheckVO;
import main.java.dank.vo.LoanFileVO;
import main.java.dank.vo.LoanProductVO;
import main.java.dank.vo.LoanRepayLogVO;
import main.java.dank.vo.LoanRepayVO;
import main.java.dank.vo.deposit.AccountVO;

@Repository
public class LoanDao {
	@Autowired
	private SqlSessionTemplate ss;

	//��ȣ��
	//�����ǰ����
	public List<LoanProductVO> getLoanProductList() {
		return ss.selectList("loan.product");
	}

	//�����ǰ������
	public LoanProductVO getProductInfo(int lp_num) {
		return ss.selectOne("loan.productinfo", lp_num);
	}

	//�����û(���������Է�)
	public void insertLoanCheck(LoanCheckVO vo) {
		ss.insert("loan.check", vo);
	}

	//�����û(�����û�����Է�)
	public void insertLoanApllication(LoanApplicationVO avo) {
		ss.insert("loan.application", avo);
	}

	//��û���� ����Ʈ
	public List<LoanCheckVO> checkdetailList(int mem_code) {
		return ss.selectList("loan.checkdetaillist", mem_code);
	}

	//��û���� ������
	public LoanCheckVO checkdetail(LoanCheckVO vo) {
		return ss.selectOne("loan.checkdetail", vo);
	}

	//������� ����
	public void stateupdate(int lc_num) {
		ss.update("loan.stateupdate", lc_num);
	}

	//���� ������ ���� Ȩ
	public LoanFileVO fileuploadhome(int mem_code) {
		return ss.selectOne("loan.fileuploadhome", mem_code);
	}

	//���� ����(���� ���� ����)
	public void loanstart(int lc_num) {
		ss.update("loan.loanstart", lc_num);
	}

	//���� ����(���� ��ȯ ���� �Է�)
	public void loanrepaystart(LoanRepayVO vo) {
		ss.insert("loan.loanrepay", vo);
	}

	//���� ��ȯ ���� ���ݰ��� ��������
	public List<AccountVO> repayaccount(int mem_code) {
		return ss.selectList("loan.selectaccount", mem_code);
	}

	//���� ��ȯ�ϱ�
	public void repayloan(LoanRepayVO vo) {
		ss.update("loan.repayloan", vo);
	}

	//���� ��ȯ  �α�
	public void repaylog(LoanRepayLogVO vo) {
		ss.insert("loan.repaylog", vo);
	}

	public int balance(int lc_num) {
		return ss.selectOne("loan.balance", lc_num);
	}

	public void loanend(int lc_num) {
		ss.update("loan.end", lc_num);

	}

	public List<FilenameVO> filelist() {
		return ss.selectList("loan.filename");
	}

	public void fileup(LoanFileVO vo) {
		ss.insert("loan.fileup", vo);
	}

	public List<LoanFileVO> filelist(int lc_num) {
		return ss.selectList("loan.checkfiledetail", lc_num);
	}

	public String checkstate(int lc_num) {
		return ss.selectOne("loan.checkstate", lc_num);
	}
}
