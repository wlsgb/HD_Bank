package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
	
	@RequestMapping(value= "/1on1question_prichk")
	public String indexmm2() {
		return "member/1on1question_prichk";
	}
	@RequestMapping(value= "/1on1question")
	public String indexmm4() {
		return "member/1on1question";
	}
		
	
}