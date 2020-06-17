package dank.mvc.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.MemberDao;
import dank.mvc.dao.MyinfoDao;
import dank.mvc.vo.MemberVO;

@Controller
public class MyInfoController {

	@Autowired
	private MyinfoDao myinfoDao;

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = "/pri_info_chk")
	public ModelAndView myinfoView(HttpSession session) {
		System.out.println("info시작");
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		MemberVO memberVO = myinfoDao.myinfo(mem_code);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo/pri_info_chk");
		mav.addObject("memberVO", memberVO);
		return mav;

	}

	@RequestMapping(value = "/pri_info_chk2")
	public ModelAndView momo8(MemberVO vo) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo/pri_info_chk2");
		return mav;
	}

	@RequestMapping(value = "/updatemyinfo")
	public ModelAndView myinfoUpadte2(MemberVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		vo.setMem_code(mem_code);
		int i = myinfoDao.myinfoUpdate(vo);
		mav.setViewName("redirect:pri_info_chk");
		return mav;
	}

	// 비밀번호를 입력하는 폼
	@RequestMapping(value = "/mem_pw_reset")
	public ModelAndView mypwdUpdate(MemberVO vo, HttpSession session, String pwd,
			@RequestParam(value = "successData", defaultValue = "fail") String successData) {
		ModelAndView mav = new ModelAndView();
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "mem_pw_reset_input");
			mav.setViewName("login/login");
		}else if (memberDao.pwdChk(mem_code).equals(pwd) && successData.equals("success")) {
			MemberVO memberVO = myinfoDao.myinfo(mem_code);
			mav.addObject("memberVO", memberVO);
			mav.setViewName("myinfo/mem_pw_reset");
			session.setAttribute("mem_pw_reset", true);
		}else {
			session.setAttribute("error", "f");
			mav.setViewName("redirect:mem_pw_reset_input");
		}
		return mav;
	}

	// 비밀번호를 입력한뒤 비밀번호를 변경을 해주고 성공하면 반응
	@RequestMapping(value = "/mem_pw_success")
	public String memPwSuccess(Model m, HttpSession session, String pwd) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "mem_pw_reset_input");
			return "login/login";
		}else if ((boolean) session.getAttribute("mem_pw_reset")) {
			MemberVO vo = new MemberVO();
			vo.setMem_code(((MemberVO)session.getAttribute("member")).getMem_code());
			vo.setMem_pwd(pwd);
			myinfoDao.mypwdUpdate(vo);
			return "myinfo/mem_pw_success";
		}else {
			session.setAttribute("error", "f");
			return "redirect:mem_pw_reset_input";
		}
	}

	/*
	 * @RequestMapping(value = "/pri_info_chk") public String momo3() { return
	 * "myinfo/pri_info_chk"; }
	 */

	@RequestMapping(value = "/pri_info_modi")
	public String momo4() {
		return "pri_info_modi";
	}

	// 암호 변경 하기 전에 이메일확인을 받는 장소
	@RequestMapping(value = "/mem_pw_reset_input")
	public String momo5(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "mem_pw_reset_input");
			return "login/login";
		}
		int mem_code = ((MemberVO) session.getAttribute("member")).getMem_code();
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		m.addAttribute("memberVO", memberVO);
		return "myinfo/mem_pw_reset_input";
	}

	/*
	 * @RequestMapping(value = "/mem_pw_reset") public String momo7() { return
	 * "myinfo/mem_pw_reset"; }
	 */

	@RequestMapping(value = "/tap")
	public String tap() {
		return "myinfo/tap";
	}

}
