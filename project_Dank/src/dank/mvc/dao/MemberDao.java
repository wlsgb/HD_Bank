
package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberVO;


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


}
