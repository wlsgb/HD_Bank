
package main.java.dank.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.Question_princhk_VO;

@Repository
public class Question_princhk_Dao {

	@Autowired
	private SqlSessionTemplate ss;
	
	
	
	public int questionAdd(Question_princhk_VO qvo) {
		// �Է�ó���Ǹ�1, �����ϸ� 0�� ��ȯ�Ѵ�.
		return ss.insert("question.add", qvo);
	}

	public List<Question_princhk_VO> myQList(Question_princhk_VO qvo){
		return ss.selectList("question.myqlist", qvo);
	}

}
