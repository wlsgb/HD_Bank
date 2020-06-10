package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value = "/loginForm")
	public String viewlog() {
		return "login/loginForm";
	}
}
