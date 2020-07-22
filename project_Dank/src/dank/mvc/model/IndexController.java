package dank.mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class IndexController {

		@RequestMapping(value= {"/","/index"})
		public String indexPage(HttpSession session) {
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			String ip = req.getHeader("X-FORWARDED-FOR");
			if (ip==null) {
				ip = req.getRemoteAddr();
			}
			System.out.println("ip¡§∫∏: "+ip);
			session.removeAttribute("error");
			session.removeAttribute("pageName");
			return "index/index";
		}

}
