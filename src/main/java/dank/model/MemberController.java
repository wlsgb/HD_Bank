package main.java.dank.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.dank.dao.MemberDao;
import main.java.dank.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberDao memberDao;

	// ȸ������ �� ����
	@RequestMapping(value = "/memberForm")
	public String memberForm(Model m) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		System.out.println("ip����: " + ip);
		m.addAttribute("reip", ip);
		return "member/memberForm";
	}

	// id�ߺ�üũ
	@RequestMapping(value = "/idchk")
	public ModelAndView idchk(String mem_email) {
		System.out.println("33" + mem_email);
		ModelAndView mav = new ModelAndView("member/server/idchkserver");
		int chk = memberDao.idchk(mem_email);
		String idchk = "";

		if (chk > 0) {
			idchk = "<p style='color:red'>�ߺ��� �̸����Դϴ�.</p>";
			idchk += "<input type='hidden' id='chk' value='0'>";

		} else if (mem_email.equals("")) {
			idchk = "<p style='color:red'>�̸����� �Է��� �ּ���.</p>";
			idchk += "<input type='hidden' id='chk' value='0'>";
		} else {
			idchk = "<p style='color:blue'>��밡���� �̸����Դϴ�.</p>";
			idchk += "<input type='hidden' id='chk' value='1'>";
		}
		mav.addObject("idchk", idchk);
		return mav;
	}

	// ȸ������
	@RequestMapping(value = "/memberjoin")
	public String memberjoin(MemberVO vo, String mem_phn1, String mem_phn2, String mem_phn3, HttpSession session,
		@RequestParam(value = "successData", defaultValue = "fail") String successData) {
		if (session.getAttribute("member") != null) {
			session.setAttribute("pageName", "index");
			System.out.println("����");
			return "login/login";
		} else if (successData.equals("fail")) {
			return "member/memberForm";
		}
		System.out.println(vo.getMem_gender());

		vo.setMem_phn(mem_phn1 + "-" + mem_phn2 + "-" + mem_phn3);
		memberDao.memberjoin(vo);
		System.out.println("����");
		return "login/login";
	}

	// ????
	@RequestMapping(value = "/radio")
	public ModelAndView radio(int radio) {
		ModelAndView mav = new ModelAndView("member/server/idchkserver");
		String mem_pri_chk = null;
		if (radio == 0) {
			mem_pri_chk = "<input type='radio' id='check1' name='mem_pri_chk' value='1'>����";
			mem_pri_chk += "<input type='radio' id='check2' name='mem_pri_chk' value='0' checked='checked'>����";
		} else if (radio == 1) {
			mem_pri_chk = "<input type='radio' id='check1' name='mem_pri_chk' value='1' checked='checked'>����";
			mem_pri_chk += "<input type='radio' id='check2' name='mem_pri_chk' value='0'>����";
		}
		mav.addObject("idchk", mem_pri_chk);
		return mav;
	}

	//
	@RequestMapping(value = "/1on1question_prichk")
	public String indexmm2() {
		return "member/1on1question_prichk";
	}

	@RequestMapping(value = "/1on1question")
	public String indexmm4() {
		return "member/1on1question";
	}

	//�α��� �������� �̵����� 	
	@RequestMapping(value = "/loginPage")
	public String goLoginPage(HttpSession session, Model m) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		System.out.println("�α��� �������� �̵��˴ϴ�.");
		if (member != null) { //���� ������ �����Ѵٸ� home ����
			return "index/index";
		}

		return "login/login"; //�������� �ʴ´ٸ� �α��� �������� 
	}

	//	//�α��� �� �α��� �� ����� ������ ���ǿ� ����
	//    @RequestMapping(value = "/login" ,method = RequestMethod.POST ,produces = "application/json")
	//	public String login(HttpSession session, HttpServletRequest req, @ModelAttribute MemberVO user , Model m) throws Exception {
	//		MemberVO memberVO =  memberDao.memLogin(user);
	//		//UserVO userVO = registerService.selectUser(user);
	//		session = req.getSession();
	//		if(memberVO != null) {
	//			//System.out.println("�α��μ���!");
	//			session.setAttribute("member", memberVO);
	//			String pageName= ((String) session.getAttribute("pageName"))!=null ? "redirect:"+((String) session.getAttribute("pageName")) : "index/index";
	//			return pageName;
	//		}
	//		//System.out.println("�α��ν���!");
	//		return "login/login";
	//	}
	//
	//    //�α׾ƿ�
	//    @RequestMapping(value= "/logout")
	//	public String logout(HttpSession session, HttpServletRequest req) {
	//		session.invalidate();
	//		return "login/login";
	//	}

	//�α��� �� �α��� �� ����� ������ ���ǿ� ����
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView login(HttpSession session, HttpServletRequest req, @ModelAttribute MemberVO user) throws
		Exception {
		MemberVO memberVO = memberDao.memLogin(user);
		//UserVO userVO = registerService.selectUser(user);
		session = req.getSession();
		ModelAndView mav = new ModelAndView();
		if (memberVO == null) {
			//System.out.println("�α��ν���!");
			mav.setViewName("login/login");
		} else if (memberVO != null) {
			//System.out.println("�α��μ���!");
			session.setAttribute("member", memberVO);
			String pageName = session.getAttribute("pageName") != null ?
				"redirect:" + session.getAttribute("pageName") : "index/index";
			mav.setViewName(pageName);
		}

		return mav;
	}

	//�α׾ƿ�
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest req) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		return mav;
	}

}