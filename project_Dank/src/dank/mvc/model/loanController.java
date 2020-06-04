package dank.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.LoanDao;
import dank.mvc.vo.LoanProductVO;

@Controller
public class loanController {
	@Autowired
	private LoanDao loanDao;
	
	@RequestMapping(value = "/product")
	public String product(Model model) {
		List<LoanProductVO> list = loanDao.getLoanProductList();
		model.addAttribute("list", list);
		return "loan/product";
	}
	@RequestMapping(value = "/productinfo")
	public ModelAndView productinfo(int lp_num) {
		ModelAndView mav = new ModelAndView("loan/server/productserver");
		LoanProductVO vo = loanDao.getProductInfo(lp_num);
		StringBuilder info = new StringBuilder();
		info.append("<input type=\"hidden\" id=\"lp_num\" value=\"${e.lp_num }\">");
		info.append("<div class=\"col-md-12\">");
		info.append("<h1 class=\"text-center\">").append(vo.getLp_name()).append("</h1><br>");
		info.append("</div><div class=\"col-md-12\">");
		info.append("<p class=\"text-center\">").append("이자율 : ").append(vo.getLp_interestrate()).append("%</p><br>");
		info.append("</div><div class=\"col-md-12\">");
		info.append("<p class=\"text-center\">").append("최대 대출 가능 금액 : ").append(vo.getLp_maximum()).append("원</p><br>");
		info.append("</div><div class=\"col-md-12\">");
		info.append("<p class=\"text-center\">").append("중도 해지 수수료 : ").append(vo.getLp_cancelfee()).append("%</p>");
		info.append("</div>");

		mav.addObject("info", info.toString());
		return mav;
	}

	@RequestMapping(value = "/application")
	public String application(Model model) {
		List<LoanProductVO> list = loanDao.getLoanProductList();
		model.addAttribute("list", list);
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