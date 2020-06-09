package dank.mvc.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.dao.MyinfoDao;
import dank.mvc.vo.MemberVO;

@RestController
public class MyinfoRestController {

	@Autowired
	private MyinfoDao midao;
	
	@RequestMapping(value="/getemail")
	public String idChk(MemberVO vo,
			@RequestParam(value="mem_name") String mem_name,
			@RequestParam(value="mem_birth") String mem_birth

			) {
		
			String deco=null;
			try {
				deco = URLDecoder.decode(vo.getMem_name(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setMem_name(deco);
		System.out.println("sss"+vo.getMem_name());

	String email=midao.getemail(vo);
	System.out.println(email);

		return email;
	}
}
