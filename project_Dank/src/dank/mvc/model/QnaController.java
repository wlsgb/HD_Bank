package dank.mvc.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dank.mvc.dao.QnaDao;
import dank.mvc.vo.PageVO;
import dank.mvc.vo.QnaVO;

@Controller
public class QnaController {
	@Autowired
	private QnaDao qnaDao;
	
	@RequestMapping(value="/qna")
	public String listSearch(PageVO vo, Model model,
			@RequestParam(value="nowPage",required = false,
			defaultValue = "1") String nowPage,
			@RequestParam(value="cntPerPage",required = false,
			defaultValue = "10") String cntPerPage) {
			int total=qnaDao.getTotalCount();
			
			vo=new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			model.addAttribute("paging", vo);
			model.addAttribute("list", qnaDao.getList(vo));
			
			System.out.println("listsize"+qnaDao.getList(vo).size());
			
			for(QnaVO e : qnaDao.getList(vo)) {
				System.out.println(e.getQna_num()); 
			}
			
			return "qna/qna";
			
			
			/*
			 * @RequestMapping(value="/membersearchlist") //검색리스트 public String
			 * memberSearchList(Model model,PageVO vo) {
			 * model.addAttribute("list",memberDao.getSearchList(vo)); return
			 * "member/membersearchlist"; }
			 */
		
	}
	
}