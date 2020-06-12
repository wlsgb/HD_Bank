package dank.mvc.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class TransferDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	public int trAcChk(int ac_num) {
		return ss.selectOne("transfer.acchk", ac_num);
	}
	public int balChk(Map<String, Integer> mapmy) {
		return ss.selectOne("transfer.balchk", mapmy);
	}
	
	
	public void pluswit(int wit_money) {
		ss.insert("transfer.pluswit", wit_money);
	}
	public void pluswittr(Map<String, Integer> mapmy) {
		ss.insert("transfer.pluswittr", mapmy);
	}
	public void plusspwit(Map<String, String> mapmysp) {
		ss.insert("transfer.plusspwit", mapmysp);
	}
	public void trwitupbal(Map<String, Integer> mapmy) {
		ss.update("transfer.trwitupbal", mapmy);
	}
	
	
	public void plusdep(int dep_money) {
		ss.insert("transfer.plusdep", dep_money);
	}
	public void plusdeptr(Map<String, Integer> mapyour) {
		ss.insert("transfer.plusdeptr", mapyour);
	}
	public void plusspdep(Map<String, String> mapyoursp) {
		ss.insert("transfer.plusspdep", mapyoursp);
	}
	public void trdepupbal(Map<String, Integer> mapyour) {
		ss.update("transfer.trdepupbal", mapyour);
	}
}
