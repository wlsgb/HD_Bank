package dank.mvc.model;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.DepositDao;

import dank.mvc.vo.deposit.AccountVO;

import dank.mvc.vo.deposit.Installment_savingVO;


import dank.mvc.vo.deposit.SavingVO;


@Controller
public class DepositController {
	@Autowired
	private DepositDao depositDao;
	
	@RequestMapping(value = "/analysis")
	public String viewAnalysis() {
		return "deposit/analysis";
	}

	@RequestMapping(value = "/new")
	public String newPage(Model m) {
		List<SavingVO> savlist= depositDao.savinglist();
		m.addAttribute("savlist",savlist);
		return "deposit/new";
	}
	
	@RequestMapping(value = "/saving_new")
	public String saving_new(Model m, int sav_code) {
		SavingVO saving = depositDao.getSavingQuaDetail(sav_code);
		m.addAttribute("saving",saving);
		return "deposit/saving_new";
	}
	
	@RequestMapping(value = "/installment_new")
	public String installment_new(Model m, int ins_code) {
		Installment_savingVO ins = depositDao.getInsQuaDetail(ins_code);
		m.addAttribute("ins",ins);
		return "deposit/installment_new";
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

//	@RequestMapping(value = { "/inquire" })
//	public String inqurePage(
//			@RequestParam(value = "gonum", required = true, defaultValue = "0") String gonum
//			) {
//		return "deposit/deposite_inquire";
//	}
	@RequestMapping(value = { "/inquire" })
	public ModelAndView inquirePage(
			@RequestParam(value = "mem_code",defaultValue = "0") String mem_code
			) {
		ModelAndView mav = new ModelAndView();
		
		
	
		
		
		
		List<AccountVO> aclist = depositDao.getaclist(1);
		for(AccountVO e :aclist) {
			
			System.out.println(e.getAc_num());
			System.out.println(e.getAc_balance());
			System.out.println(e.getSaving().getSav_name());
			System.out.println(e.getSaving().getShas_code());
			System.out.println(e.getIns().getIns_name());
			System.out.println(e.getIns().getShac_code());
			System.out.println("*******************");
			
			
			
		}
		mav.addObject("aclist",aclist);
		mav.setViewName("deposit/deposite_inquire");
		
		return mav;
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
