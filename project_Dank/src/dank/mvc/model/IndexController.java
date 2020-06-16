package dank.mvc.model;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

		@RequestMapping(value= {"/","/index"})
		public String indexPage(HttpSession session) {
			session.removeAttribute("error");
			session.removeAttribute("pageName");
			return "index/index";
		}

}
