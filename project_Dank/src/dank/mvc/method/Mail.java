package dank.mvc.method;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Mail {

	public void emailSend(String RecipientMail, String RecipientName, String title, String content) {
		// SMTP 서버 정보를 설정
		Properties props = new Properties();
		// 발송 STMP 서버
		props.put("mail.smtp.host", "smtp.naver.com");
		// SMTP서버의 포트
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		// SSL 활성화
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.naver.com");
		// SMTP 서버 정보와 사용자 계정를 기반으로
		// Session 클래스의 인스턴스를 생성

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jinproject94@naver.com", "wlsgbvmfhwprxm12");
			}
		});
		// 메일 발신자와 수신자, 제목 그리고 내용 작성을 위한 MimeMessage객체 생성
		MimeMessage message = new MimeMessage(session);
		try {
			// 발신자 설정
			message.setFrom(new InternetAddress("jinproject94@naver.com", "김진휴"));
			// 수신자 설정
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(RecipientMail, RecipientName));
			// 제목 설정
			message.setSubject(title);
			// 일반 테스트 형태
			message.setContent(content, "text/html; charset=EUC-KR");
			// 이메일 보내기
			Transport.send(message);
			System.out.println("메일이 전송 되었습니다.");
		} catch (MessagingException | UnsupportedEncodingException e) {
			System.out.println("메일이 전송 실패입니다.");
			e.printStackTrace();
		}

	}
}
