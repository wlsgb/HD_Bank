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
	
	public MemberVO numToEmailName(int num) {
		return ss.selectOne("member.serNameEmail", num);
	}
	
	public MemberVO memLogin(UserVO user) {
		System.out.println(user.getMem_email());
		System.out.println(user.getMem_pwd());
		return ss.selectOne("member.memlogin", user);
	}

}

