
package main.java.dank.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.PageVO;
import main.java.dank.vo.QnaVO;

@Repository
public class QnaDao {

	@Autowired
	private SqlSessionTemplate ss;

	public int memberAdd(QnaVO vo) {
		// �Է�ó���Ǹ�1, �����ϸ� 0�� ��ȯ�Ѵ�.
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
	public List<QnaVO> getSearchList(PageVO svo){ // nowpage������ ������ �� start , end
		return ss.selectList("qna.searchlist",svo);
	}

}
