package main.java.dank.model;

import static org.junit.Assert.fail;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.dank.dao.MemberDao;
import main.java.dank.dao.SecurityDao;
import main.java.dank.dao.ShareDao;
import main.java.dank.method.AccountNum;
import main.java.dank.method.SecurityCode;
import main.java.dank.service.ShareService;
import main.java.dank.vo.MemberVO;
import main.java.dank.vo.deposit.AccountVO;
import main.java.dank.vo.deposit.Account_ClientVO;

import main.java.dank.vo.deposit.ProSavInsDto;
import main.java.dank.vo.deposit.Shared_savingVO;
import main.java.dank.vo.security.Security_Card_RegVO;

@Controller
public class ShareController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private SecurityDao securityDao;
	@Autowired
	private ShareDao shareDao;
	@Autowired
	private AccountNum accountNum;
	@Autowired
	private ShareService shareService;
	@Autowired
	private SecurityCode securityCode;

	@RequestMapping(value = "/new_shasdetail")
	public String shared_detail(Model m, int shas_code) {
		Shared_savingVO shas = shareDao.getShasQuaDetail(shas_code);
		m.addAttribute("shas", shas);
		return "deposit_new/new_shasdetail";
	}

	@RequestMapping(value = "/share_new_req_sequrity")
	public String share_new_req(Model m, int sav_code,int shas_code, int deptype, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "index");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) <= 0) {
			System.out.println("����ī�尡 ��������� �ʾҽ��ϴ�.");
			return "security/security";
		}
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		Security_Card_RegVO vo = securityDao.securityCardDetail(mem_code);
		m.addAttribute("scrVo", vo);
		m.addAttribute("scCardNum", vo.getSecCard().getSc_detcode());
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		String name = memberVO.getMem_name();
		m.addAttribute("name", name);

		String[][] securityCheckData = securityCode.cardNumControll(vo.getSecCard());
		session.setAttribute("securityCheckData", securityCheckData);
		m.addAttribute("scd", securityCheckData);
		Shared_savingVO shas = shareDao.getShasQuaDetail(shas_code);
		System.out.println("sequrity" + shas.getShas_code());
		session.setAttribute("shas", shas);
		session.setAttribute("deptype", deptype);
		session.setAttribute("sav_code", sav_code);
		session.setAttribute("pageName", "share_new_req");
		return "security/securityCardSertify";
	}

	@RequestMapping(value = "/share_new_req")
	public String share_new_req(Model m, HttpSession session) {

		Shared_savingVO shas = (Shared_savingVO) session.getAttribute("shas");
		System.out.println("req" + shas.getShas_code());

		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "new");
			return "login/login";
		}
		m.addAttribute("sav_code", session.getAttribute("sav_code"));
		m.addAttribute("shas_code", shas.getShas_code());
		m.addAttribute("deptype", session.getAttribute("deptype"));
		
		session.removeAttribute("sav_code");
		session.removeAttribute("shas");
		session.removeAttribute("deptype");

		session.setAttribute("pageName", "share_new_req");
		return "deposit_new/share_new_req";
	}

	@RequestMapping(value = "/share_new_res", method = RequestMethod.POST)
	public String share_new_res(Model m, HttpSession session, String your_email,String sav_code, String your_name, int deptype,
			int shas_code) {

		m.addAttribute("your_name", your_name);
		m.addAttribute("shas_code", shas_code);
		m.addAttribute("deptype", deptype);
		m.addAttribute("your_email", your_email);
		m.addAttribute("sav_code", sav_code);

		MemberVO member = (MemberVO) session.getAttribute("member");
		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "new");
			return "login/login";
		}

		session.setAttribute("pageName", "share_new_res");
		return "deposit_new/share_new_res";
	}

	@RequestMapping(value = "/share_new_insert")
	public String share_new_insert(String your_email, String mem_email, HttpSession session, Model m, int deptype,String ac_name,String your_name,
			String ac_pwd, int shas_code,int sav_code) {
		AccountVO account = new AccountVO();
		account.setAc_pwd(ac_pwd);

		System.out.println("shas_code:"+shas_code);
		System.out.println("���⿡��" + your_email);
		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member == null) { // ���� ������ ���������ʴ´ٸ� �α�����������
			session.setAttribute("pageName", "new");
			return "login/login";
		}
		account.setAc_name(ac_name+"{"+member.getMem_email() + "," + your_email+"}");
		System.out.println(member.getMem_email());
		ProSavInsDto psid = new ProSavInsDto();
		psid.setDeptype(deptype);
		psid.setSav_code(sav_code);

		String ac_num = accountNum.createAcNum(deptype);
		account.setAc_num(ac_num);
		//
		int mem_code = member.getMem_code();
		int pro_code = accountNum.getPro_codeNum(psid);
		Account_ClientVO clientVO1 = new Account_ClientVO();
		clientVO1.setPro_code(pro_code);
		clientVO1.setMem_code(mem_code);
		// ac_code,ac_num,ac_pwd,ac_balance,ac_name,ac_start_date,ac_end_date
		// ac_code,mem_code,pro_code
		shareService.newAccount_for_share(account, clientVO1);
		m.addAttribute("shas_code", shas_code);
		m.addAttribute("deptype", deptype);
		m.addAttribute("your_email", your_email);
		m.addAttribute("mem_email", mem_email);
		m.addAttribute("your_name", your_name);
		m.addAttribute("ac_name", ac_name);

		session.setAttribute("pageName", "share_new_complete");
		return "deposit_new/share_new_complete";
	}

	@RequestMapping(value = "/completeOrReturn")
	public String completeOrReturn(HttpSession session,
			@RequestParam(value = "shas_code", required = false, defaultValue = "1") int shas_code) {
		Shared_savingVO shas = shareDao.getShasQuaDetail(shas_code);
		session.setAttribute("shas", shas);
		session.setAttribute("deptype", 500);
		return "redirect:share_new_req";

	}
}
