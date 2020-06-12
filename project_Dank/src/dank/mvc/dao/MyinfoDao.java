package dank.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.vo.MemberVO;

@Repository
public class MyinfoDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public String getemail(MemberVO vo) {
		return ss.selectOne("myinfo.getemail", vo);
	}
	
	
	 public List<MemberVO> myinfoList(){ 
		 return ss.selectList("myinfo.getmyinfo");
	 
	 }
	 
	 public void myinfoUpdate(MemberVO vo) {
		 System.out.println(vo.getMem_name());
		 System.out.println(vo.getMem_loc());
		 System.out.println(vo.getMem_phn());
			ss.update("myinfo.updatemyinfo", vo);
			
		}
	
	
}
