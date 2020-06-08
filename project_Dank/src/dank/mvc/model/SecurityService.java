package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.method.Mail;

@RestController
public class SecurityService {

	@Autowired
	private Mail mail;
	
	@RequestMapping(value = "/emailsend")
	public String emailSend(String email) {
		System.out.println(email);
		String code = mail.emailSend(email, "김진휴", "보안코드입니다.");
		return code;
	}
}
