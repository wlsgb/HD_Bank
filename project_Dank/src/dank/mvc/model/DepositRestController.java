package dank.mvc.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.DepositDao;
import dank.mvc.service.BangkingService;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.deposit.At_applicationVO;
import dank.mvc.vo.deposit.Installment_savingVO;
import dank.mvc.vo.deposit.Sav_process_forModalVO;
import dank.mvc.vo.deposit.SavingVO;
<<<<<<< HEAD
<<<<<<< HEAD
import dank.mvc.vo.deposit.Shared_savingVO;
import dank.mvc.vo.deposit.TransferDTO;
=======
>>>>>>> branch 'hov2' of https://github.com/wlsgb/HD_Bank.git
=======
import dank.mvc.vo.deposit.Shared_savingVO;
import dank.mvc.vo.deposit.TransferDTO;
>>>>>>> refs/remotes/origin/backupmaster

@RestController
public class DepositRestController {
	@Autowired
	private DepositDao depositDao;
	
	@RequestMapping(value = "/savlist")
	public List<SavingVO> savlist() {
		return depositDao.getSavlist();
	}
	
	@RequestMapping(value = "/inslist")
	public List<Installment_savingVO> inslist() {
		return depositDao.getInslist();
	}

	//해지-비밀번호 확인
	@RequestMapping(value = "/acPwdChk")
	public boolean acPwdChk(String ac_pwd,String ac_num) {
		String password = String.valueOf(depositDao.pwdChk(ac_num));
		
		if(password.equals(ac_pwd)) {
			return true;
		}
		return false;
	}
	//해지-잔고를 이체할 계좌 유효성 확인
	@RequestMapping(value = "/acNumChk", produces = "application/text; charset=utf8")
	public String acNumChk(String take_ac) {
		boolean existAc = depositDao.existAc(take_ac);
		
		if(existAc) {
			MemberVO member = depositDao.getMember(take_ac);
			return member.getMem_name();
		}
		return null;
	}
	//////////북쪽////////////////////////////////////////////////////
	//////////38선///////////////////////////////////////////////////
	//////////남쪽///////////////////////////////////////////////////
	@Autowired
	private BangkingDao bangkingdao;
	
	@Autowired
	private BangkingService bangkingservice;
	
	@RequestMapping(value = "/getmemcodewhentr")
	public List<Map<String, String>> gettransfermemcode(String acnum) {/////ac_num 이아니라 acnum임
		List<Map<String, String>>  val= 	bangkingdao.getmemcodewhentr(acnum);
	
		return val;
	}
	@RequestMapping(value = "/getmybalwhentr")
	public String getmybalwhentr(HttpSession session,String ac_num) {
		MemberVO sessionmem = (MemberVO) session.getAttribute("member");
		Map<String, String> getmybalwhentr = new HashMap<String, String>();
		getmybalwhentr.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		getmybalwhentr.put("ac_num", ac_num);
		return bangkingdao.getmybalwhentr(getmybalwhentr);
	}
	
	
	@RequestMapping(value = "/atloadval")
	public List<At_applicationVO> atloadval(){
		
		
		return bangkingdao.atloadval();
	}
	
