package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UjaeController {

	@RequestMapping(value= "/login")
	public String u1() {
		return "login/login";
	}
	
	@RequestMapping(value= "/signup")
	public String u2() {
		return "login/signup";
	}
	
}
