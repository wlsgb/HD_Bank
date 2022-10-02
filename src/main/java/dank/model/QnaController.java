package main.java.dank.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.dank.dao.QnaDao;
import main.java.dank.dao.Question_princhk_Dao;
import main.java.dank.vo.MemberVO;
import main.java.dank.vo.PageVO;
import main.java.dank.vo.Question_princhk_VO;

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
		System.out.println("total:" + total);
		vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), vo.getCategori());
		System.out.println("------------------------");
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("Ÿ��" + vo.getSearchType());
		System.out.println("����" + vo.getSearchValue());
		model.addAttribute("paging", vo);
		model.addAttribute("list", qnaDao.getList(vo));

		/* System.out.println("listsize"+qnaDao.getList(vo).size()); */
		return "qna/qna";
	}

	@RequestMapping(value = "/myquestion")
	public ModelAndView listSearch3(Question_princhk_VO qvo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/myquestion");
		List<Question_princhk_VO> list = question_princhk_Dao.myQList(qvo);
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping(value = "/1on1question_princhk")
	public String listSearch2(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { //���� ������ �����Ѵٸ� home ����
			session.setAttribute("pageName", "index");
			return "login/login";
		}
		return "qna/1on1question_princhk";
	}

	@RequestMapping(value = "/addquestion")
	public String addquestion(Question_princhk_VO vo, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if (member == null) { //���� ������ �����Ѵٸ� home ����
			session.setAttribute("pageName", "check");
			return "login/login";
		}
		vo.setMem_code(member.getMem_code());
		question_princhk_Dao.questionAdd(vo);
		return "index/index";
	}

}