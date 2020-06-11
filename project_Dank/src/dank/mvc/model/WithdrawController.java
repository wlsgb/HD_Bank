package dank.mvc.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.WithdrawDao;

import dank.mvc.service.WithdrawService;

@Controller
public class WithdrawController {

	@Autowired
	private WithdrawService withdrawservice;
	
	@Autowired
	private WithdrawDao withdrawdao;
	
	@RequestMapping(value={ "/withdraw" })
	public ModelAndView executewithdraw(HttpSession session,int ac_num) {
		ModelAndView mav = new ModelAndView();
		System.out.println("******************출금실행댐,계좌번호는 ="+ac_num+",");
		
		int money =10000;
		
		System.out.println("존재유무"+withdrawdao.checkac(ac_num));
		
		if(withdrawdao.checkac(ac_num)>=1) {
			Map<String, Integer> paramckbal = new HashMap<String, Integer>();
			paramckbal.put("ac_num", ac_num);
			paramckbal.put("mem_code", Integer.parseInt(session.getAttribute("mem_code").toString()));
			if(withdrawdao.checkbal(paramckbal) >= money) {
				Map<String, String> paramapsp = new HashMap<String, String>();
				paramapsp.put("ac_num", String.valueOf(ac_num));
				paramapsp.put("mem_code", String.valueOf(session.getAttribute("mem_code")));
				paramapsp.put("sp_name", "출금테스트용");
				Map<String, Integer> paramapbal = new HashMap<String, Integer>();
				paramapbal.put("ac_num", ac_num);
				paramapbal.put("mem_code", Integer.parseInt(session.getAttribute("mem_code").toString()));
				paramapbal.put("wit_money",money);
				withdrawservice.withdrawprocess(money, paramapsp, paramapbal);
			}
			
			
			
		}
		
		
		
		mav.setViewName("redirect:inquire?mem_code="+session.getAttribute("mem_code"));
		return mav;
	}
}
