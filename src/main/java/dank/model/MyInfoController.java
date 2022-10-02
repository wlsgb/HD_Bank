package main.java.dank.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.dank.dao.MemberDao;
import main.java.dank.dao.MyinfoDao;
import main.java.dank.dao.SecurityDao;
import main.java.dank.vo.MemberVO;

@Controller
public class MyInfoController {

	@Autowired
	private MyinfoDao myinfoDao;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private SecurityDao securityDao;

	// ���� ���� ���� ������
	@RequestMapping(value = "/pri_info_chk")
	public String myinfoView(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "pri_info_chk");
			return "login/login";
		}
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		// ��� ���̺� (�н�����, ���� ���� ��)
		MemberVO memberVO = myinfoDao.myinfo(mem_code);
		m.addAttribute("memberVO", memberVO);
		// ����ī��� OTP��û ���θ� �����ش�.
		int scurityCardYN = securityDao.scrNumChk(mem_code);
		int otpYN = securityDao.otpCheck(mem_code);
		m.addAttribute("scurityCardYN", scurityCardYN);
		m.addAttribute("otpYN", otpYN);
		return "myinfo/pri_info_chk";

	}

	// �������� ���� ��
	@RequestMapping(value = "/pri_info_chk2")
	public String momo8(MemberVO vo, HttpSession session, Model m) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "pri_info_chk2");
			return "login/login";
		}
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		// ��� ���̺� (�н�����, ���� ���� ��)
		MemberVO memberVO = myinfoDao.myinfo(mem_code);
		m.addAttribute("memberVO", memberVO);
		// ����ī��� OTP��û ���θ� �����ش�.
		int scurityCardYN = securityDao.scrNumChk(mem_code);
		int otpYN = securityDao.otpCheck(mem_code);
		m.addAttribute("scurityCardYN", scurityCardYN);
		m.addAttribute("otpYN", otpYN);
		return "myinfo/pri_info_chk2";
	}

	// �������� ���� Ȯ�� ��ư�� ������ �۵�
	@RequestMapping(value = "/updatemyinfo")
	public ModelAndView myinfoUpadte2(MemberVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "updatemyinfo");
			mav.setViewName("login/login");
		}
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		vo.setMem_code(mem_code);
		myinfoDao.myinfoUpdate(vo);
		mav.setViewName("redirect:pri_info_chk");
		return mav;
	}

	// ��й�ȣ�� �Է��ϴ� ��
	@RequestMapping(value = "/mem_pw_reset")
	public ModelAndView mypwdUpdate(MemberVO vo, HttpSession session, String pwd,
		@RequestParam(value = "successData", defaultValue = "fail") String successData) {
		ModelAndView mav = new ModelAndView();
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "mem_pw_reset_input");
			mav.setViewName("login/login");
		} else if (memberDao.pwdChk(mem_code).equals(pwd) && successData.equals("success")) {
			MemberVO memberVO = myinfoDao.myinfo(mem_code);
			mav.addObject("memberVO", memberVO);
			mav.setViewName("myinfo/mem_pw_reset");
			session.setAttribute("error", "t");
			session.setAttribute("mem_pw_reset", true);
		} else {
			session.setAttribute("error", "f");
			mav.setViewName("redirect:mem_pw_reset_input");
		}
		return mav;
	}

	// ��й�ȣ�� �Է��ѵ� ��й�ȣ�� ������ ���ְ� �����ϸ� ����
	@RequestMapping(value = "/mem_pw_success")
	public String memPwSuccess(Model m, HttpSession session, String pwd) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "mem_pw_reset_input");
			return "login/login";
		} else if ((boolean)session.getAttribute("mem_pw_reset")) {
			MemberVO vo = new MemberVO();
			vo.setMem_code(((MemberVO)session.getAttribute("member")).getMem_code());
			vo.setMem_pwd(pwd);
			myinfoDao.mypwdUpdate(vo);
			return "myinfo/mem_pw_success";
		} else {
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

	// ��ȣ ���� �ϱ� ���� �̸��� or �н����带 Ȯ���� �޴� ���
	@RequestMapping(value = "/mem_pw_reset_input")
	public String momo5(Model m, HttpSession session) {
		if (session.getAttribute("member") == null) {
			session.setAttribute("pageName", "mem_pw_reset_input");
			return "login/login";
		}
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		MemberVO memberVO = memberDao.numToEmailName(mem_code);
		m.addAttribute("memberVO", memberVO);
		return "myinfo/mem_pw_reset_input";
	}

	/*
	 * @RequestMapping(value = "/mem_pw_reset") public String momo7() { return
	 * "myinfo/mem_pw_reset"; }
	 */

	@RequestMapping(value = "/tap")
	public String tap(HttpSession session) {
		if (session.getAttribute("member") != null) {
			return "index/index";
		} else {
			return "myinfo/tap";
		}

	}

}
