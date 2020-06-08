package dank.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.PageVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value= "/qna1")
	public String indexmm() {
		return "member/qna";
	}
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
			for(MemberVO e : memberDao.getList(vo)) {
				System.out.println(e.getQna_num());
			}
			return "member/qna";
		
	}
	
}