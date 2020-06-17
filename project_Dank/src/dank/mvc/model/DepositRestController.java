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
import dank.mvc.vo.deposit.SavingVO;

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
	
	@RequestMapping(value = "/atprocess")
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
		
		
		
		
		if(bangkingdao.trtrAcChk(myac) >=1) {
			System.out.println("1");
			if(bangkingdao.trtrAcChk(yourac) >=1) {

				System.out.println("2");
				
				if(Long.parseLong(bangkingdao.trbalChk(mapmy)) >=Long.parseLong(trmoney)) {
					bangkingservice.autotransferprocess(trmoney, mapmy, mapmysp, mapyour, mapyoursp,atacode);
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
}
