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
	public String cheValue(Model m, HttpServletRequest req, String accountNumber, String accountPassword, String cnn, String type, String searchDate) {
		System.out.println("accountNumber : " + accountNumber);
		System.out.println("accountPassword : " + accountPassword);
		System.out.println("cnn : " + cnn);
		System.out.println("type : " + type);
		System.out.println("searchDate : " + searchDate);
		m.addAttribute("type", type);
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
