package dank.mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opencsv.CSVReader;

import dank.mvc.vo.PageVO;
import mvc.dto.BoardDto;

@Controller
public class NewsController {
	
	public static List<BoardDto> ReadCsvList(HttpServletRequest request) {
		// 반환용 리스트
		
		List<List<String>> ret = new ArrayList<List<String>>();
		BufferedReader br = null;
		List<BoardDto> dtolist = new ArrayList<BoardDto>();
		try {
			HttpSession session = request.getSession();
		 	String r_path = session.getServletContext().getRealPath("/");
		 	System.out.println(r_path);
			String img_path ="resources\\hd_csv.csv";
			CSVReader reader = new CSVReader(new FileReader(r_path+img_path));
			String[] line;

			while ((line = reader.readNext()) != null) {
				// CSV 1행을 저장하는 리스트
				List<String> tmpList = new ArrayList<String>();
				/*
				 * array[3]=line.substring(line.lastIndexOf(",",
				 * line.lastIndexOf(",")-1)+1,line.length());
				 * array[2]=line.substring(line.lastIndexOf(",",line.lastIndexOf(",",
				 * line.lastIndexOf(",")-1)-1),line.lastIndexOf(",", line.lastIndexOf(",")-1));
				 * array[1]=line.substring(line.indexOf("\"")+1,line.lastIndexOf("\""));
				 * array[0]=line.substring(0,line.indexOf(","));
				 */
				// 배열에서 리스트 반환
				tmpList = Arrays.asList(line);
				ret.add(tmpList);
			}
			for (List<String> list : ret) {
				if (!list.get(0).equals("num")  && !list.get(1).equals("title")  && !list.get(2).equals("link")
						&& !list.get(3).equals("content")) {
					BoardDto dto = new BoardDto();
					dto.setNum(Integer.parseInt(list.get(0)));
					dto.setTitle(list.get(1));
					dto.setLink(list.get(2));
					dto.setContent(list.get(3));
					dtolist.add(dto);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dtolist;
	}

	@RequestMapping(value = "/goNews")
	public String goNews(PageVO vo, Model model,HttpServletRequest request,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") String nowPage,
			@RequestParam(value = "cntPerPage", required = false, defaultValue = "5") String cntPerPage,
			@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "searchValue", required = false) String searchValue) {
		
		
			int total = ReadCsvList(request).size();
		List<BoardDto> list = new ArrayList<BoardDto>();
		if (searchType != null && searchType.equals("1") && searchValue != null) {
			for (int i = 0; i < total; i++) {
				if (ReadCsvList(request).get(i).getTitle().contains(searchValue)) {
					list.add(ReadCsvList(request).get(i));
				}
			}
		} else if (searchType != null && searchType.equals("2") && searchValue != null) {
			for (int i = 0; i < ReadCsvList(request).size(); i++) {
				if (ReadCsvList(request).get(i).getContent().contains(searchValue)) {
					list.add(ReadCsvList(request).get(i));
				}
			}
		} else {
			list = ReadCsvList(request);
		}

		System.out.println(list.get(0).getTitle());
		
		System.out.println("total:" + total);
		vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), vo.getCategori());
		System.out.println("start : " + vo.getStart());
		System.out.println("end : " + vo.getEnd());
		System.out.println("------------------------");
		List<BoardDto> searchedlist = list.subList(vo.getStart()-1, vo.getEnd()-1);
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("타입" + vo.getSearchType());
		System.out.println("벨류" + vo.getSearchValue());
		model.addAttribute("paging", vo);
		model.addAttribute("list", searchedlist);

		return "news/news";
	}
}
