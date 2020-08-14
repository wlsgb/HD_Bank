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
	
	
	 public MemberVO myinfo(int mem_code){ 
		 return ss.selectOne("myinfo.getmyinfo",mem_code);
	 
	 }
	 
	 public int myinfoUpdate(MemberVO vo) {
			return ss.update("myinfo.updatemyinfo", vo);
		}
	
	 public int mypwdUpdate(MemberVO vo) {
			return ss.update("myinfo.updatemypwd", vo);
		}
	 
	 public String getpwd(MemberVO vo) {
		 return ss.selectOne("myinfo.getpwd", vo);
	 }
	
}
