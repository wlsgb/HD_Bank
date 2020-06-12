package dank.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.deposit.AccountHistoryVO;

@Repository
public class DeposithitoryDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<AccountHistoryVO> gethistory(Map<String, String> historymap){
		return ss.selectList("deposithistory.achistory", historymap);
	}
	public int gettotalcnt(Map<String, String> historymap) {
		return ss.selectOne("deposithistory.totalcnt", historymap);
	}
}
