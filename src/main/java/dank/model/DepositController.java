package main.java.dank.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.dank.dao.BangkingDao;
import main.java.dank.dao.DepositDao;
import main.java.dank.dao.MemberDao;
import main.java.dank.dao.ShareDao;
import main.java.dank.method.AccountNum;
import main.java.dank.service.BangkingService;
import main.java.dank.service.DepositService;
import main.java.dank.vo.MemberVO;
import main.java.dank.vo.deposit.AccountHistoryVO;
import main.java.dank.vo.deposit.AccountVO;
import main.java.dank.vo.deposit.Account_ClientVO;
import main.java.dank.vo.deposit.At_applicationVO;
import main.java.dank.vo.deposit.Installment_savingVO;
import main.java.dank.vo.deposit.PageVO;
import main.java.dank.vo.deposit.ProSavInsDto;
import main.java.dank.vo.deposit.SavingVO;
import main.java.dank.vo.deposit.TransferDTO;

@Controller
public class DepositController {
	@Autowired
	private DepositDao depositDao;
	@Autowired
	private AccountNum accountNum;
	@Autowired
	private DepositService depositService;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BangkingDao bangkingdao;
	@Autowired
	private BangkingService bangkingservice;
	@Autowired
	private ShareDao shareDao;

	// ����-�ű�-Ư�� �������� ��ǰ ������ �̵�

	// ����-�ű������� �̵�
	@RequestMapping(value = "/new")
	public String newPage(Model m) {
		return "deposit_new/new";
	}

	// ����-�ű�-Ư�� ���� ��ǰ ������ �̵�
	@RequestMapping(value = "/new_savdetail")
	public String saving_detail(HttpSession session, Model m, int sav_code) {

		System.out.println(sav_code);
		SavingVO saving = depositDao.getSavingQuaDetail(sav_code);

		MemberVO member = (MemberVO)session.getAttribute("member");
		int mem_code = member.getMem_code();
		Map<String, String> map = new HashMap<>();
		map.put("mem_code", String.valueOf(mem_code));
		map.put("sav_code", String.valueOf(sav_code));

		boolean stockBool = true;
		stockBool = depositDao.seleStock(map);
		System.out.println("stockBool:" + stockBool);

		m.addAttribute("stockBool", stockBool);
		m.addAttribute("saving", saving);
		return "deposit_new/new_savdetail";
	}

	// ����-�ű�-Ư�� ���� ��ǰ ������ �̵�
	@RequestMapping(value = "/new_insdetail")
	public String installment_detail(Model m, int ins_code) {
		Installment_savingVO ins = depositDao.getInsQuaDetail(ins_code);
		m.addAttribute("ins", ins);
		return "deposit_new/new_insdetail";
	}

