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

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.DepositDao;
import dank.mvc.method.AccountNum;
import dank.mvc.service.BangkingService;


import dank.mvc.vo.deposit.PageVO;
import dank.mvc.vo.deposit.ProSavInsDto;
import dank.mvc.vo.MemberVO;

import dank.mvc.vo.deposit.AccountHistoryVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.Installment_savingVO;

import dank.mvc.vo.deposit.SavingVO;


@Controller
public class DepositController {
	@Autowired
	private DepositDao depositDao;
	@Autowired
	private AccountNum accountNum;
	@Autowired
	private BangkingDao bangkingDao;
	@Autowired
	private BangkingService bangkingservice;
	
	//예금-신규페이지 이동
	@RequestMapping(value = "/new")
	public String newPage(Model m) {
		return "deposit_new/new";
	}
	//예금-신규-특정 예금 상품 페이지 이동
	@RequestMapping(value = "/saving_detail")
	public String saving_detail(Model m, int sav_code) {
		SavingVO saving = depositDao.getSavingQuaDetail(sav_code);
		m.addAttribute("saving",saving);
		return "deposit_new/saving_detail";
	}
	//예금-신규-특정 적금 상품 페이지 이동
	@RequestMapping(value = "/installment_detail")
	public String installment_detail(Model m, int ins_code) {
		Installment_savingVO ins = depositDao.getInsQuaDetail(ins_code);
		m.addAttribute("ins",ins);
		return "deposit_new/installment_detail";
	}
	//예금-신규-예금 신청 페이지 이동
	@RequestMapping(value = "/saving_new")
	public String saving_new(Model m, int sav_code, int deptype) {
		SavingVO saving = depositDao.getSavingQuaDetail(sav_code);
		m.addAttribute("saving", saving);
		m.addAttribute("deptype", deptype);
		return "deposit_new/deposit_new";
	}
	//insert into account values(#{ac_code},#{mem_code},#{ac_num},#{ac_pwd},sysdate,#{ac_end_date},#{ac_balance},#{pro_code})
	//예금-신규-예금 신청
	@RequestMapping(value = "/deposit_newComplete")
	public String deposit_new(HttpSession session,Model m,AccountVO account,int deptype,
			@RequestParam(value = "sav_code",defaultValue = "0") int sav_code,
			@RequestParam(value = "ins_code",defaultValue = "0") int ins_code) {
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재하지않는다면 로그인페이지로
			return "login/login";
		}
		
		ProSavInsDto psid = new ProSavInsDto();
		psid.setDeptype(deptype);
		psid.setSav_code(sav_code);
		psid.setIns_code(ins_code);
		
		//ac_code,mem_code,ac_num,ac_pwd,ac_start_date,ac_end_date,ac_balance,pro_code
		int mem_code = member.getMem_code();
		String ac_num = accountNum.createAcNum(deptype);
		int pro_code = accountNum.getPro_codeNum(psid);		
		
		account.setMem_code(mem_code);
		account.setAc_num(ac_num);
		account.setPro_code(pro_code);
		
		depositDao.createAccount(account);
		
		return "deposit_new/success";
	}
	
//	@RequestMapping(value = "/share_new_req")
//	public String share_new_req() {
//		return "deposit/share_new_req";
//	}
//
//	@RequestMapping(value = "/share_new_res")
//	public String share_new_res() {
//		return "deposit/share_new_res";
//	}
//
//	@RequestMapping(value = "/share_new_insert")
//	public String share_new_insert() {
//		return "deposit/share_new_insert";
//	}
//
//	@RequestMapping(value = "/share_new_complete")
//	public String share_new_complete() {
//		return "deposit/share_new_complete";
//	}
//
//	@RequestMapping(value = "/share_new_check")
//	public String share_new_check() {
//		return "deposit/share_new_check";
//	}
	
	///////////////////////////////////////////////////////////////////////////////////////

