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

	@RequestMapping(value = "/qna")
	public String listSearch(PageVO vo, Model model,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
			@RequestParam(value = "cntPerPage", required = false, defaultValue = "10") String cntPerPage,
			@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchValue", required = false) String searchValue) {
		
		System.out.println(vo.getSearchType());
		int total = qnaDao.getTotalCount(vo);
		System.out.println("total:"+total);
		vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), vo.getCategori());
		System.out.println("------------------------");
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("타입"+vo.getSearchType());
		System.out.println("벨류"+vo.getSearchValue());
		model.addAttribute("paging", vo);
		model.addAttribute("list", qnaDao.getList(vo));
		
		/* System.out.println("listsize"+qnaDao.getList(vo).size()); */
		return "qna/qna";
	}
}