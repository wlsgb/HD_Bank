package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loanController {
	
	@RequestMapping(value = "/jinhyu")
	public String jinhyu() {
		return "loan/product";
	}
	
	@RequestMapping(value = "/product")
	public String product() {
		return "loan/product";
	}

	@RequestMapping(value = "/application")
	public String application() {
		return "loan/application";
	}

	@RequestMapping(value = "/applicationform")
	public String applicationform() {
		return "loan/applicationform";
	}

	@RequestMapping(value = "/applicationsuccess")
	public String applicationsuccess() {
		return "loan/applicationsuccess";
	}

	@RequestMapping(value = "/check")
	public String check() {
		return "loan/check";
	}

	@RequestMapping(value = "/checkdetail")
	public String checkdetail() {
		return "loan/checkdetail";
	}

	@RequestMapping(value = "/repayment")
	public String repayment() {
		return "loan/repayment";
	}

	@RequestMapping(value = "/repaymentdetail")
	public String repaymentdetail() {
		return "loan/repaymentdetail";
	}

	@RequestMapping(value = "/repaymentform")
	public String repaymentform() {
		return "loan/repaymentform";
	}

	@RequestMapping(value = "/caculator")
	public String caculator() {
		return "loan/caculator";
	}
}