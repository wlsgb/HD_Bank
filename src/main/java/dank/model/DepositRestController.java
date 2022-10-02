package main.java.dank.model;

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

import main.java.dank.dao.BangkingDao;
import main.java.dank.dao.DepositDao;
import main.java.dank.service.BangkingService;
import main.java.dank.vo.MemberVO;
import main.java.dank.vo.deposit.At_applicationVO;
import main.java.dank.vo.deposit.Installment_savingVO;
import main.java.dank.vo.deposit.Sav_process_forModalVO;
import main.java.dank.vo.deposit.SavingVO;
import main.java.dank.vo.deposit.TransferDTO;

@RestController
public class DepositRestController {
	@Autowired
	private DepositDao depositDao;
	//////////����////////////////////////////////////////////////////
	//////////38��///////////////////////////////////////////////////
	//////////����///////////////////////////////////////////////////
	@Autowired
	private BangkingDao bangkingdao;
	@Autowired
	private BangkingService bangkingservice;

	@RequestMapping(value = "/savlist")
	public List<SavingVO> savlist() {
		return depositDao.getSavlist();
	}

	@RequestMapping(value = "/inslist")
	public List<Installment_savingVO> inslist() {
		return depositDao.getInslist();
	}

	//����-��й�ȣ Ȯ��
	@RequestMapping(value = "/acPwdChk")
	public boolean acPwdChk(String ac_pwd, String ac_num) {
		String password = String.valueOf(depositDao.pwdChk(ac_num));

		return password.equals(ac_pwd);
	}

	//����-�ܰ� ��ü�� ���� ��ȿ�� Ȯ��
	@RequestMapping(value = "/acNumChk", produces = "application/text; charset=utf8")
	public String acNumChk(String take_ac) {
		boolean existAc = depositDao.existAc(take_ac);

		if (existAc) {
			MemberVO member = depositDao.getMember(take_ac);
			return member.getMem_name();
		}
		return null;
	}

	@RequestMapping(value = "/getmemcodewhentr")
	public List<Map<String, String>> gettransfermemcode(String acnum) {/////ac_num �̾ƴ϶� acnum��
		List<Map<String, String>> val = bangkingdao.getmemcodewhentr(acnum);

		return val;
	}

	@RequestMapping(value = "/getmybalwhentr")
	public String getmybalwhentr(HttpSession session, String ac_num) {
		MemberVO sessionmem = (MemberVO)session.getAttribute("member");
		Map<String, String> getmybalwhentr = new HashMap<String, String>();
		getmybalwhentr.put("mem_code", String.valueOf(sessionmem.getMem_code()));
		getmybalwhentr.put("ac_num", ac_num);
		return bangkingdao.getmybalwhentr(getmybalwhentr);
	}

	@RequestMapping(value = "/atloadval")
	public List<At_applicationVO> atloadval() {

		return bangkingdao.atloadval();
	}

	@RequestMapping(value = "/atprocess")//���� �ʿ����
	public String atprocess(
		@RequestParam(value = "myac") String myac
		, @RequestParam(value = "memcode") String memcode
		, @RequestParam(value = "yourac") String yourac
		, @RequestParam(value = "youracmem") String youracmem
		, @RequestParam(value = "trmoney") String trmoney
		, @RequestParam(value = "youracwrite", defaultValue = "�ڵ���ü�ε���") String youracwrite
		, @RequestParam(value = "myacwrite", defaultValue = "�ڵ���ü�κ���") String myacwrite
		, @RequestParam(value = "atacode") String atacode

	) {

		try {
			myacwrite = URLDecoder.decode(myacwrite, "UTF-8");
			youracwrite = URLDecoder.decode(youracwrite, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		if (bangkingdao.trtrAcChk(myac) >= 1) {
			System.out.println("1");
			if (bangkingdao.trtrAcChk(yourac) >= 1) {

				System.out.println("2");

				if (Long.parseLong(bangkingdao.trbalChk(my_tr)) >= Long.parseLong(trmoney)) {
					bangkingservice.transferprocess(my_tr, your_tr);
					System.out.println("�ڵ���ü�����");
				} else {
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

	//sp_code�� �޾ƿͼ� �ŷ����� Ȯ��
	@RequestMapping(value = "/sp_codeis")
	public List<Sav_process_forModalVO> getsp_code(String sp_code) {
		//System.out.println(sp_code);
		List<Sav_process_forModalVO> classified = bangkingdao.classifiedmodal(sp_code);
		List<Sav_process_forModalVO> modal = null;
		for (Sav_process_forModalVO e : classified) {
			//System.out.println(e.getWit_code());
			//System.out.println(e.getDep_code());
			//System.out.println(e.getAt_code());

			if (e.getAt_code() != 0) {
				modal = bangkingdao.modal_tr(sp_code);
				modal.get(0).setClassified("��ü�ŷ�");
				//System.out.println("������ü�ŷ�");
			} else if ((e.getAt_code() == 0) && (e.getDep_code() != 0)) {
				modal = bangkingdao.modal_dep(sp_code);
				modal.get(0).setClassified("�Աݰŷ�");
				//System.out.println("�ӱݰŷ�");
			} else if ((e.getAt_code() == 0) && (e.getWit_code() != 0)) {
				modal = bangkingdao.modal_wit(sp_code);
				modal.get(0).setClassified("��ݰŷ�");
				//System.out.println("��ݰŷ�");
			}
		}

		return modal;
	}
}