	@RequestMapping(value = "/atprocess")//이젠 필요없듬
	public String atprocess(
			@RequestParam(value = "myac") String myac
			,@RequestParam(value = "memcode") String memcode
			,@RequestParam(value = "yourac") String yourac
			,@RequestParam(value = "youracmem") String youracmem
			,@RequestParam(value = "trmoney") String trmoney
			,@RequestParam(value = "youracwrite", defaultValue = "자동이체로들어옴") String youracwrite
			,@RequestParam(value = "myacwrite", defaultValue = "자동이체로빠짐") String myacwrite
			,@RequestParam(value = "atacode") String atacode
			
			){
		
		try {
			myacwrite = URLDecoder.decode(myacwrite, "UTF-8");
			youracwrite = URLDecoder.decode(youracwrite, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
<<<<<<< HEAD
<<<<<<< HEAD
		TransferDTO my_tr = new TransferDTO();
		my_tr.setAc_num(myac);
		my_tr.setMem_code(memcode);
		my_tr.setAt_dps_ac(yourac);
		my_tr.setSp_name(myacwrite);
		my_tr.setAt_set_mony(trmoney);
		my_tr.setAta_code(atacode);

		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num(yourac);
		your_tr.setMem_code(youracmem);
		your_tr.setAt_dps_ac(myac);
		your_tr.setSp_name(youracmem);
		your_tr.setAt_set_mony(trmoney);
		your_tr.setAta_code(atacode);

=======
		
		Map<String, String> mapmy = new HashMap<String, String>();
		mapmy.put("ac_num", myac);
		mapmy.put("mem_code", memcode);
		mapmy.put("at_dps_ac", yourac);
		mapmy.put("at_set_mony", trmoney);
		
		
		Map<String, String> mapmysp = new HashMap<String, String>();
		mapmysp.put("ac_num", myac);
		mapmysp.put("mem_code",memcode);
		mapmysp.put("sp_name", myacwrite);
		
		
		Map<String, String> mapyour = new HashMap<String, String>();
		mapyour.put("ac_num", yourac);
		mapyour.put("mem_code", youracmem);
		mapyour.put("at_dps_ac",myac);
		mapyour.put("at_set_mony", trmoney);
		
		Map<String, String> mapyoursp = new HashMap<String, String>();
		mapyoursp.put("ac_num", yourac);
		mapyoursp.put("mem_code",youracmem);
		mapyoursp.put("sp_name", youracwrite);
>>>>>>> branch 'hov2' of https://github.com/wlsgb/HD_Bank.git
=======
		TransferDTO my_tr = new TransferDTO();
		my_tr.setAc_num(myac);
		my_tr.setMem_code(memcode);
		my_tr.setAt_dps_ac(yourac);
		my_tr.setSp_name(myacwrite);
		my_tr.setAt_set_mony(trmoney);
		my_tr.setAta_code(atacode);

		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num(yourac);
		your_tr.setMem_code(youracmem);
		your_tr.setAt_dps_ac(myac);
		your_tr.setSp_name(youracmem);
		your_tr.setAt_set_mony(trmoney);
		your_tr.setAta_code(atacode);

>>>>>>> refs/remotes/origin/backupmaster
		
		
		
		
		if(bangkingdao.trtrAcChk(myac) >=1) {
			System.out.println("1");
			if(bangkingdao.trtrAcChk(yourac) >=1) {

				System.out.println("2");
				
				if(Long.parseLong(bangkingdao.trbalChk(my_tr)) >=Long.parseLong(trmoney)) {
					bangkingservice.transferprocess(my_tr, your_tr);
					System.out.println("자동이체실행댐");
				}else {
					bangkingdao.ifnomoneywhenat(atacode);
				}
			}
		}
		
		
		
		

		return "a";
	}
	
	@RequestMapping(value = "/dosomething")
	public void dosomething() {
		System.out.println("gdgdgd im do something");
	}
	
	@RequestMapping(value = "/dosomething2")
	public void dosomething2() {
		System.out.println("gdgdgd im do something2");
	}
	
	//sp_code를 받아와서 거래구분 확인
	@RequestMapping(value = "/sp_codeis")
	public List<Sav_process_forModalVO> getsp_code(String sp_code) {
		//System.out.println(sp_code);
		List<Sav_process_forModalVO> classified =bangkingdao.classifiedmodal(sp_code);
		List<Sav_process_forModalVO> modal=null;
		for (Sav_process_forModalVO e:classified) {
			//System.out.println(e.getWit_code());
			//System.out.println(e.getDep_code());
			//System.out.println(e.getAt_code());
			
			
			if(e.getAt_code() !=0) {
				modal =bangkingdao.modal_tr(sp_code);
				modal.get(0).setClassified("이체거래");
				//System.out.println("계좌이체거래");
			}else if((e.getAt_code()==0)&&(e.getDep_code()!=0)) {
				modal =bangkingdao.modal_dep(sp_code);
				modal.get(0).setClassified("입금거래");
				//System.out.println("임금거래");
			}else if((e.getAt_code()==0)&&(e.getWit_code()!=0)) {
				modal =bangkingdao.modal_wit(sp_code);
				modal.get(0).setClassified("출금거래");
				//System.out.println("출금거래");
			}
		}
		
		
		return modal;
	}
}
