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


@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;

//	// 회원가입 폼 띄우기
	@RequestMapping(value = "/memberForm")
	public String memberForm() {
		return "member/memberForm";
	}
	@RequestMapping(value = "/idchk")
	public ModelAndView idchk(String mem_email) {
		System.out.println("33"+mem_email);
		ModelAndView mav = new ModelAndView("member/server/idchkserver");
		int chk=memberDao.idchk(mem_email);
		String idchk ="";
		
		if(chk>0) {
			idchk="<p style='color:red'>중복된 이메일입니다.</p>";
			idchk+="<input type='hidden' id='chk' value='0'>";
			
		}else if (mem_email.equals("")) {
			idchk="<p style='color:red'>이메일을 입력해 주세요.</p>";
			idchk+="<input type='hidden' id='chk' value='0'>";
		}
		
		else {
			idchk="<p style='color:blue'>사용가능한 이메일입니다.</p>";
			idchk+="<input type='hidden' id='chk' value='1'>";
		}
		mav.addObject("idchk", idchk);
		return mav;
	}
	@RequestMapping(value = "/memberjoin")
	public String memberjoin(MemberVO vo,String mem_phn1,String mem_phn2,String mem_phn3, HttpSession session,
			@RequestParam(value = "successData", defaultValue = "fail") String successData) {
		if (session.getAttribute("member") != null) {
			session.setAttribute("pageName", "index");
			System.out.println("실패");
			return "login/login";
		}else if(successData.equals("fail")) {
			return "member/memberForm";
		}
		vo.setMem_phn(mem_phn1+"-"+mem_phn2+"-"+mem_phn3);
		memberDao.memberjoin(vo);
		System.out.println("성공");
		return "login/login";
	}
	@RequestMapping(value = "/radio")
	public ModelAndView radio(int radio) {
		ModelAndView mav = new ModelAndView("member/server/idchkserver");
		String mem_pri_chk=null;
		if(radio==0) {
		mem_pri_chk = "<input type='radio' id='check1' name='mem_pri_chk' value='1'>동의"; 
		mem_pri_chk	+="<input type='radio' id='check2' name='mem_pri_chk' value='0' checked='checked'>비동의";
		}else if(radio==1) {
			mem_pri_chk = "<input type='radio' id='check1' name='mem_pri_chk' value='1' checked='checked'>동의"; 
			mem_pri_chk	+="<input type='radio' id='check2' name='mem_pri_chk' value='0'>비동의";
		}
		mav.addObject("idchk", mem_pri_chk);
		return mav;
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
	
	//로그인 페이지로 이동을함 	
	@RequestMapping(value= "/loginPage")
	public String goLoginPage(HttpSession session, Model m) {
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member != null) { //세션 정보가 존재한다면 home 으로 
			return "index/index";
		}
		
		return "login/login"; //존재하지 않는다면 로그인 페이지로 
	}
	
	//로그인 시 로그인 한 사람의 정보를 세션에 삽입 
    @RequestMapping(value = "/login" ,method = RequestMethod.POST ,produces = "application/json")
	public String loginPage(@ModelAttribute MemberVO user , HttpServletRequest req, Model m,HttpSession session) throws Exception {
		MemberVO memberVO =  memberDao.memLogin(user);
		//UserVO userVO = registerService.selectUser(user);
		session = req.getSession();
		if(memberVO != null) {
			//System.out.println("로그인성공!");
			session.setAttribute("member", memberVO);
			String pageName= ((String) session.getAttribute("pageName"))!=null ? "redirect:"+((String) session.getAttribute("pageName")) : "index/index";
			return pageName;
		}
		//System.out.println("로그인실패!");
		return "login/login";
	}
    
    //로그아웃
    @RequestMapping(value= "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/login";
	}

	
}