package main.java.dank.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.dank.dao.BangkingDao;
import main.java.dank.dao.HDPayDao;
import main.java.dank.dao.MemberDao;
import main.java.dank.service.BangkingService;
import main.java.dank.service.DepositService;
import main.java.dank.vo.HDCardVO;
import main.java.dank.vo.MemberVO;
import main.java.dank.vo.PaymentVO;
import main.java.dank.vo.deposit.AccountHistoryVO;
import main.java.dank.vo.deposit.AccountVO;

@RestController
public class HDPayController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private HDPayDao payDao;
	@Autowired
	private BangkingDao bangkingdao;
	@Autowired
	private BangkingService bangkingservice;
	@Autowired
	private DepositService depositService;
	
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
	
	//ī�� ����
	@RequestMapping(value = "/addCard" , produces="text/plain;charset=UTF-8")
	public void hdpayLogin(String card_type, int mem_code, int ac_code) throws JsonProcessingException {
		
		HDCardVO card = new HDCardVO();
		card.setCard_type(card_type);
		card.setMem_code(mem_code);
		card.setAc_code(ac_code);
		
		payDao.addCard(card);
		
    }
	
	//���� ��ȸ
	@RequestMapping(value = "/allListAc" , produces="text/plain;charset=UTF-8")
	public String allListAc(int mem_code, String ac_num) {
		
		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", ac_num);
		historymap.put("mem_code", String.valueOf(mem_code));

		int total = bangkingdao.gettotalcnt(historymap);
		List<AccountHistoryVO> history = bangkingdao.getAllHistory(historymap);
		
		for(AccountHistoryVO e: history) {
			System.out.println(e.getSp_code());
			System.out.println(e.getName());
		}
		
		if(history != null) {
			String historyHistory = null;
			try {
				historyHistory = new ObjectMapper().writeValueAsString(history);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return historyHistory;
		}else {
			return null;
		}
	}
	
	//���� ��ȸ
		@RequestMapping(value = "/listAc" , produces="text/plain;charset=UTF-8")
		public String detailListAc(int mem_code) {
			
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
	
	//ī�� ����Ʈ
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
	
	//ī���ȣ,�ܾ� ��ȸ
	@RequestMapping(value = "/cardDetail" , produces="text/plain;charset=UTF-8")
	public String cardDetail(String card_type) {
		
		String decodedstr = null;
		
		try {
			decodedstr = URLDecoder.decode(card_type,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println("card_type : "+card_type);
		System.out.println("decodedstr : " + decodedstr);
		
		Map<String, String> cardDetail= payDao.cardDetail(decodedstr);
		
		if(cardDetail != null) {
			String cardInfo = null;
			try {
				cardInfo = new ObjectMapper().writeValueAsString(cardDetail);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
            return cardInfo;
		}else {
            return null;
		}
	}
	
	//���� ���
	@RequestMapping(value = "/payment" , produces="text/plain;charset=UTF-8")
	public void pay(PaymentVO payvo) {
		
//		decodedstr = URLDecoder.decode(card_type,"UTF-8");
		
		Map<String, String> map = payDao.selectCard(payvo.getCard_num());
		String ac_num = map.get("AC_NUM");
		System.out.println("ac_num : " + ac_num);
		
		int mem_code = Integer.parseInt(String.valueOf(map.get("MEM_CODE")));
		System.out.println("mem_code : " + mem_code);
		
		String scoreData = "";
		String pay_receiptData = "";
		
		try {
			scoreData = URLDecoder.decode(payvo.getScore(),"UTF-8");
			pay_receiptData = URLDecoder.decode(payvo.getPay_receipt(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String msg = scoreData+"-"+pay_receiptData;
		int money = payvo.getPay_money();
		

		
		if (bangkingdao.witcheckac(ac_num) >= 1) {
			System.out.println("���� ���");
			
			Map<String, String> paramckbal = new HashMap<String, String>();
			paramckbal.put("ac_num", ac_num);
			paramckbal.put("mem_code", String.valueOf(mem_code));
			if (Long.parseLong(bangkingdao.witcheckbal(paramckbal)) >= money) {
				Map<String, String> paramapsp = new HashMap<String, String>();
				paramapsp.put("ac_num", ac_num);
				paramapsp.put("mem_code", String.valueOf(mem_code));
				paramapsp.put("sp_name", msg);
				Map<String, String> paramapbal = new HashMap<String, String>();
				paramapbal.put("ac_num", ac_num);
				paramapbal.put("mem_code", String.valueOf(mem_code));
				paramapbal.put("wit_money", String.valueOf(money));
				
				System.out.println("����:"+String.valueOf(money)+","+ paramapsp+","+ paramapbal+","+ payvo.getCard_num());
				depositService.payment(String.valueOf(money), paramapsp, paramapbal, payvo);
			}

		}

	}
}
