package dank.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.Security_CardVO;


@Repository
public class SecurityDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	public void cardCreate(Security_CardVO vo) {
		ss.insert("security.cardCreat",vo);
	}
	
	public int priCodeChk(Security_CardVO vo) {
		return ss.selectOne("security.priCodeChk", vo);
	}
}
