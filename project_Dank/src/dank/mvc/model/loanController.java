package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dank.mvc.dao.LoanDao;

@Controller
public class loanController {
	@Autowired
	private LoanDao loanDao;
	
	@RequestMapping(value = "/product")
	public String product(Model model) {
		System.out.println("product start");
		model.addAttribute("list", loanDao.getLoanProductList());
		System.out.println("product");
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