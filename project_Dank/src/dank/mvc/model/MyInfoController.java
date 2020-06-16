package dank.mvc.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.MyinfoDao;
import dank.mvc.vo.MemberVO;

@Controller
public class MyInfoController {

	@Autowired
	private MyinfoDao myinfoDao;
	
	@RequestMapping(value="/pri_info_chk")
	public ModelAndView myinfoView(HttpSession session) {
		System.out.println("infoΩ√¿€");
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		List<MemberVO> list = myinfoDao.myinfoList(mem_code);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo/pri_info_chk");
		System.out.println(list.size());
		mav.addObject("list", list);
		return mav;
		
		
		
	}
	@RequestMapping(value="/pri_info_chk2")
	public ModelAndView momo8(MemberVO vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo/pri_info_chk2");
		return mav;
	}
	@RequestMapping(value="/updatemyinfo")
	public ModelAndView myinfoUpadte2(MemberVO vo,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		vo.setMem_code(mem_code);
		int i = myinfoDao.myinfoUpdate(vo);
		mav.setViewName("redirect:pri_info_chk");
		return mav;
	}
	
	@RequestMapping(value="/mem_pw_reset")
	public ModelAndView mypwdUpdate(MemberVO vo,HttpSession session) {
		int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
		List<MemberVO> list = myinfoDao.myinfoList(mem_code);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo/mem_pw_reset");
		System.out.println(list.size());
		mav.addObject("list", list);
		return mav;
	}
	
	
	
	/*
	 * @RequestMapping(value = "/pri_info_chk") public String momo3() { return
	 * "myinfo/pri_info_chk"; }
	 */
	 

	@RequestMapping(value = "/pri_info_modi")
	public String momo4() {
		return "pri_info_modi";
	}

	@RequestMapping(value = "/mem_pw_reset_input")
	public String momo5() {
		return "myinfo/mem_pw_reset_input";
	}

	@RequestMapping(value = "/mem_pw_chk")
	public String momo6() {
		return "myinfo/mem_pw_chk";
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
