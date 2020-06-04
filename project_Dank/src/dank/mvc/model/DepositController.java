package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepositController {

	@RequestMapping(value = "/analysis")
	public String viewAnalysis() {
		return "deposit/analysis";
	}

	@RequestMapping(value = "/new")
	public String newPage() {
		return "deposit/new";
	}

	@RequestMapping(value = "/share_new_req")
	public String share_new_req() {
		return "deposit/share_new_req";
	}

	@RequestMapping(value = "/share_new_res")
	public String share_new_res() {
		return "deposit/share_new_res";
	}

	@RequestMapping(value = "/share_new_insert")
	public String share_new_insert() {
		return "deposit/share_new_insert";
	}

	@RequestMapping(value = "/share_new_complete")
	public String share_new_complete() {
		return "deposit/share_new_complete";
	}

	@RequestMapping(value = "/share_new_check")
	public String share_new_check() {
		return "deposit/share_new_check";
	}

	@RequestMapping(value = { "/inquire" })
	public String inqurePage() {
		return "deposit/deposite_inquire";
	}

	@RequestMapping(value = { "/inquire_detail" })
	public String inqure_detailPage() {
		return "deposit/deposite_inquire_detail";
	}

	@RequestMapping(value = { "/transfer" })
	public String transferPage() {
		return "deposit/deposite_transfer";
	}

	@RequestMapping(value = { "/transfer_auto" })
	public String transferautoPage() {
		return "deposit/deposite_transfer_auto";
	}

	@RequestMapping(value = { "/transfer_auto_apply" })
	public String transferautoapplyPage() {
		return "deposit/deposite_transfer_auto_apply";
	}

	@RequestMapping(value = { "/deposite_cancle" })
	public String depositecancle() {
		return "deposit/deposite_cancle";
	}

	@RequestMapping(value = { "/deposite_cancle_input_info" })
	public String depositecancleinputinfo() {
		return "deposit/deposite_cancle_input_info";
	}

	@RequestMapping(value = { "/deposite_cancle_check_Account" })
	public String depositecanclecheckshareAccount() {
		return "deposit/deposite_cancle_check_shareAccount";
	}

	@RequestMapping(value = { "/deposite_cancle_check_select" })
	public String depositecanclecheckselect() {
		return "deposit/deposite_cancle_check_select";
	}
}
