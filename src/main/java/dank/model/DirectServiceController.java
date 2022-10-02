package main.java.dank.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.dank.dao.BangkingDao;
import main.java.dank.dao.DepositDao;
import main.java.dank.dao.MemberDao;
import main.java.dank.vo.deposit.AccountHistoryVO;
import main.java.dank.vo.deposit.AccountVO;
import main.java.dank.vo.deposit.PageVO;

@Controller
public class DirectServiceController {

	@Autowired
	private BangkingDao bangkingDao;

	@Autowired
	private DepositDao depositDao;

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = "/checkbalance")
	public String viewCheckBalance(Model m, @RequestParam(value = "check", defaultValue = "yes") String check) {
		m.addAttribute("check", check);
		return "directservice/checkBalance";
	}

	@RequestMapping(value = "/chkvalue")
	public String cheValue(Model m, AccountVO accountVO, String membirth,
		/* String type, String searchDate, */ PageVO pvo,
		@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
		@RequestParam(value = "cntPerPage", required = false, defaultValue = "10") String cntPerPage) {
		// �Է¹��� ���¹�ȣ�� ������
		String ac_num = accountVO.getAc_num();
		// ���� ��ȣ�� ����ڵ带 �����´�.
		int mem_code = bangkingDao.acnumToMemcode(ac_num);//sy
		// �н������ �ֹι�ȣ ��ȿ���˻�
		String pwd = String.valueOf(depositDao.pwdChk(ac_num));
		String birth = memberDao.forBirth(mem_code);
		// �� �н����� ���н� ��
		if (!accountVO.getAc_pwd().equals(pwd) && birth.equals(membirth)) {
			return "redirect:checkbalance?check=no";
		}
		// �� �н����� ���н� ��
		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", ac_num);

		historymap.put("mem_code", String.valueOf(mem_code));

		// ������ �������� �� ���̸� ���ؿ´�.
		int total = bangkingDao.gettotalcnt(historymap);
		// ���̸� �̿��� �������� ���̸� ���Ѵ�.
		pvo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		// ���۰� ���� ���̸� �ִ´�.
		historymap.put("start", String.valueOf(pvo.getStart()));
		historymap.put("end", String.valueOf(pvo.getEnd()));
		// ����Ʈ �������� �����͸� �ִ´�.
		List<AccountHistoryVO> history = bangkingDao.gethistory(historymap);
		m.addAttribute("history", history);
		m.addAttribute("paging", pvo);
		m.addAttribute("ac_num", ac_num);

		/* m.addAttribute("type", type); */
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
