package dank.mvc.model;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> refs/remotes/origin/master
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
=======
>>>>>>> refs/remotes/origin/master
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
=======
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.PageVO;
=======
>>>>>>> refs/remotes/origin/master

@Controller
public class MemberController {
<<<<<<< HEAD
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
=======
	
>>>>>>> refs/remotes/origin/master
	@RequestMapping(value= "/1on1question_prichk")
	public String indexmm2() {
		return "member/1on1question_prichk";
	}
	@RequestMapping(value= "/1on1question")
	public String indexmm4() {
		return "member/1on1question";
	}
		
	
//>>>>>>> refs/heads/javaGenius_v2
}