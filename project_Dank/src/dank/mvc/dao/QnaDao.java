
package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.PageVO;
import dank.mvc.vo.QnaVO;

@Repository
public class QnaDao {

	@Autowired
	private SqlSessionTemplate ss;

	public int memberAdd(QnaVO vo) {
		// 입력처리되면1, 실패하면 0을 반환한다.
		return ss.insert("qna.add", vo);
	}

	public String nameChk(String email) {
		return ss.selectOne("qna.namechk", email);
	}

	public List<QnaVO> getList(PageVO pvo) {
		return ss.selectList("qna.list", pvo);
	}

	public List<QnaVO> getSeachList(PageVO pvo) {
		return ss.selectList("qna.searchlist", pvo);
	}
	
	public int getTotalCount(PageVO vo) {
		return ss.selectOne("qna.totalCount", vo);
	}
	public List<QnaVO> getSearchList(PageVO svo){ // nowpage등으로 연산이 된 start , end
		return ss.selectList("qna.searchlist",svo);
	}

}
