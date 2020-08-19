package dank.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.HDPayDao;
import dank.mvc.dao.MemberDao;
import dank.mvc.vo.HDCardVO;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.deposit.AccountVO;

@RestController
public class HDPayController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private HDPayDao payDao;
	@Autowired
	private BangkingDao bangkingdao;
	
	//hdpay login
	@RequestMapping(value = "/hdpaylogin" , produces="text/plain;charset=UTF-8")
	public String hdpayLogin(MemberVO member) throws JsonProcessingException {
		
		MemberVO user = memberDao.memLogin(member);
		
		if(user != null) {
			String userInfo = new ObjectMapper().writeValueAsString(user);
            return userInfo;
		}else {
            return null;
		}
		
    }
	
	//카드 생성
	@RequestMapping(value = "/addCard" , produces="text/plain;charset=UTF-8")
	public void hdpayLogin(String card_type, int mem_code, int ac_code) throws JsonProcessingException {
		
		HDCardVO card = new HDCardVO();
		card.setCard_type(card_type);
		card.setMem_code(mem_code);
		card.setAc_code(ac_code);
		
		payDao.addCard(card);
		
    }
	
	//계좌 조회
	@RequestMapping(value = "/listAc" , produces="text/plain;charset=UTF-8")
	public String listAc(int mem_code) {
		List<AccountVO> aclist = bangkingdao.getaclist(mem_code);
		
		if(aclist != null) {
			String acInfo = null;
			try {
				acInfo = new ObjectMapper().writeValueAsString(aclist);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return acInfo;
		}else {
            return null;
		}
	}
	
	//카드 리스트
	@RequestMapping(value = "/listCardType" , produces="text/plain;charset=UTF-8")
	public String listCardType(int mem_code) {
		List<String> cardlist = payDao.listCardType(mem_code);
		
		if(cardlist != null) {
			String cardInfo = null;
			try {
				cardInfo = new ObjectMapper().writeValueAsString(cardlist);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return cardInfo;
		}else {
            return null;
		}
	}
	
	//카드번호,잔액 조회
	
}
