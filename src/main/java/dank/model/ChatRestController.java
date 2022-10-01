package main.java.dank.model;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.dank.vo.MemberVO;

@RestController
public class ChatRestController {

	@RequestMapping(value = "/chttCnsltGuide")
	public String chttCnsltGuide(HttpSession session) {
		if (session.getAttribute("member") == null) {
			return "loginPage";
		}
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		
		return null;
	}
}
