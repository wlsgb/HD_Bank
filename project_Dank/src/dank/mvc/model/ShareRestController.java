package dank.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.dao.MemberDao;
import dank.mvc.dao.ShareDao;
import dank.mvc.method.Mail;
import dank.mvc.vo.deposit.Shared_savingVO;

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
	 * StringBuffer().append("<h1>[이메일 인증]</h1>")
	 * .append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
	 * .append("<a href='http://localhost:8080/user/joinConfirm?")
	 * .append("mem_email=") .append(your_email)
	 * .append("' target='_blenk'>이메일 인증 확인</a>") .toString();
	 * mail.emailSend(your_email, your_name, "계좌개설 확인메일입니다.", content); return
	 * shareDao.getSharelist(); }
	 */
	@RequestMapping(value = "/checkEmail")
	public int checkEmail(String email) {	
		System.out.println(email);
		System.out.println(memberDao.idchk(email));
		return memberDao.idchk(email);
	}
}
