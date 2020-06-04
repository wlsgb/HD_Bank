package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.LoanProductVO;

@Repository
public class LoanDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<LoanProductVO> getLoanProductList(){
		return ss.selectList("loan.product");
	}
}
