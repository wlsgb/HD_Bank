package main.java.dank.method;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Repository;

@Repository
public class Mail {

	public void emailSend(String RecipientMail, String RecipientName, String title, String content) {
		// SMTP ���� ������ ����
		Properties props = new Properties();
		// �߼� STMP ����
		props.put("mail.smtp.host", "smtp.naver.com");
		// SMTP������ ��Ʈ
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		// SSL Ȱ��ȭ
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.naver.com");
		// SMTP ���� ������ ����� ������ �������
		// Session Ŭ������ �ν��Ͻ��� ����

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jinproject94@naver.com", "wlsgbvmfhwprxm12");
			}
		});
		// ���� �߽��ڿ� ������, ���� �׸��� ���� �ۼ��� ���� MimeMessage��ü ����
		MimeMessage message = new MimeMessage(session);
		try {
			// �߽��� ����
			message.setFrom(new InternetAddress("jinproject94@naver.com", "������"));
			// ������ ����
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RecipientMail, RecipientName));
			// ���� ����
			message.setSubject(title);
			// �Ϲ� �׽�Ʈ ����
			message.setContent(content, "text/html; charset=EUC-KR");
			// �̸��� ������
			Transport.send(message);
			System.out.println("������ ���� �Ǿ����ϴ�.");
		} catch (MessagingException | UnsupportedEncodingException e) {
			System.out.println("������ ���� �����Դϴ�.");
			e.printStackTrace();
		}

	}
}
