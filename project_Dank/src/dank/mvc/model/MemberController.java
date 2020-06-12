package dank.mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.PageVO;
import dank.mvc.vo.UserVO;
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
	
	@RequestMapping(value= "/loginPage")
	public String goLoginPage(HttpSession session) {
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) { //세션 정보가 존재한다면 home 으로 
			return "index/index";
		}
		
		return "login/login"; //존재하지 않는다면 로그인 페이지로 
	}
	//로그인 페이지로 이동을함 	
	
	@ResponseBody
    @RequestMapping(value = "/login" ,method = RequestMethod.POST ,produces = "application/json")
	public String loginPage(@ModelAttribute UserVO user , HttpServletRequest req, Model m) throws Exception {
		System.out.println("로그인Cont");
		MemberVO memberVO =  memberDao.memLogin(user);
		//UserVO userVO = registerService.selectUser(user);
		HttpSession session = req.getSession();
		if(memberVO != null) {
			System.out.println("로그인성공!");
			session.setAttribute("member", memberVO);
			return "index/index";
		}
		System.out.println("로그인실패!");
		return "login/login";
	}
    //로그인 시 로그인 한 사람의 정보를 세션에 삽입 
	
    @RequestMapping(value= "/getSession")
	@ResponseBody
	public String getSession(HttpSession session) {
		
    	MemberVO member = (MemberVO)session.getAttribute("member");
		String mem_email = member.getMem_email();
		
		return mem_email;
	}
	//세션을 가져옴 
	
    @RequestMapping(value= "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/login";
	}
	//로그아웃

	
}