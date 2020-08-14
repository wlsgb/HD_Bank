package dank.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.deposit.TransferDTO;
import dank.mvc.vo.deposit.AccountHistoryVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.At_applicationVO;
import dank.mvc.vo.deposit.Sav_process_forModalVO;

@Repository
public class BangkingDao {
	@Autowired
	private SqlSessionTemplate ss;
	//계좌조회를 처음 누를때 세션의 멤코드를 이용하여 가진 계좌 전체 출력
	public List<AccountVO> getaclist(int mem_code){
		return ss.selectList("bangking.acinquery", mem_code);
	}
	
	// 계좌번호를 넣으면 멤버 번호를 가져온다.
	public int acnumToMemcode(String ac_num) {
		return ss.selectOne("bangking.actomemnum",ac_num);
	}
	
	///////////////////////////////////////////////////////////입금시작@
	public int depcheckac(String ac_num) {
		return ss.selectOne("bangking.depcheckac", ac_num);
	}
	public void depplusdep(String dep_money) {
		ss.insert("bangking.depplusdep", dep_money);
	}
	public void depplussp(Map<String, String> paramapsp ) {
		ss.insert("bangking.depplussp", paramapsp );
	}
	public void depdepupbalance(Map<String, String> paramapbal) {
		ss.update("bangking.depdepupbalance", paramapbal);
	}
	///////////////////////////////////////////////////////////입금종료/@
	
	///////////////////////////////////////////////////////////출금시작@
	public int witcheckac(String ac_num) {
		return ss.selectOne("bangking.witcheckac", ac_num);
	}
	
	public String witcheckbal(Map<String, String> paramckbal) {
		return ss.selectOne("bangking.witcheckbalance", paramckbal);
	}
	
	public void witpluswit(String wit_money) {
		ss.insert("bangking.witpluswit", wit_money);
	}
	public void witplussp(Map<String, String> paramapsp ) {
		ss.insert("bangking.witplussp", paramapsp );
	}
	public void witwitupbalance(Map<String, String> paramapbal) {
		ss.update("bangking.witwitupbalance", paramapbal);
	}
	///////////////////////////////////////////////////////////출금종료/@
	///////////////////////////////////////////////////////////계좌이체시작@
	public int trtrAcChk(String ac_num) {
		return ss.selectOne("bangking.tracchk", ac_num);
	}
	public String trbalChk(TransferDTO my_tr) {
		return ss.selectOne("bangking.trbalchk", my_tr);
	}
	
	
	public void trpluswit(String wit_money) {
		ss.insert("bangking.trpluswit", wit_money);
	}
	public void trpluswittr(TransferDTO my_tr) {
		ss.insert("bangking.trpluswittr", my_tr);
	}
	public void trplusspwit(TransferDTO my_tr) {
		ss.insert("bangking.trplusspwit", my_tr);
	}
	public void trtrwitupbal(TransferDTO my_tr) {
		ss.update("bangking.trtrwitupbal", my_tr);
	}
	
	
	public void trplusdep(String dep_money) {
		ss.insert("bangking.trplusdep", dep_money);
	}
	public void trplusdeptr(TransferDTO your_tr) {
		ss.insert("bangking.trplusdeptr", your_tr);
	}
	public void trplusspdep(TransferDTO your_tr) {
		ss.insert("bangking.trplusspdep", your_tr);
	}
	public void trtrdepupbal(TransferDTO your_tr) {
		ss.update("bangking.trtrdepupbal", your_tr);
	}
	
	//어드민계좌 거래시
	public String trbalChkadmin(TransferDTO my_tr) {
		return ss.selectOne("bangking.trbalchkadmin", my_tr);
	}
	public void trplusspwitadmin(TransferDTO my_tr) {
		ss.insert("bangking.trplusspwitadmin", my_tr);
	}
	public void trtrwitupbaladmin(TransferDTO my_tr) {
		ss.update("bangking.trtrwitupbaladmin", my_tr);
	}
	
	public void trplusspdepadmin(TransferDTO your_tr) {
		ss.insert("bangking.trplusspdepadmin", your_tr);
	}
	public void trtrdepupbaladmin(TransferDTO your_tr) {
		ss.update("bangking.trtrdepupbaladmin", your_tr);
	}
	///어드민계좌 거래시 종료
	
	///////////////////////////////////////////////////////////계좌이체종료/@
	
	///////////////////////////////////////////////////////////거래내역조회시작@
	public List<AccountHistoryVO> gethistory(Map<String, String> historymap){
		return ss.selectList("bangking.achistory", historymap);
	}
	public List<AccountHistoryVO> gethistory_slct(Map<String, String> historymap){
		return ss.selectList("bangking.achistory_slct", historymap);
	}
	public int gettotalcnt(Map<String, String> historymap) {
		return ss.selectOne("bangking.totalcnt", historymap);
	}
	//계좌이체할때 레스트컨트롤러에서 값받아옴
	public List<Map<String, String>> getmemcodewhentr(String ac_num) {
		return ss.selectList("bangking.getmemcodewhentr", ac_num);
	}
	public List<String> getmyaclistwhentr(Map<String, String> getmyaclistwhentr) {
		return ss.selectList("bangking.getmyaclistwhentr", getmyaclistwhentr);
	} 
	public String getmybalwhentr(Map<String, String> getmybalwhentr) {
		return ss.selectOne("bangking.getmybalwhentr", getmybalwhentr);
	}
	
	
	//모달을 거래구분위해서 코드값만 가져옴
	public List<Sav_process_forModalVO> classifiedmodal(String sp_code){
		return ss.selectList("bangking.classification", sp_code);
	}
	public List<Sav_process_forModalVO> modal_tr(String sp_code){
		return ss.selectList("bangking.modal_tr", sp_code);
	}
	public List<Sav_process_forModalVO> modal_dep(String sp_code){
		return ss.selectList("bangking.modal_dep", sp_code);
	}
	public List<Sav_process_forModalVO> modal_wit(String sp_code){
		return ss.selectList("bangking.modal_wit", sp_code);
	}
	///////////////////////////////////////////////////////////거래내역조회종료/@
	///////////////////////////////////////////////////////////자동이체시작@
	public void insertatapply(At_applicationVO atapplyvo) {
		ss.insert("bangking.atapply", atapplyvo);
	}
	public List<At_applicationVO> atloadval() {
		return ss.selectList("bangking.atloadval");
	}
	public void afterchkup(String ata_code) {
		ss.update("bangking.afterchkup", ata_code);
	}
	public List<Map<String, String>> atlist(Map<String, String> atlistparam){
		return ss.selectList("bangking.atlist", atlistparam);
	}
	public void ifnomoneywhenat(String ata_code) {
		ss.update("bangking.ifnomoneywhenat",  ata_code);
	}
	public void atreset(Map<String, String> atresetparam) {
		ss.update("bangking.atreset", atresetparam);
	}
	public void atdelete(String ata_code) {
		ss.delete("bangking.atdelete", ata_code);
	}
	///////////////////////////////////////////////////////////자동이체종료/@
	
}
