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
		return "myinfo/security";
	}

	@RequestMapping(value = "/securitycard")
	public String viewSecurity_card() {
		return "myinfo/securityCard";
	}

	@RequestMapping(value = "/securitycardsuccess")
	public String viewSecurity_card_success() {
		return "myinfo/securityCardSuccess";
	}

	@RequestMapping(value = "/securityotp")
	public String viewSecurity_otp() {
		return "myinfo/securityOtp";
	}

	@RequestMapping(value = "/securityotpsuccess")
	public String viewCheckBalance() {
		return "myinfo/securityOtpSuccess";
	}
}
