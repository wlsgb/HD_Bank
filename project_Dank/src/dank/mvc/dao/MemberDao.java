package dank.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberVO;
import freemarker.core.ReturnInstruction.Return;
@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate ss;
	//ss 마이바티스 설정한게
	//입력처리
	public int memberAdd(MemberVO vo) {
		// 입력처리가 되면 1, 실패하면 0 반환한다.
		return ss.insert("member.add",vo);
	}
	
}
