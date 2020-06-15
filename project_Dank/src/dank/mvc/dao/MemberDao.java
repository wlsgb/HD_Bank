package dank.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberVO;
import dank.mvc.vo.UserVO;



@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate ss;

	public String nameChk(String email) {
		return ss.selectOne("member.namechk", email);
	}
	
	public int idchk(String mem_email) {
		return ss.selectOne("member.idchk",mem_email);
	}
	
	public MemberVO numToEmailName(int num) {
		return ss.selectOne("member.serNameEmail", num);
	}
	
	public String forBirth(int num) {
		return ss.selectOne("member.forBirth", num);
	}
	public void memberjoin(MemberVO vo) {
		ss.insert("member.memberjoin",vo);
	}
	
	public MemberVO memLogin(UserVO user) {
		return ss.selectOne("member.memlogin", user);
	}

}

