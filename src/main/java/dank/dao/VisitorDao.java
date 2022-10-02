package main.java.dank.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.Curr_VisitorVO;

@Repository
public class VisitorDao {

	@Autowired
	private SqlSessionTemplate ss;

	public void addvisitor(Curr_VisitorVO vo) {
		ss.insert("visitor.add", vo);
	}
}
