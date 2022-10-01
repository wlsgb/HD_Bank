package dank.mvc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.DepositDao;
import dank.mvc.dao.MemberDao;
import dank.mvc.vo.deposit.AccountHistoryVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.PageVO;

@Controller
public class DirectServiceController {

	@Autowired
	private BangkingDao bangkingDao;

	@Autowired
	private DepositDao depositDao;

	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value = "/checkbalance")
	public String viewCheckBalance(Model m , @RequestParam(value = "check",defaultValue = "yes")String check) {
		m.addAttribute("check",check);
		return "directservice/checkBalance";
	}

	@RequestMapping(value = "/chkvalue")
	public String cheValue(Model m, AccountVO accountVO, String membirth,
			/* String type, String searchDate, */ PageVO pvo,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
			@RequestParam(value = "cntPerPage", required = false, defaultValue = "10") String cntPerPage) {
		// 입력받은 계좌번호를 가져옴
		String ac_num = accountVO.getAc_num();
		// 계좌 번호로 멤버코드를 가져온다.
		int mem_code = bangkingDao.acnumToMemcode(ac_num);//sy
		// 패스워드와 주민번호 유효성검사
		String pwd = String.valueOf(depositDao.pwdChk(ac_num));
		String birth = memberDao.forBirth(mem_code);
		// ▼ 패스워드 실패시 ▼
		if (!accountVO.getAc_pwd().equals(pwd)&&birth.equals(membirth)) {
			return "redirect:checkbalance?check=no";
		}
		// ▲ 패스워드 실패시 ▲
		Map<String, String> historymap = new HashMap<String, String>();
		historymap.put("ac_num", ac_num);

		historymap.put("mem_code", String.valueOf(mem_code));

		// 가져온 데이터의 총 길이를 구해온다.
		int total = bangkingDao.gettotalcnt(historymap);
		// 길이를 이용해 페이지의 길이를 정한다.
		pvo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		// 시작과 끝의 길이를 넣는다.
		historymap.put("start", String.valueOf(pvo.getStart()));
		historymap.put("end", String.valueOf(pvo.getEnd()));
		// 리스트 형식으로 데이터를 넣는다.
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
