package main.java.dank.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.dank.dao.MemberDao;
import main.java.dank.dao.ShareDao;
import main.java.dank.method.Mail;
import main.java.dank.vo.deposit.Shared_savingVO;

@RestController
public class ShareRestController {
	@Autowired
	private ShareDao shareDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private Mail mail;
	@RequestMapping(value = "/sharelist")
	public List<Shared_savingVO> sharelist() {
		System.out.println(shareDao.getSharelist().get(0).getSavingVO().getSav_name());
		return shareDao.getSharelist();
	}
	/*
	 * @RequestMapping(value = "/send_mail") public List<Shared_savingVO>
	 * send_mail(String your_email,String your_name) { String content = new
	 * StringBuffer().append("<h1>[�̸��� ����]</h1>")
	 * .append("<p>�Ʒ� ��ũ�� Ŭ���Ͻø� �̸��� ������ �Ϸ�˴ϴ�.</p>")
	 * .append("<a href='http://localhost:8080/user/joinConfirm?")
	 * .append("mem_email=") .append(your_email)
	 * .append("' target='_blenk'>�̸��� ���� Ȯ��</a>") .toString();
	 * mail.emailSend(your_email, your_name, "���°��� Ȯ�θ����Դϴ�.", content); return
	 * shareDao.getSharelist(); }
	 */
	@RequestMapping(value = "/checkEmail")
	public int checkEmail(String email) {	
		System.out.println(email);
		System.out.println(memberDao.idchk(email));
		return memberDao.idchk(email);
	}
}
