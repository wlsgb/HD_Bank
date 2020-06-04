package dank.mvc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.velocity.tools.config.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectServiceController {

	@RequestMapping(value = "/checkbalance")
	public String viewCheckBalance(Model m) {
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 1, 1);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		System.out.println(year + "³â" + month + "¿ù" + day + "ÀÏ");
		
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