//	@RequestMapping(value = { "/inquire" })
//	public String inqurePage(
//			@RequestParam(value = "gonum", required = true, defaultValue = "0") String gonum
//			) {
//		return "deposit/deposite_inquire";
//	}

	@RequestMapping(value = { "/inquire" })
	public ModelAndView inquirePage(
			HttpSession session
			) {
		//session.setAttribute("mem_code", mem_code);
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();

		//System.out.println("계좌조회에서 있는 세션은="+session.getAttribute("mem_code"));
		System.out.println("계좌조회에서 있는 세션은="+sessionmem.getMem_code());
		
		
		

		List<AccountVO> aclist = bangkingDao.getaclist(sessionmem.getMem_code());

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
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		System.out.println("******************입금실행댐,계좌번호는 ="+ac_num+",");
		
		int money =10000;
		
		System.out.println("존재유무"+bangkingDao.depcheckac(ac_num));
		
		if(bangkingDao.depcheckac(ac_num)>=1) {
		Map<String, String> paramapsp = new HashMap<String, String>();
		paramapsp.put("ac_num", String.valueOf(ac_num));
		paramapsp.put("sp_name", "입금테스트용");
		paramapsp.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		Map<String, Integer> paramapbal = new HashMap<String, Integer>();
		paramapbal.put("ac_num", ac_num);
		paramapbal.put("dep_money",money);
		paramapbal.put("mem_code", sessionmem.getMem_code());
		bangkingservice.depositprocess(money, paramapsp, paramapbal);
		}
		
		
		
		mav.setViewName("redirect:inquire");
		return mav;
	}
	

	@RequestMapping(value={ "/withdraw" })
	public ModelAndView executewithdraw(HttpSession session,String ac_num) {
		int acnum = Integer.parseInt(ac_num);
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		System.out.println("******************출금실행댐,계좌번호는 ="+ac_num+",");
		
		int money =10000;
		
		System.out.println("존재유무"+bangkingDao.witcheckac(acnum));
		
		if(bangkingDao.witcheckac(acnum)>=1) {
			Map<String, Integer> paramckbal = new HashMap<String, Integer>();
			paramckbal.put("ac_num", acnum);
			paramckbal.put("mem_code", sessionmem.getMem_code());
			if(bangkingDao.witcheckbal(paramckbal) >= money) {
				Map<String, String> paramapsp = new HashMap<String, String>();
				paramapsp.put("ac_num", String.valueOf(ac_num));
				paramapsp.put("mem_code", String.valueOf(sessionmem.getMem_code()));
				paramapsp.put("sp_name", "출금테스트용");
				Map<String, Integer> paramapbal = new HashMap<String, Integer>();
				paramapbal.put("ac_num", acnum);
				paramapbal.put("mem_code", sessionmem.getMem_code());
				paramapbal.put("wit_money",money);
				bangkingservice.withdrawprocess(money, paramapsp, paramapbal);
			}
			
			
			
		}
		
		
		
		mav.setViewName("redirect:inquire");
		return mav;
	}
	@RequestMapping(value = "/transfer_process")
	public ModelAndView transferprocess(HttpSession session
			,@RequestParam(value = "myac") int myac
			,@RequestParam(value = "yourac") int yourac
			,@RequestParam(value = "youracmem") int youracmem
			,@RequestParam(value = "trmoney") int trmoney
			,@RequestParam(value = "youracwrite", defaultValue = "이체로들어옴") String youracwrite
			,@RequestParam(value = "myacwrite", defaultValue = "이체로빠짐") String myacwrite
			
			) {
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		System.out.println("트랜스퍼입니다."+sessionmem.getMem_code());
		System.out.println("나의계좌"+myac);
		System.out.println("입금계좌"+yourac);
		System.out.println("입금액"+trmoney);
		System.out.println("받는분통장표시"+youracwrite);
		System.out.println("나의통장표시"+myacwrite);

		
		Map<String, Integer> mapmy = new HashMap<String, Integer>();
		mapmy.put("ac_num", myac);
		mapmy.put("mem_code", sessionmem.getMem_code());
		mapmy.put("at_dps_ac", yourac);
		mapmy.put("at_set_mony", trmoney);
		
		
		Map<String, String> mapmysp = new HashMap<String, String>();
		mapmysp.put("ac_num", String.valueOf(myac));
		mapmysp.put("mem_code",String.valueOf(sessionmem.getMem_code()));
		mapmysp.put("sp_name", myacwrite);
		
		
		Map<String, Integer> mapyour = new HashMap<String, Integer>();
		mapyour.put("ac_num", yourac);
		mapyour.put("mem_code", youracmem);
		mapyour.put("at_dps_ac",myac);
		mapyour.put("at_set_mony", trmoney);
		
		Map<String, String> mapyoursp = new HashMap<String, String>();
		mapyoursp.put("ac_num", String.valueOf(yourac));
		mapyoursp.put("mem_code",String.valueOf(youracmem));
		mapyoursp.put("sp_name", youracwrite);
		
		
		
		
		if(bangkingDao.trtrAcChk(myac) >=1) {
			System.out.println("1");
			if(bangkingDao.trtrAcChk(yourac) >=1) {

				System.out.println("2");
				
				if(bangkingDao.trbalChk(mapmy) >=trmoney) {
					bangkingservice.transferprocess(trmoney, mapmy, mapmysp, mapyour, mapyoursp);
					System.out.println("이체실행댐");
				}
			}
		}
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:inquire");
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
		mav.setViewName("redirect:inquire");
		return mav;
	}
	
	
	

	@RequestMapping(value = { "/inquire_detail" })
	public ModelAndView inqure_detailPage(
			HttpSession session
			,PageVO pvo
			,@RequestParam(value = "ac_num") int ac_num
			,@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage
			,@RequestParam(value = "cntPerPage", required = false, defaultValue = "20") String cntPerPage
			) {
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		System.out.println("ac_num : "+ac_num);
		System.out.println("session ? : "+sessionmem.getMem_code());
		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", String.valueOf(ac_num));
		historymap.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		
		int total = bangkingDao.gettotalcnt(historymap);
		pvo = new PageVO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		System.out.println("Start : "+pvo.getStartPage());
		System.out.println("End : "+pvo.getEnd());
		
		historymap.put("start", String.valueOf(pvo.getStart()));
		historymap.put("end", String.valueOf(pvo.getEnd()));
		
		
		
		List<AccountHistoryVO> history =bangkingDao.gethistory(historymap);
		System.out.println("히스토리 리스트 크기 : "+history.size());
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_inquire_detail");
		mav.addObject("history",history);
		mav.addObject("paging",pvo);
		mav.addObject("ac_num",ac_num);
		return mav;
	}

	@RequestMapping(value = { "/transfer" })
	public ModelAndView transferPage(HttpSession session) {
		
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		System.out.println("이체 세션은 "+sessionmem.getMem_code());
		List<Integer> myaclist = bangkingDao.getmyaclistwhentr(sessionmem.getMem_code());
		for(Integer e : myaclist) {
			System.out.println(e);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_transfer");
		mav.addObject("myaclist",myaclist);
		
		return mav;
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
	
	@RequestMapping(value = "/analysis")
	public String viewAnalysis() {
		return "deposit/analysis";
	}
}
