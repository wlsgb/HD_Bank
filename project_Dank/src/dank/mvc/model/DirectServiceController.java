package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectServiceController {
	
	@RequestMapping(value = "/checkbalance")
	public String viewCheckBalance() {
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
