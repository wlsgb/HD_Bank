package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.dao.MemberDao;
import dank.mvc.method.Mail;
import dank.mvc.method.SecurityCode;


@RestController
public class SecurityService {

	
	@Autowired
	private SecurityCode securityCode;

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private Mail mail;

	// 이메일 보안코드 : 1
	// 보안코드 카드 전송 : 2
	// OTP 코드 전송 : 3
	@RequestMapping(value = "/emailsend")
	public String emailSend(String email) {
		
		StringBuilder content = new StringBuilder();
		content.append("HD-Bank 계정").append("\n");
		String emailCode = securityCode.securityCodeMaking(4);
		content.append("보안 코드 : ").append(emailCode);
		String name = memberDao.nameChk(email);
		mail.emailSend(email, name, "보안코드", content.toString());
		
		return emailCode;
	}
}
