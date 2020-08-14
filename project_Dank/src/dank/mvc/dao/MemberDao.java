package dank.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberLogVO;
import dank.mvc.vo.MemberVO;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate ss;

	public String pwdChk(int num) {
		return ss.selectOne("member.pwdChk", num);
	}
	
	public String serPhone(int num) {
		return ss.selectOne("member.serPhoneNum", num);
	}
	
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
	
	public MemberVO memLogin(MemberVO user) {
		return ss.selectOne("member.memlogin", user);
	}
	
	public MemberVO addMemLog(MemberLogVO vo) {
		return ss.selectOne("member.memberLog", vo);
	}

	public MemberVO getMem_code(String your_email) {
		// TODO Auto-generated method stub
		return ss.selectOne("member.getMem_code", your_email);
	}

}

