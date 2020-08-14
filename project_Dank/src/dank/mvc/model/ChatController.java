package dank.mvc.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.deposit.AccountVO;

@Controller
public class ChatController {

	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = "/chatGide")
	public String chatGidePage(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "chatGide");
			return "login/login";
		}
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		String mem_phn = memberDao.serPhone(mem_code);
		m.addAttribute("mem_phn", mem_phn);
		return "chat/chatForm";
	}
}
