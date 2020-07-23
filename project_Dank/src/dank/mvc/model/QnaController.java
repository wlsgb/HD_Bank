package dank.mvc.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dank.mvc.dao.QnaDao;
import dank.mvc.dao.Question_princhk_Dao;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.PageVO;
import dank.mvc.vo.QnaVO;
import dank.mvc.vo.Question_princhk_VO;

@Controller
public class QnaController {
	@Autowired
	private QnaDao qnaDao;
	@Autowired
	private Question_princhk_Dao question_princhk_Dao;
	@RequestMapping(value = "/qna")
	public String listSearch(PageVO vo, Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
			@RequestParam(value = "cntPerPage", required = false, defaultValue = "5") String cntPerPage,
			@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchValue", required = false) String searchValue) {
		
		System.out.println(vo.getSearchType());
		int total = qnaDao.getTotalCount(vo);
		System.out.println("total:"+total);
		vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), vo.getCategori());
		System.out.println("------------------------");
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("타입"+vo.getSearchType());
		System.out.println("벨류"+vo.getSearchValue());
		model.addAttribute("paging", vo);
		model.addAttribute("list", qnaDao.getList(vo));
		
		/* System.out.println("listsize"+qnaDao.getList(vo).size()); */
		return "qna/qna";
	}
	
	@RequestMapping(value = "/myquestion")
	public String listSearch3() {
		
		
		
		return "qna/myquestion";
	}
	
	@RequestMapping(value = "/1on1question_princhk")
	public String listSearch2(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재한다면 home 으로 
			session.setAttribute("pageName", "index");
			return "login/login";
		}	
		return "qna/1on1question_princhk";
	}
	@RequestMapping(value = "/addquestion")
	public String addquestion(Question_princhk_VO vo,HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재한다면 home 으로 
			session.setAttribute("pageName", "check");
			return "login/login";
		}	
		vo.setMem_code(member.getMem_code());
		question_princhk_Dao.questionAdd(vo);
		return "index/index";
	}
}