package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dank.mvc.method.Mail;

@Controller
public class SecurityController {

	@RequestMapping(value = "/security")
	public String viewSecurity() {
		return "security/security";
	}

	@RequestMapping(value = "/securitycard")
	public String viewSecurity_card() {
		return "security/securityCard";
	}

	@RequestMapping(value = "/securitycardcreate")
	public String viewSecurity_card_success(Model m) {
		
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
