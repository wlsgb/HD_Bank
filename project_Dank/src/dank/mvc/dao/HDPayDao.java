package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.HDCardVO;

@Repository
public class HDPayDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	//카드 생성
	public void addCard(HDCardVO card) {
		ss.insert("hdpay.addCard",card);
	}
	
	//카드 삭제
	public void delCard(int card_num) {
		ss.delete("hdpay.delCard",card_num);
	}
	
	//카드종류리스트 조회
	public List<String> listCardType(int mem_code) {
		return ss.selectList("hdpay.cardType", mem_code);
		
	}
	
	//카드 디테일(카드번호, 잔액 조회)
	public HDCardVO cardDetail(String card_type) {
		return ss.selectOne("hdpay.cardNumBal", card_type);	
	}
}