	// ����-�ű�-���� ��û ������ �̵�
	@RequestMapping(value = "/saving_new")
	public String saving_new(HttpSession session, Model m, int sav_code, int deptype) {

		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "new");
			return "login/login";
		}
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		m.addAttribute("memberVO", memberVO);
		SavingVO saving = depositDao.getSavingQuaDetail(sav_code);

		m.addAttribute("saving", saving);
		m.addAttribute("deptype", deptype);
		return "deposit_new/new_deposit";
	}

	// ����-�ű�-���� ��û ������ �̵�
	@RequestMapping(value = "/ins_new")
	public String ins_new(HttpSession session, Model m, int ins_code, int deptype) {

		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "new");
			return "login/login";
		}
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		m.addAttribute("memberVO", memberVO);
		Installment_savingVO ins = depositDao.getInsQuaDetail(ins_code);
		m.addAttribute("ins", ins);
		m.addAttribute("deptype", deptype);
		return "deposit_new/new_deposit";
	}

	// ����-�ű�-���� ��û
	@RequestMapping(value = "/deposit_newComplete")
	public String deposit_new(HttpSession session, Model m, AccountVO account, int deptype,
		@RequestParam(value = "sav_code", defaultValue = "0") int sav_code,
		@RequestParam(value = "ins_code", defaultValue = "0") int ins_code) {

		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "new");
			return "login/login";
		}

		ProSavInsDto psid = new ProSavInsDto();
		psid.setDeptype(deptype);
		psid.setSav_code(sav_code);
		psid.setIns_code(ins_code);

		String ac_num = accountNum.createAcNum(deptype);
		account.setAc_num(ac_num);

		int mem_code = member.getMem_code();
		int pro_code = accountNum.getPro_codeNum(psid);
		Account_ClientVO clientVO = new Account_ClientVO();

		clientVO.setMem_code(mem_code);
		clientVO.setPro_code(pro_code);

		// ac_code,ac_num,ac_pwd,ac_balance,ac_name,ac_start_date,ac_end_date
		// ac_code,mem_code,pro_code
		depositService.newAccount(account, clientVO);
		return "deposit_new/new_success";
	}

	// ����-����
	@RequestMapping(value = "/cancel")
	public String depositecancel(HttpSession session, Model m) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "cancle");
			return "login/login";
		}

		List<AccountVO> aclist = bangkingdao.getaclist(member.getMem_code());

		List<AccountVO> savlist = new ArrayList<AccountVO>();
		List<AccountVO> inslist = new ArrayList<AccountVO>();
		for (AccountVO e : aclist) {
			if (e.getSaving().getSav_code() != 0) {
				savlist.add(e);
			} else if (e.getIns().getIns_code() != 0) {
				inslist.add(e);
			}
		}
		m.addAttribute("savlist", savlist);
		m.addAttribute("inslist", inslist);
		m.addAttribute("aclist", aclist);

		return "deposit_new/cancel";
	}

	// ���� ���� ��û
	@RequestMapping(value = "/cancel_input_info")
	public String cancel_input_info(HttpSession session, int ac_code, Model m) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "cancle");
			return "login/login";
		}

		AccountVO account = depositDao.getAcdetail(ac_code);
		m.addAttribute("account", account);

		return "deposit_new/cancel_input_info";
	}

	// ���� ���� ��û Ȯ��
	@RequestMapping(value = "/cancel_check")
	public String cancel_check(HttpSession session, int ac_code, String take_ac, Model m) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "cancle");
			return "login/login";
		}

		AccountVO account = depositDao.getAcdetail(ac_code);
		m.addAttribute("account", account);
		m.addAttribute("take_ac", take_ac);
		return "deposit_new/cancel_check";
	}

	// ���� ����
	@RequestMapping(value = {"/cancelComplete"})
	public String cancelComplete(HttpSession session, int ac_code, int money, String ac_num, String take_ac) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "cancle");
			return "login/login";
		}

		MemberVO send = depositDao.getMember(ac_num);
		MemberVO receive = depositDao.getMember(take_ac);

		TransferDTO my_tr = new TransferDTO();
		my_tr.setAc_num(ac_num);
		my_tr.setMem_code(String.valueOf(send.getMem_code()));
		my_tr.setAt_dps_ac(take_ac);
		my_tr.setSp_name(send.getMem_name());
		my_tr.setAt_set_mony(String.valueOf(money));

		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num(take_ac);
		your_tr.setMem_code(String.valueOf(receive.getMem_code()));
		your_tr.setAt_dps_ac(ac_num);
		your_tr.setSp_name(receive.getMem_name());
		your_tr.setAt_set_mony(String.valueOf(money));

		depositService.cancelComplete(ac_code, my_tr, your_tr);
		return "deposit_new/cancel_success";

	}

	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = {"/deposite_cancle_check_shareAccount"})
	public String deposite_cancle_check_shareAccount() {
		return "deposit_new/deposite_cancle_check_shareAccount";
	}

	@RequestMapping(value = {"/share_cancel_req"})
	public String share_cancel_req() {
		return "deposit_new/share_cancel_req";
	}

	@RequestMapping(value = {"/share_cancel"})
	public String share_cancel() {
		return "deposit_new/share_cancel";
	}

	// ��ȸ-������ȸ
	@RequestMapping(value = {"/inquire"})
	public ModelAndView inquirePage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "inquire");
			mav.setViewName("login/login");
			return mav;
		}
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");

		List<AccountVO> aclist = bangkingdao.getaclist(sessionmem.getMem_code());

		//���⼭ ���� �������� ��ȸ�� ���� �ڵ�(�����:������)
		for (AccountVO e : aclist) {
			if (e.getSaving().getShas_code() != 0) {
				e.setAc_name(e.getAc_name().substring(0, e.getAc_name().indexOf("{")) + "(��������:������)");

			}
		}
		List<AccountVO> additionalList = shareDao.getAdditionalList(sessionmem.getMem_email());
		for (AccountVO e : additionalList) {
			String[] namearr = e.getAc_name().substring(e.getAc_name().indexOf("{") + 1, e.getAc_name().indexOf("}"))
				.split(",");

			if (namearr[1].trim().equals(sessionmem.getMem_email().trim())) {
				e.setAc_name(e.getAc_name().substring(0, e.getAc_name().indexOf("{")) + "(��������:������)");
				aclist.add(e);
			}
		}
		//������� �������� ��ȸ�� ���� �ڵ�(�����:������)

		mav.addObject("aclist", aclist);
		mav.setViewName("deposit/deposite_inquire");

		return mav;
	}

	// �Ա��ϱ� (�ӽñ��)
	@RequestMapping(value = {"/deposit"})
	public ModelAndView executedeposit(HttpSession session, String ac_num) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();

		String money = "10000";

		if (bangkingdao.depcheckac(ac_num) >= 1) {
			Map<String, String> paramapsp = new HashMap<String, String>();
			paramapsp.put("ac_num", ac_num);
			paramapsp.put("sp_name", "�Ա��׽�Ʈ��");
			paramapsp.put("mem_code", String.valueOf(sessionmem.getMem_code()));
			Map<String, String> paramapbal = new HashMap<String, String>();
			paramapbal.put("ac_num", ac_num);
			paramapbal.put("dep_money", money);
			paramapbal.put("mem_code", String.valueOf(sessionmem.getMem_code()));
			bangkingservice.depositprocess(money, paramapsp, paramapbal);
		}

		mav.setViewName("redirect:inquire");
		return mav;
	}

	// ����ϱ�(�ӽñ��)
	@RequestMapping(value = {"/withdraw"})
	public ModelAndView executewithdraw(HttpSession session, String ac_num) {
		// int acnum = Integer.parseInt(ac_num);
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();

		String money = "10000";

		if (bangkingdao.witcheckac(ac_num) >= 1) {
			Map<String, String> paramckbal = new HashMap<String, String>();
			paramckbal.put("ac_num", ac_num);
			paramckbal.put("mem_code", String.valueOf(sessionmem.getMem_code()));
			if (Long.parseLong(bangkingdao.witcheckbal(paramckbal)) >= Long.parseLong(money)) {
				Map<String, String> paramapsp = new HashMap<String, String>();
				paramapsp.put("ac_num", ac_num);
				paramapsp.put("mem_code", String.valueOf(sessionmem.getMem_code()));
				paramapsp.put("sp_name", "����׽�Ʈ��");
				Map<String, String> paramapbal = new HashMap<String, String>();
				paramapbal.put("ac_num", ac_num);
				paramapbal.put("mem_code", String.valueOf(sessionmem.getMem_code()));
				paramapbal.put("wit_money", money);
				bangkingservice.withdrawprocess(money, paramapsp, paramapbal);
			}

		}

		mav.setViewName("redirect:inquire");
		return mav;
	}

	// ������ü ����
	@RequestMapping(value = "/transfer_process")
	public ModelAndView transferprocess(HttpSession session, @RequestParam(value = "myac") String myac,
		@RequestParam(value = "yourac") String yourac, @RequestParam(value = "youracmem") String youracmem,
		@RequestParam(value = "trmoney") String trmoney,
		@RequestParam(value = "youracwrite", defaultValue = "��ü�ε���") String youracwrite,
		@RequestParam(value = "myacwrite", defaultValue = "��ü�κ���") String myacwrite

	) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");

		TransferDTO my_tr = new TransferDTO();
		my_tr.setAc_num(myac);
		my_tr.setMem_code(String.valueOf(sessionmem.getMem_code()));
		my_tr.setAt_dps_ac(yourac);
		my_tr.setSp_name(myacwrite);
		my_tr.setAt_set_mony(trmoney);

		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num(yourac);
		your_tr.setMem_code(youracmem);
		your_tr.setAt_dps_ac(myac);
		your_tr.setSp_name(youracwrite);
		your_tr.setAt_set_mony(trmoney);

		if (bangkingdao.trtrAcChk(myac) >= 1) {

			if (bangkingdao.trtrAcChk(yourac) >= 1) {

				if (Long.parseLong(bangkingdao.trbalChk(my_tr)) >= Long.parseLong(trmoney)) {
					bangkingservice.transferprocess(my_tr, your_tr);
					System.out.println("��ü�����");
				}
			}
		}
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:inquire");
		return mav;
	}

	// ���³�������ȸ������
	@RequestMapping(value = {"/inquire_detail"})
	public ModelAndView inqure_detailPage(HttpSession session, PageVO pvo,
		@RequestParam(value = "ac_num") String ac_num,
		@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
		@RequestParam(value = "cntPerPage", required = false, defaultValue = "20") String cntPerPage) {

		MemberVO sessionmem = (MemberVO)session.getAttribute("member");

		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", ac_num);
		historymap.put("mem_code", String.valueOf(sessionmem.getMem_code()));

		int total = bangkingdao.gettotalcnt(historymap);
		pvo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		historymap.put("start", String.valueOf(pvo.getStart()));
		historymap.put("end", String.valueOf(pvo.getEnd()));

		List<AccountHistoryVO> history = bangkingdao.gethistory(historymap);

		for (AccountHistoryVO e : history) {
			System.out.println(e.getSp_code());
			System.out.println(e.getName());
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_inquire_detail");
		mav.addObject("history", history);
		mav.addObject("paging", pvo);
		mav.addObject("ac_num", ac_num);
		return mav;
	}

	// ���³�������ȸ������2
	@RequestMapping(value = {"/inquire_detail_slct"})
	public ModelAndView inqure_detail_slctPage(HttpSession session, PageVO pvo,
		@RequestParam(value = "ac_num") String ac_num, @RequestParam(value = "startdate") String startdate,
		@RequestParam(value = "lastdate") String lastdate,
		@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
		@RequestParam(value = "cntPerPage", required = false, defaultValue = "20") String cntPerPage) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		System.out.println("ac_num�� :" + ac_num);
		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", ac_num);
		historymap.put("mem_code", String.valueOf(sessionmem.getMem_code()));

		int total = bangkingdao.gettotalcnt(historymap);
		pvo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		historymap.put("start", String.valueOf(pvo.getStart()));
		historymap.put("end", String.valueOf(pvo.getEnd()));
		historymap.put("startdate", startdate);
		historymap.put("lastdate", lastdate);

		List<AccountHistoryVO> history = bangkingdao.gethistory_slct(historymap);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_inquire_detail");
		mav.addObject("history", history);
		mav.addObject("paging", pvo);
		mav.addObject("ac_num", ac_num);
		return mav;
	}

	// ��ü �������� �̵�
	@RequestMapping(value = {"/transfer"})
	public ModelAndView transferPage(HttpSession session,
		@RequestParam(value = "ac_num", defaultValue = "0") String ac_num) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "transfer");
			mav.setViewName("login/login");
			return mav;
		}

		MemberVO sessionmem = (MemberVO)session.getAttribute("member");

		Map<String, String> getmyaclistwhentr = new HashMap<String, String>();
		getmyaclistwhentr.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		getmyaclistwhentr.put("ac_num", ac_num);

		List<String> myaclist = bangkingdao.getmyaclistwhentr(getmyaclistwhentr);

		mav.setViewName("deposit/deposite_transfer");
		mav.addObject("myaclist", myaclist);

		return mav;
	}

	@RequestMapping(value = {"/transfer_auto"})
	public ModelAndView transferautoPage(HttpSession session) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		List<AccountVO> aclist = bangkingdao.getaclist(sessionmem.getMem_code());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_transfer_auto");
		mav.addObject("aclist", aclist);

		return mav;
	}

	@RequestMapping(value = {"/transfer_timereset"})
	public ModelAndView transferautotimeresetPage(HttpSession session,
		@RequestParam(value = "restartdate") String restartdate, @RequestParam(value = "retime") String retime,
		@RequestParam(value = "ata_code") String ata_code) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		Map<String, String> atresetparam = new HashMap<String, String>();
		atresetparam.put("restartdate", restartdate);
		atresetparam.put("retime", retime);
		atresetparam.put("ata_code", ata_code);

		bangkingdao.atreset(atresetparam);

		List<AccountVO> aclist = bangkingdao.getaclist(sessionmem.getMem_code());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/deposite_transfer_auto");
		mav.addObject("aclist", aclist);

		return mav;
	}

	@RequestMapping(value = "/transfer_auto_cancle")
	public ModelAndView transferautoacancle(HttpSession session, @RequestParam(value = "ata_code") String ata_code) {
		ModelAndView mav = new ModelAndView();
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");

		bangkingdao.atdelete(ata_code);
		List<AccountVO> aclist = bangkingdao.getaclist(sessionmem.getMem_code());

		mav.setViewName("deposit/deposite_transfer_auto");
		mav.addObject("aclist", aclist);
		return mav;
	}

	@RequestMapping(value = {"/transfer_auto_apply"})
	public ModelAndView transferautoapplyPage(HttpSession session, String ac_num) {

		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		Map<String, String> getmyaclistwhentr = new HashMap<String, String>();
		getmyaclistwhentr.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		getmyaclistwhentr.put("ac_num", ac_num);
		List<String> myaclist = bangkingdao.getmyaclistwhentr(getmyaclistwhentr);

		mav.setViewName("deposit/deposite_transfer_auto_apply");
		mav.addObject("myaclist", myaclist);
		return mav;
	}

	@RequestMapping(value = {"/transfer_auto_apply_process"}, method = RequestMethod.POST)
	public ModelAndView transferautoapplyprocess(HttpSession session, At_applicationVO atapplyvo,
		@RequestParam(value = "atastopdate", defaultValue = "-1", required = false) String atastopdate,
		@RequestParam(value = "atadterm", defaultValue = "-1", required = false) String atadterm,
		@RequestParam(value = "atamyacmemo", defaultValue = "�ڵ���ü", required = false) String atamyacmemo,
		@RequestParam(value = "atayouracmemo", defaultValue = "�ڵ���ü", required = false) String atayouracmemo,
		@RequestParam(value = "atacheck", defaultValue = "-1", required = false) String atacheck,
		@RequestParam(value = "ataing", defaultValue = "-1", required = false) String ataing
		// �Ķ���� ����Ʈ�� �ޱ����ؼ� ����� ����ŷ� ������
		// ���ͷ� vo���� �־��־���.
	) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		atapplyvo.setMem_code(sessionmem.getMem_code());
		atapplyvo.setAta_stopdate(atastopdate);
		atapplyvo.setAta_dterm(Integer.parseInt(atadterm));
		atapplyvo.setAta_myacmemo(atamyacmemo);
		atapplyvo.setAta_youracmemo(atayouracmemo);
		atapplyvo.setAta_check(Integer.parseInt(atacheck));
		atapplyvo.setAta_ing(Integer.parseInt(ataing));

		bangkingdao.insertatapply(atapplyvo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:transfer_auto");

		return mav;
	}

	@RequestMapping(value = "/deposit_transfer_auto_server")
	public ModelAndView deposit_transfer_auto_server(HttpSession session,
		@RequestParam(value = "ac_num") String ac_num) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deposit/server/deposit_transfer_auto_server");
		Map<String, String> atlistparam = new HashMap<String, String>();
		atlistparam.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		atlistparam.put("ac_num", ac_num);

		List<Map<String, String>> atlist = bangkingdao.atlist(atlistparam);

		mav.addObject("atlist", atlist);
		return mav;
	}

	@RequestMapping(value = "/analysis")
	public String viewAnalysis() {
		return "deposit/analysis";
	}
}
