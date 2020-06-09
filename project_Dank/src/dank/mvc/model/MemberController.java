package dank.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.PageVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;

//<<<<<<< HEAD
//	// 회원가입 폼 띄우기
	@RequestMapping(value = "/memberForm")
	public String memberForm() {
		return "member/memberForm";
	}
//=======
	@RequestMapping(value= "/qna1")
	public String indexmm() {
		return "member/qna";
//>>>>>>> refs/heads/javaGenius_v2
	}
//<<<<<<< HEAD

//	// 회원가입처리하기
	@PostMapping("/memberIn") 
	public ModelAndView addMember(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		int res = memberDao.memberAdd(vo);
		if (res == 1) {// 마이바티스 작업이 성공
			//mav.setViewName("member/success");
			mav.setViewName("redirect:/");
			mav.addObject("mid", vo.getMem_email());
		} else {
			mav.setViewName("member/error");
		}
		return mav;
	}
//=======
	@RequestMapping(value= "/1on1question_prichk")
	public String indexmm2() {
		return "member/1on1question_prichk";
	}
	@RequestMapping(value= "/1on1question")
	public String indexmm4() {
		return "member/1on1question";
	}
	
	@RequestMapping(value="/qna")
	public String listSearch(PageVO vo, Model model,
			@RequestParam(value="nowPage",required = false,
			defaultValue = "1") String nowPage,
			@RequestParam(value="cntPerPage",required = false,
			defaultValue = "10") String cntPerPage) {
			int total=memberDao.getTotalCount();
			
			
			vo=new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			System.out.println("Start :"+vo.getStart());
			System.out.println("End :"+vo.getEnd());
			model.addAttribute("paging", vo);
			model.addAttribute("list", memberDao.getList(vo));
			/*
			 * for(QnaVO e : memberDao.getList(vo)) { System.out.println(e.getQna_num()); }
			 */
			return "member/qna";
		
	}
	
//>>>>>>> refs/heads/javaGenius_v2
}