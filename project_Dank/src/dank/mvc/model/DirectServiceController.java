package dank.mvc.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectServiceController {

	@RequestMapping(value = "/checkbalance")
	public String viewCheckBalance() {
		return "directservice/checkBalance";
	}
	
	@RequestMapping(value = "/chkvalue")
	public String cheValue(Model m, HttpServletRequest req, String num, String accountNumber) {
		System.out.println("num : " + num);
		System.out.println("accountNumber : " + accountNumber);
		String[] type = req.getParameterValues("type");
		System.out.println("type : " + type[0]);
		return "directservice/checkBalance";
	}

	@RequestMapping(value = "/exchangerate")
	public String viewExchangeRate() {
		return "directservice/exchangeRate";
	}

	@RequestMapping(value = "/search")
	public String viewSearch() {
		return "directservice/search";
	}
}
