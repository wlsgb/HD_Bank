package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.dao.MemberDao;
import dank.mvc.method.Mail;
import dank.mvc.method.SecurityCode;
import dank.mvc.method.SmsProperties;


@RestController
public class SecurityRestController {

	
	@Autowired
	private SecurityCode securityCode;

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private SmsProperties smsProperties;

	// 이메일 보안코드 : 1
	// 보안코드 카드 전송 : 2
	// OTP 코드 전송 : 3
	@RequestMapping(value = "/emailsend")
	public String emailSend(String email) {
		
		StringBuilder content = new StringBuilder();
		content.append("HD-Bank 계정").append("\n");
		String SecretCode = securityCode.securityCodeMaking(4);
		content.append("보안 코드 : ").append(SecretCode);
		String name = memberDao.nameChk(email);
		mail.emailSend(email, name, "보안코드", content.toString());
		
		return SecretCode;
	}
	
	// 문자 보안코드 전송
	@RequestMapping(value = "/smssend")
	public String smsSend(String phoneNum) {
		
		StringBuilder content = new StringBuilder();
		content.append("[HD-Bank]");
		String SecretCode = securityCode.securityCodeMaking(4);
		content.append("요청하신 인증번호").append("[").append(SecretCode).append("]");
		content.append("를 화면에 입력해주세요.");
		smsProperties.sendSms(phoneNum, content.toString());
		
		return SecretCode;
	}
}
