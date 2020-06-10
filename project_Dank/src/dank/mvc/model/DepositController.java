package dank.mvc.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.DepositDao;
import dank.mvc.dao.DepositDaosy;
import dank.mvc.service.DepositServicesy;
import dank.mvc.vo.deposit.AccountVO;

import dank.mvc.vo.deposit.Installment_savingVO;
import dank.mvc.vo.deposit.Sav_processVO;
import dank.mvc.vo.deposit.SavingVO;


@Controller
public class DepositController {
	@Autowired
	private DepositDao depositDao;
	
	@Autowired
	private DepositDaosy depositDaosy;
	
	@Autowired
	private DepositServicesy depositservicesy;
	
	@RequestMapping(value = "/analysis")
	public String viewAnalysis() {
		return "deposit/analysis";
	}

	@RequestMapping(value = "/new")
	public String newPage(Model m) {
		List<SavingVO> savlist= depositDao.savinglist();
		m.addAttribute("savlist",savlist);
		return "deposit/new";
	}
	
	@RequestMapping(value = "/saving_new")
	public String saving_new(Model m, int sav_code) {
		SavingVO saving = depositDao.getSavingQuaDetail(sav_code);
		m.addAttribute("saving",saving);
		return "deposit/saving_new";
	}
	
	@RequestMapping(value = "/installment_new")
	public String installment_new(Model m, int ins_code) {
		Installment_savingVO ins = depositDao.getInsQuaDetail(ins_code);
		m.addAttribute("ins",ins);
		return "deposit/installment_new";
	}
	 
	
	@RequestMapping(value = "/share_new_req")
	public String share_new_req() {
		return "deposit/share_new_req";
	}

	@RequestMapping(value = "/share_new_res")
	public String share_new_res() {
		return "deposit/share_new_res";
	}

	@RequestMapping(value = "/share_new_insert")
	public String share_new_insert() {
		return "deposit/share_new_insert";
	}

	@RequestMapping(value = "/share_new_complete")
	public String share_new_complete() {
		return "deposit/share_new_complete";
	}

	@RequestMapping(value = "/share_new_check")
	public String share_new_check() {
		return "deposit/share_new_check";
	}

//	@RequestMapping(value = { "/inquire" })
//	public String inqurePage(
//			@RequestParam(value = "gonum", required = true, defaultValue = "0") String gonum
//			) {
//		return "deposit/deposite_inquire";
//	}
	@RequestMapping(value = { "/inquire" })
	public ModelAndView inquirePage(
			@RequestParam(value = "mem_code",defaultValue = "1") String mem_code
			,HttpSession session
			) {
		session.setAttribute("mem_code", mem_code);
		ModelAndView mav = new ModelAndView();
		
		
	System.out.println("계좌조회에서 있는 세션은="+session.getAttribute("mem_code"));
		
		
		
		List<AccountVO> aclist = depositDao.getaclist(Integer.parseInt(session.getAttribute("mem_code").toString()));
		for(AccountVO e :aclist) {
			
			System.out.println(e.getAc_num());
			System.out.println(e.getAc_balance());
			System.out.println(e.getSaving().getSav_name());
			System.out.println(e.getSaving().getShas_code());
			System.out.println(e.getIns().getIns_name());
			System.out.println(e.getIns().getShac_code());
			System.out.println("*******************");
			
			
			
		}
		mav.addObject("aclist",aclist);
		mav.setViewName("deposit/deposite_inquire");
		
		return mav;
	}
	
	@RequestMapping(value={ "/deposit" })
	public ModelAndView executedeposit(HttpSession session,int ac_num) {
		ModelAndView mav = new ModelAndView();
		System.out.println("******************입금실행댐,계좌번호는 ="+ac_num+",");
		
		int money =10000;
		
		System.out.println("존재유무"+depositDaosy.checkac(ac_num));
		
		if(depositDaosy.checkac(ac_num)<=1) {
		Map<String, String> paramapsp = new HashMap<String, String>();
		paramapsp.put("ac_num", String.valueOf(ac_num));
		paramapsp.put("sp_name", "입금테스트용");
		paramapsp.put("mem_code", session.getAttribute("mem_code").toString());
		Map<String, Integer> paramapbal = new HashMap<String, Integer>();
		paramapbal.put("ac_num", ac_num);
		paramapbal.put("dep_money",money);
		paramapbal.put("mem_code", Integer.parseInt(session.getAttribute("mem_code").toString()));
		depositservicesy.depositprocess(money, paramapsp, paramapbal);
		}
		
		
		
		mav.setViewName("redirect:inquire?mem_code="+session.getAttribute("mem_code"));
		return mav;
	}
	
	
	@RequestMapping(value={ "/withdraw" })
	public ModelAndView executewithdraw(HttpSession session,int ac_num) {
		ModelAndView mav = new ModelAndView();
		System.out.println("******************출금실행댐,계좌번호는 ="+ac_num+",");
		
		int money =10000;
		
		System.out.println("존재유무"+depositDaosy.checkac(ac_num));
		
		if(depositDaosy.checkac(ac_num)<=1) {
			Map<String, String> paramapsp = new HashMap<String, String>();
			paramapsp.put("mem_code", String.valueOf(session.getAttribute("mem_code")));
			paramapsp.put("sp_name", "출금테스트용");
			Map<String, Integer> paramapbal = new HashMap<String, Integer>();
			paramapbal.put("mem_code", Integer.parseInt(session.getAttribute("mem_code").toString()));
			paramapbal.put("dep_money",money);
			depositservicesy.depositprocess(money, paramapsp, paramapbal);
		}
		
		
		
		mav.setViewName("redirect:inquire?mem_code="+session.getAttribute("mem_code"));
		return mav;
	}
	
	@RequestMapping(value={ "/getsession" })
	public ModelAndView getsession(HttpServletRequest req,@RequestParam(value = "mem_code") String mem_code) {
		System.out.println("멤버코드는 : "+mem_code);
		HttpSession session =req.getSession();
		//session.invalidate();
		session.setAttribute("mem_code", mem_code);
		ModelAndView mav = new ModelAndView();
		System.out.println("세션넣기 성공");
		System.out.println("현ㅐ 세션 : "+session.getAttribute("mem_code"));
		mav.setViewName("redirect:inquire?mem_code="+session.getAttribute("mem_code"));
		return mav;
	}
	
	
	
	@RequestMapping(value = { "/inquire_detail" })
	public String inqure_detailPage() {
		return "deposit/deposite_inquire_detail";
	}

	@RequestMapping(value = { "/transfer" })
	public String transferPage() {
		return "deposit/deposite_transfer";
	}

	@RequestMapping(value = { "/transfer_auto" })
	public String transferautoPage() {
		return "deposit/deposite_transfer_auto";
	}

	@RequestMapping(value = { "/transfer_auto_apply" })
	public String transferautoapplyPage() {
		return "deposit/deposite_transfer_auto_apply";
	}

	@RequestMapping(value = { "/deposite_cancle" })
	public String depositecancle() {
		return "deposit/deposite_cancle";
	}

	@RequestMapping(value = { "/deposite_cancle_input_info" })
	public String depositecancleinputinfo() {
		return "deposit/deposite_cancle_input_info";
	}

	@RequestMapping(value = { "/deposite_cancle_check_Account" })
	public String depositecanclecheckshareAccount() {
		return "deposit/deposite_cancle_check_shareAccount";
	}

	@RequestMapping(value = { "/deposite_cancle_check_select" })
	public String depositecanclecheckselect() {
		return "deposit/deposite_cancle_check_select";
	}
}
