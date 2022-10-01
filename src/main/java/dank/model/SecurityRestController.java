package main.java.dank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.dank.dao.MemberDao;
import main.java.dank.method.Mail;
import main.java.dank.method.SecurityCode;
import main.java.dank.method.SmsProperties;


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

	// �̸��� �����ڵ� : 1
	// �����ڵ� ī�� ���� : 2
	// OTP �ڵ� ���� : 3
	@RequestMapping(value = "/emailsend")
	public String emailSend(String email) {
		
		StringBuilder content = new StringBuilder();
		content.append("HD-Bank ����").append("\n");
		String SecretCode = securityCode.securityCodeMaking(4);
		content.append("���� �ڵ� : ").append(SecretCode);
		String name = memberDao.nameChk(email);
		mail.emailSend(email, name, "�����ڵ�", content.toString());
		
		return SecretCode;
	}
	
	// ���� �����ڵ� ����
	@RequestMapping(value = "/smssend")
	public String smsSend(String phoneNum) {
		
		StringBuilder content = new StringBuilder();
		content.append("[HD-Bank]");
		String SecretCode = securityCode.securityCodeMaking(4);
		content.append("��û�Ͻ� ������ȣ").append("[").append(SecretCode).append("]");
		content.append("�� ȭ�鿡 �Է����ּ���.");
		smsProperties.sendSms(phoneNum, content.toString());
		
		return SecretCode;
	}
}
