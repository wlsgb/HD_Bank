package dank.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberVO;

@Repository
public class MyinfoDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public String getemail(MemberVO vo) {
		return ss.selectOne("myinfo.getemail", vo);
	}
}
