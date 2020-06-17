
package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.PageVO;
import dank.mvc.vo.QnaVO;
import dank.mvc.vo.Question_princhk_VO;

@Repository
public class Question_princhk_Dao {

	@Autowired
	private SqlSessionTemplate ss;
	
	public int questionAdd(Question_princhk_VO qvo) {
		// 입력처리되면1, 실패하면 0을 반환한다.
		return ss.insert("question.add", qvo);
	}

	

}
