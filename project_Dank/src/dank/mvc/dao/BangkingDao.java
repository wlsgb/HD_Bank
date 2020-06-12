package dank.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.deposit.AccountHistoryVO;
import dank.mvc.vo.deposit.AccountVO;

@Repository
public class BangkingDao {
	@Autowired
	private SqlSessionTemplate ss;
	//계좌조회를 처음 누를때 세션의 멤코드를 이용하여 가진 계좌 전체 출력
	public List<AccountVO> getaclist(int mem_code){
		return ss.selectList("bangking.acinquery", mem_code);
	}
	///////////////////////////////////////////////////////////입금시작@
	public int depcheckac(int ac_num) {
		System.out.println("checkac");
		return ss.selectOne("bangking.depcheckac", ac_num);
	}
	public void depplusdep(int dep_money) {
		System.out.println("plusdep");
		ss.insert("bangking.depplusdep", dep_money);
	}
	public void depplussp(Map<String, String> paramapsp ) {
		System.out.println("plussp");
		ss.insert("bangking.depplussp", paramapsp );
	}
	public void depdepupbalance(Map<String, Integer> paramapbal) {
		System.out.println("depupbalance");
		ss.update("bangking.depdepupbalance", paramapbal);
	}
	///////////////////////////////////////////////////////////입금종료/@
	
	///////////////////////////////////////////////////////////출금시작@
	public int witcheckac(int ac_num) {
		System.out.println("checkac");
		return ss.selectOne("bangking.witcheckac", ac_num);
	}
	
	public int witcheckbal(Map<String, Integer> paramckbal) {
		System.out.println("checkbalance");
		return ss.selectOne("bangking.witcheckbalance", paramckbal);
	}
	
	public void witpluswit(int wit_money) {
		System.out.println("pluswit");
		ss.insert("bangking.witpluswit", wit_money);
	}
	public void witplussp(Map<String, String> paramapsp ) {
		System.out.println("plussp");
		ss.insert("bangking.witplussp", paramapsp );
	}
	public void witwitupbalance(Map<String, Integer> paramapbal) {
		System.out.println("witupbalance");
		ss.update("bangking.witwitupbalance", paramapbal);
	}
	///////////////////////////////////////////////////////////출금종료/@
	///////////////////////////////////////////////////////////계좌이체시작@
	public int trtrAcChk(int ac_num) {
		return ss.selectOne("bangking.tracchk", ac_num);
	}
	public int trbalChk(Map<String, Integer> mapmy) {
		return ss.selectOne("bangking.trbalchk", mapmy);
	}
	
	
	public void trpluswit(int wit_money) {
		ss.insert("bangking.trpluswit", wit_money);
	}
	public void trpluswittr(Map<String, Integer> mapmy) {
		ss.insert("bangking.trpluswittr", mapmy);
	}
	public void trplusspwit(Map<String, String> mapmysp) {
		ss.insert("bangking.trplusspwit", mapmysp);
	}
	public void trtrwitupbal(Map<String, Integer> mapmy) {
		ss.update("bangking.trtrwitupbal", mapmy);
	}
	
	
	public void trplusdep(int dep_money) {
		ss.insert("bangking.trplusdep", dep_money);
	}
	public void trplusdeptr(Map<String, Integer> mapyour) {
		ss.insert("bangking.trplusdeptr", mapyour);
	}
	public void trplusspdep(Map<String, String> mapyoursp) {
		ss.insert("bangking.trplusspdep", mapyoursp);
	}
	public void trtrdepupbal(Map<String, Integer> mapyour) {
		ss.update("bangking.trtrdepupbal", mapyour);
	}
	///////////////////////////////////////////////////////////계좌이체종료/@
	
	///////////////////////////////////////////////////////////거래내역조회시작@
	public List<AccountHistoryVO> gethistory(Map<String, String> historymap){
		return ss.selectList("bangking.achistory", historymap);
	}
	public int gettotalcnt(Map<String, String> historymap) {
		return ss.selectOne("bangking.totalcnt", historymap);
	}
	public int getmemcodewhentr(int acnum) {
		return ss.selectOne("bangking.getmemcodewhentr", acnum);
	}
	public List<Integer> getmyaclistwhentr(int mem_code) {
		return ss.selectList("bangking.getmyaclistwhentr", mem_code);
	}
	///////////////////////////////////////////////////////////거래내역조회종료/@
	
}
