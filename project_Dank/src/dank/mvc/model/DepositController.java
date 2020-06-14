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
import dank.mvc.vo.deposit.At_applicationVO;
import dank.mvc.vo.deposit.Installment_savingVO;

import dank.mvc.vo.deposit.SavingVO;


@Controller
public class DepositController {
	@Autowired
	private DepositDao depositDao;

	@Autowired
	private AccountNum accountNum;

	
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
	///////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private BangkingDao bangkingdao;
	@Autowired
	private BangkingService bangkingservice;
	//조회-계좌조회
	@RequestMapping(value = { "/inquire" })
	public ModelAndView inquirePage(
			HttpSession session
			) {
		//session.setAttribute("mem_code", mem_code);
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();

		//System.out.println("계좌조회에서 있는 세션은="+session.getAttribute("mem_code"));
		System.out.println("계좌조회에서 있는 세션은="+sessionmem.getMem_code());
		
		
		

		List<AccountVO> aclist = bangkingdao.getaclist(sessionmem.getMem_code());

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
	//입금하기 (임시기능)
	@RequestMapping(value={ "/deposit" })
	public ModelAndView executedeposit(HttpSession session,String ac_num) {
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		System.out.println("******************입금실행댐,계좌번호는 ="+ac_num+",");
		
		String money ="10000";
		
		System.out.println("존재유무"+bangkingdao.depcheckac(ac_num));
		
		if(bangkingdao.depcheckac(ac_num)>=1) {
		Map<String, String> paramapsp = new HashMap<String, String>();
		paramapsp.put("ac_num", ac_num);
		paramapsp.put("sp_name", "입금테스트용");
		paramapsp.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		Map<String, String> paramapbal = new HashMap<String, String>();
		paramapbal.put("ac_num", ac_num);
		paramapbal.put("dep_money",money);
		paramapbal.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		bangkingservice.depositprocess(money, paramapsp, paramapbal);
		}
		
		
		
		mav.setViewName("redirect:inquire");
		return mav;
	}
	
	//출금하기(임시기능)
	@RequestMapping(value={ "/withdraw" })
	public ModelAndView executewithdraw(HttpSession session,String ac_num) {
		//int acnum = Integer.parseInt(ac_num);
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		System.out.println("******************출금실행댐,계좌번호는 ="+ac_num+",");
		
		String money ="10000";
		
		System.out.println("존재유무"+bangkingdao.witcheckac(ac_num));
		
		if(bangkingdao.witcheckac(ac_num)>=1) {
			Map<String, String> paramckbal = new HashMap<String, String>();
			paramckbal.put("ac_num", ac_num);
			paramckbal.put("mem_code", String.valueOf(sessionmem.getMem_code()));
			if(Long.parseLong(bangkingdao.witcheckbal(paramckbal)) >= Long.parseLong(money)) {
				Map<String, String> paramapsp = new HashMap<String, String>();
				paramapsp.put("ac_num", ac_num);
				paramapsp.put("mem_code", String.valueOf(sessionmem.getMem_code()));
				paramapsp.put("sp_name", "출금테스트용");
				Map<String, String> paramapbal = new HashMap<String, String>();
				paramapbal.put("ac_num", ac_num);
				paramapbal.put("mem_code", String.valueOf(sessionmem.getMem_code()));
				paramapbal.put("wit_money",money);
				bangkingservice.withdrawprocess(money, paramapsp, paramapbal);
			}
			
			
			
		}
		
		
		
		mav.setViewName("redirect:inquire");
		return mav;
	}
	//자동이체 진행
	@RequestMapping(value = "/transfer_process")
	public ModelAndView transferprocess(HttpSession session
			,@RequestParam(value = "myac") String myac
			,@RequestParam(value = "yourac") String yourac
			,@RequestParam(value = "youracmem") String youracmem
			,@RequestParam(value = "trmoney") String trmoney
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

		
		Map<String, String> mapmy = new HashMap<String, String>();
		mapmy.put("ac_num", myac);
		mapmy.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		mapmy.put("at_dps_ac", yourac);
		mapmy.put("at_set_mony", trmoney);
		
		
		Map<String, String> mapmysp = new HashMap<String, String>();
		mapmysp.put("ac_num", myac);
		mapmysp.put("mem_code",String.valueOf(sessionmem.getMem_code()));
		mapmysp.put("sp_name", myacwrite);
		
		
		Map<String, String> mapyour = new HashMap<String, String>();
		mapyour.put("ac_num", yourac);
		mapyour.put("mem_code", youracmem);
		mapyour.put("at_dps_ac",myac);
		mapyour.put("at_set_mony", trmoney);
		
		Map<String, String> mapyoursp = new HashMap<String, String>();
		mapyoursp.put("ac_num", yourac);
		mapyoursp.put("mem_code",youracmem);
		mapyoursp.put("sp_name", youracwrite);
		
		
		
		
		if(bangkingdao.trtrAcChk(myac) >=1) {
			System.out.println("1");
			if(bangkingdao.trtrAcChk(yourac) >=1) {

				System.out.println("2");
				
				if(Long.parseLong(bangkingdao.trbalChk(mapmy)) >=Long.parseLong(trmoney)) {
					bangkingservice.transferprocess(trmoney, mapmy, mapmysp, mapyour, mapyoursp);
					System.out.println("이체실행댐");
				}
			}
		}
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:inquire");
		return mav;
	}
	
//	@RequestMapping(value={ "/getsession" })
//	public ModelAndView getsession(HttpServletRequest req,@RequestParam(value = "mem_code") String mem_code) {
//		System.out.println("멤버코드는 : "+mem_code);
//		HttpSession session =req.getSession();
//		//session.invalidate();
//		session.setAttribute("mem_code", mem_code);
//		ModelAndView mav = new ModelAndView();
//		System.out.println("세션넣기 성공");
//		System.out.println("현ㅐ 세션 : "+session.getAttribute("mem_code"));
//		mav.setViewName("redirect:inquire");
//		return mav;
//	}
	
	
	
	//계좌내역상세조회페이지
	@RequestMapping(value = { "/inquire_detail" })
	public ModelAndView inqure_detailPage(
			HttpSession session
			,PageVO pvo
			,@RequestParam(value = "ac_num") String ac_num
			,@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage
			,@RequestParam(value = "cntPerPage", required = false, defaultValue = "20") String cntPerPage
			) {
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		System.out.println("ac_num : "+ac_num);
		System.out.println("session ? : "+sessionmem.getMem_code());
		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", ac_num);
		historymap.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		
		int total = bangkingdao.gettotalcnt(historymap);
		pvo = new PageVO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		System.out.println("Start : "+pvo.getStartPage());
		System.out.println("End : "+pvo.getEnd());
		
		historymap.put("start", String.valueOf(pvo.getStart()));
		historymap.put("end", String.valueOf(pvo.getEnd()));
		
		
		
		List<AccountHistoryVO> history =bangkingdao.gethistory(historymap);
		System.out.println("히스토리 리스트 크기 : "+history.size());
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_inquire_detail");
		mav.addObject("history",history);
		mav.addObject("paging",pvo);
		mav.addObject("ac_num",ac_num);
		return mav;
	}
	//이체 페이지로 이동
	@RequestMapping(value = { "/transfer" })
	public ModelAndView transferPage(HttpSession session,@RequestParam(value = "ac_num",defaultValue = "0") String ac_num) {
		
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		System.out.println("이체 세션은 "+sessionmem.getMem_code());

		Map<String, String> getmyaclistwhentr =new  HashMap<String, String>();
		getmyaclistwhentr.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		getmyaclistwhentr.put("ac_num", ac_num);
		
		
		List<String> myaclist = bangkingdao.getmyaclistwhentr(getmyaclistwhentr);

		//List<Integer> myaclist = bangkingDao.getmyaclistwhentr(sessionmem.getMem_code());

		for(String e : myaclist) {
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
	
	@RequestMapping(value = { "/transfer_auto_apply_process" })
	public ModelAndView transferautoapplyprocess(
			HttpSession session
			,At_applicationVO atapplyvo
			,@RequestParam( defaultValue = "-1", required = false) String atastopdate
			,@RequestParam( defaultValue = "-1", required = false) String atadterm
			//파라미터 디폴트값 받기위해서 언더바 지운거로 보내고
			//셋터로 vo값에 넣어주었다.
			) {
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		atapplyvo.setMem_code(String.valueOf(sessionmem.getMem_code()));
		atapplyvo.setAta_stopdate(atastopdate);
		atapplyvo.setAta_dterm(Integer.parseInt(atadterm));
		
//		System.out.println(atapplyvo.getAc_num());
//		System.out.println(atapplyvo.getMem_code());
//		System.out.println(atapplyvo.getAta_opac());
//		System.out.println(atapplyvo.getAta_setmny());
//		System.out.println(atapplyvo.getAta_dterm());
//		System.out.println(atapplyvo.getAta_startdate());
//		System.out.println(atapplyvo.getAta_stopdate());
//		System.out.println(atapplyvo.getAta_time());
		bangkingdao.insertatapply(atapplyvo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:transfer_auto");
		return mav;
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
