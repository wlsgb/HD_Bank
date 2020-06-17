package dank.mvc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.DepositDao;
import dank.mvc.dao.MemberDao;
import dank.mvc.dao.SecurityDao;
import dank.mvc.method.Mail;
import dank.mvc.method.SecurityCode;
import dank.mvc.service.SecurityService;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.SecuritySertufyVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.security.Security_CardVO;
import dank.mvc.vo.security.Security_Card_RegVO;

@Controller
public class SecurityController {

	@Autowired
	private DepositDao depositDao;

	@Autowired
	private BangkingDao bangkingdao;
	
	@Autowired
	private SecurityCode securityCode;

	@Autowired
	private SecurityDao securityDao;
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private Mail mail;

	@RequestMapping(value = "/security")
	public String viewSecurity(Model m, HttpSession session) {
		session.setAttribute("pageName", "security");
		return "security/security";
	}

	// 보안카드 인증 페이지로
	@RequestMapping(value = "/securitysertify")
	public String viewSecuritySertify(Model m, HttpSession session,String page) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "index");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) <= 0) {
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
		return "security/securityCardSertify";
	}

	// 보안카드 인증 결과 페이지
	@RequestMapping(value = "/ssc")
	public String securitySertifyChk(Model m, HttpSession session, SecuritySertufyVO securitySertufyVO) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "index");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) <= 0) {
			return "security/security";
		}
		// 다음 페이지를 <input type="hidden"> 으로 입력 받아온다.
		// 입력받은 데이터
		String main_code = securitySertufyVO.getMain_code();
		String fir_code = securitySertufyVO.getFir_code();
		String sec_code = securitySertufyVO.getSec_code();
		// 정답데이터
		String[][] realData = (String[][]) session.getAttribute("securityCheckData");
		if (main_code.equals(realData[0][2])&&fir_code.equals(realData[1][2])&&sec_code.equals(realData[2][2])) {
			session.setAttribute("scChk", true);
			return "redirect:"+(String)session.getAttribute("pageName");
		}else {
			session.setAttribute("scChk", false);
			return "redirect:securityCardSertify";
		}
	}

	// 보안카드 신청 폼 페이지
	@RequestMapping(value = "/securitycard")
	public String viewSecurity_card(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) >= 1) {
			session.setAttribute("error", "f");
			return "security/security";
		}
		session.setAttribute("error", "t");
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		List<AccountVO> aclist = bangkingdao.getaclist(mem_code);
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		m.addAttribute("aclist", aclist);
		m.addAttribute("memberVO", memberVO);
		return "security/securityCard";
	}

	// 보안카드 입력 확인 페이지
	@RequestMapping(value = "/securitycardinfoView")
	public String viewSecurityCardInfoView(Model m, AccountVO accountVO, MemberVO memberVO, String acNameNum,
			@RequestParam(value = "successData", defaultValue = "fail") String successData, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) >= 1) {
			session.setAttribute("error", "f");
			return "security/security";
		}
		String acNum = acNameNum.split("-")[1];
		String pwd = String.valueOf(depositDao.pwdChk(acNum));
		// 패스워드 성공시
		if (accountVO.getAc_pwd().equals(pwd) && successData.equals("success")) {
			m.addAttribute("acNameNum", acNameNum);
			m.addAttribute("mem_email", memberVO.getMem_email());
			return "security/securityCardInfoView";
		} else {

			return "redirect:securitycard?error=f";
		}
	}

	// 보안카드 만드는 장소
	@RequestMapping(value = "/securitycardcreate")
	public String viewSecurity_card_success(Model m, HttpSession session) {
		if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) >= 1) {
			return "index/index";
		} else if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		}
		Security_CardVO security_CardVO = securityCode.securityCardCreate();
		Security_Card_RegVO security_Card_RegVO = new Security_Card_RegVO();
		security_Card_RegVO.setMem_code(((MemberVO) session.getAttribute("member")).getMem_code());
		securityService.createSecurityCard(security_CardVO, security_Card_RegVO);
		// 메일로 만들어진 보안카드를 보내준다.
		MemberVO memberVO = memberDao.numToEmailName(security_Card_RegVO.getMem_code());
		session.setAttribute("scrVO", security_Card_RegVO);
		session.setAttribute("security_Cardvo", security_CardVO);
		String name = memberVO.getMem_name();
		String email = memberVO.getMem_email();
		String content = securityCode.securityCardSend(security_CardVO, name);
		mail.emailSend(email, name, name + "님의 보안카드", content);
		m.addAttribute("memberVO", memberVO);
		return "security/securityCardSuccess";
	}

	// 메일을 다시 보내주는 메소드
	@RequestMapping(value = "/reMail")
	public String reMail(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) >= 1) {
			session.setAttribute("error", "f");
			return "security/security";
		}
		Security_Card_RegVO vo = (Security_Card_RegVO) session.getAttribute("scrVO");
		MemberVO memberVO = memberDao.numToEmailName(vo.getMem_code());
		String name = memberVO.getMem_name();
		String email = memberVO.getMem_email();
		String content = securityCode.securityCardSend((Security_CardVO) session.getAttribute("security_Cardvo"), name);
		mail.emailSend(email, name, name + "님의 보안카드", content);
		m.addAttribute("memberVO", memberVO);
		return "security/securityCardSuccess";
	}

	// 카드생성 성공하고 확인 버튼을 누르면 작동
	@RequestMapping(value = "/scsuccess")
	public String securityCardSuccess(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		} else if (securityDao.scrNumChk(((MemberVO) session.getAttribute("member")).getMem_code()) >= 1) {
			session.setAttribute("error", "f");
			return "security/security";
		}
		session.removeAttribute("scrVO");
		session.removeAttribute("security_Cardvo");
		return "redirect:index";
	}

	// OTP 신청 폼
	@RequestMapping(value = "/securityotp")
	public String viewSecurity_otp(Model m, HttpSession session,
			@RequestParam(value = "error", defaultValue = "t") String error) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securityotp");
			return "login/login";
		}else if((securityDao.otpCheck(((MemberVO) session.getAttribute("member")).getMem_code()))>=1){
			session.setAttribute("error", "f");
			return "redirect:security";
		}
		session.setAttribute("otpProgress", true);
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		List<AccountVO> aclist = bangkingdao.getaclist(mem_code);
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		m.addAttribute("aclist", aclist);
		m.addAttribute("memberVO", memberVO);
		m.addAttribute("error", error);
		return "security/securityOtp";
	}

	// OTP 입력 확인 페이지
	@RequestMapping(value = "/otpInfoView")
	public String viewOTPInfoView(Model m, AccountVO accountVO, MemberVO memberVO, String acNameNum,
			@RequestParam(value = "successData", defaultValue = "fail") String successData, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		}else if((securityDao.otpCheck(((MemberVO) session.getAttribute("member")).getMem_code()))>=1){
			return "redirect:security";
		}
		
		String acNum = acNameNum.split("-")[1];
		String pwd = String.valueOf(depositDao.pwdChk(acNum));
		// 패스워드 성공시
		if (accountVO.getAc_pwd().equals(pwd) && successData.equals("success")) {
			m.addAttribute("acNameNum", acNameNum);
			m.addAttribute("mem_email", memberVO.getMem_email());
			return "security/securityOtpInfoView";
		} else {
			return "redirect:securityotp?error=f";
		}
	}
	
	// otp신청이 완료되었을때 진입하는 페이지
	@RequestMapping(value = "/securityotpsuccess")
	public String viewCheckBalance(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "securitycard");
			return "login/login";
		}else if((securityDao.otpCheck(((MemberVO) session.getAttribute("member")).getMem_code()))>=1){
			return "redirect:security";
		}else  if ((boolean) session.getAttribute("scChk")) {
			Map<String , Object> map = new HashMap<String, Object>();
			map.put("mem_code", ((MemberVO) session.getAttribute("member")).getMem_code());
			map.put("otp_certify", 1);
			securityDao.otpCreate((HashMap<String, Object>) map);
			session.removeAttribute("scChk");
			session.removeAttribute("pageName");
			return "security/securityOtpSuccess";
		}
		return "security/securityOtpSuccess";
	}
}
