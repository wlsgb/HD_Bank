package dank.mvc.model;

import java.util.List;

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
	public ModelAndView myinfoView() {
		System.out.println("infoΩ√¿€");
		List<MemberVO> list = myinfoDao.myinfoList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myinfo/pri_info_chk");
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

	@RequestMapping(value = "/mem_pw_reset")
	public String momo7() {
		return "myinfo/mem_pw_reset";
	}

	@RequestMapping(value = "/tap")
	public String tap() {
		return "myinfo/tap";
	}

	
}
