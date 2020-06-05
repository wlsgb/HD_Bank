package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping(value = "/emailsend")
	public String emailSend(Model m,String emailId,String emailBack) {
		
		return "myinfo/securityCard";
	}
}
