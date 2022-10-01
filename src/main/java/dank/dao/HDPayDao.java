package main.java.dank.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.vo.HDCardVO;
import main.java.dank.vo.PaymentVO;

@Repository
public class HDPayDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	//ī�� ����
	public void addCard(HDCardVO card) {
		ss.insert("hdpay.addCard",card);
	}
	
	//ī�� ����
	public void delCard(int card_num) {
		ss.delete("hdpay.delCard",card_num);
	}
	
	//ī����������Ʈ ��ȸ
	public List<String> listCardType(int mem_code) {
		return ss.selectList("hdpay.cardType", mem_code);
		
	}
	
	//ī�� ������(ī���ȣ, �ܾ� ��ȸ)
	public Map<String,String> cardDetail(String card_type) {
		return ss.selectOne("hdpay.cardNumBal", card_type);	
	}
	
	//ī���ȣ�� ī�� ��ȸ
	public Map<String,String> selectCard(int card_num) {
		return ss.selectOne("hdpay.selectCard", card_num);	
	}
	
	//����
	public void pay(PaymentVO vo) {
		ss.selectOne("hdpay.pay", vo);	
	}
}
