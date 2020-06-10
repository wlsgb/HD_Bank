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

//	// 회원가입 폼 띄우기
	@RequestMapping(value = "/memberForm")
	public String memberForm() {
		return "member/memberForm";
	}

//	// 회원가입처리하기
	@PostMapping("/memberIn") 
	public ModelAndView addMember(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		//int res = memberDao.memberAdd(vo);
		/*
		 * if (res == 1) {// 마이바티스 작업이 성공 //mav.setViewName("member/success");
		 * mav.setViewName("redirect:/"); mav.addObject("mid", vo.getMem_email()); }
		 * else { mav.setViewName("member/error"); }
		 */
		return mav;
	}
	
	@RequestMapping(value= "/1on1question_prichk")
	public String indexmm2() {
		return "member/1on1question_prichk";
	}
	@RequestMapping(value= "/1on1question")
	public String indexmm4() {
		return "member/1on1question";
	}
		
	
}