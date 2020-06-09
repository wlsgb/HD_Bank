
package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate ss;

	public String nameChk(String email) {
		return ss.selectOne("member.namechk", email);
	}


}
