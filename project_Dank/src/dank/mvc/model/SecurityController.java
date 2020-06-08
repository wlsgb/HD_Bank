package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dank.mvc.dao.SecurityDao;
import dank.mvc.method.Mail;
import dank.mvc.method.SecurityCode;

import dank.mvc.vo.MemberVO;


import dank.mvc.vo.deposit.AccountVO;


@Controller
public class SecurityController {
	
	@Autowired
	private SecurityCode securityCode;

	@Autowired
	private SecurityDao securityDao;
	
	@RequestMapping(value = "/security")
	public String viewSecurity() {
		return "security/security";
	}

	@RequestMapping(value = "/securitycard")
	public String viewSecurity_card() {
		return "security/securityCard";
	}

	@RequestMapping(value = "/securitycardinfoView")
	public String viewSecurityCardInfoView(Model m, AccountVO accountVO, MemberVO memberVO) {
		
		return "security/securityCardInfoView";
	}
	
	// 보안카드 만드는 장소
	@RequestMapping(value = "/securitycardcreate")
	public String viewSecurity_card_success(Model m) {
		securityDao.cardCreate(securityCode.securityCardCreate());
		return "security/securityCardSuccess";
	}

	@RequestMapping(value = "/securityotp")
	public String viewSecurity_otp() {
		return "security/securityOtp";
	}

	@RequestMapping(value = "/securityotpsuccess")
	public String viewCheckBalance() {
		return "security/securityOtpSuccess";
	}
}
