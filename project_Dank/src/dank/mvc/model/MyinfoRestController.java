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
			e.printStackTrace();
		}
		vo.setMem_name(deco);
		System.out.println("입력한 이름 deco : "+deco);
		String email=midao.getemail(vo);
		System.out.println("이메일 : "+email);
		return email;
	}
	@RequestMapping(value = "/getpwd")
	public String pwChk(MemberVO vo,
			@RequestParam(value="mem_name") String mem_name,
			@RequestParam(value="mem_birth") String mem_birth,
			@RequestParam(value = "mem_email") String mem_email
			) {
		
		String deco = null;
		String deco1 = null;
		String deco2 = null;
		
		try {
			deco = URLDecoder.decode(vo.getMem_name(),"UTF-8");
			
//			 deco1= URLDecoder.decode(vo.getMem_birth(),"UTF-8"); 
//			 deco2= URLDecoder.decode(vo.getMem_email(),"UTF-8");
			 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		vo.setMem_name(deco);
//		vo.setMem_birth(deco1);
//		vo.setMem_email(deco2);
		String pwd = midao.getpwd(vo);
		System.out.println(pwd);
		return pwd;
		
	}
	
}
