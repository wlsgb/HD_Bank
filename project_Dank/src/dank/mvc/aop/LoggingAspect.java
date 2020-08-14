<<<<<<< HEAD
package dank.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberLogVO;
import dank.mvc.vo.MemberVO;

@Component
@Aspect
public class LoggingAspect {

	@Autowired
	private MemberDao memberDao;
	
	// Login Logger
	@Around("execution(* dank.mvc.model.MemberController.log*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		// ProceedingJoinPoint 를 사용했다면 어라운드를 사용했다.
	    Object[] fd = jp.getArgs();
		ModelAndView rpath=null;
		// 메소드의 이름을 반환
		String methodName = jp.getSignature().getName();
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		// 요청이 왔을 때 AOP가 동작할 때 메소드이름을 분석해서 로그인, 로그아웃일 때 myloginlog 에 대항 로그를 저장하는 공통관심사항
		if(methodName.equals("login")) {
			try {
				MemberLogVO vo = new MemberLogVO();
				// Around Advice일 때 ProceedingJoinPoint 생략 불가
				// 비지니스 로직 (타겟객체가 가지고 있는, 적용해야 할 조인 포인트, 어드바이스를 적용해서 호출 해야 될 메소드를
				// ) 메소드를 직접 호출하는 메소드
				rpath = (ModelAndView) jp.proceed();
				if(fd[0] instanceof HttpSession &&
						fd[1] instanceof HttpServletRequest) {
				HttpSession session = (HttpSession) fd[0];
				HttpServletRequest request = (HttpServletRequest) fd[1];
				int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();	
					if(mem_code <= 0) { // 로그인 했지만 세션의 값이 없을때
					}else {
						vo.setMem_code(mem_code);
						vo.setMl_ip(ip);
						vo.setMl_check("login");
						memberDao.addMemLog(vo);
					}
				
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			//=-----------
		}else if(methodName.equals("logout")) {
			try {
				MemberLogVO vo = new MemberLogVO();
				if(fd[0] instanceof HttpSession 
						&& fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession) fd[0];
					HttpServletRequest request = (HttpServletRequest) fd[1];
					int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();	
						if(mem_code <= 0) { // 로그인 했지만 세션의 값이 없을때	
						}else {
							vo.setMem_code(mem_code);
							vo.setMl_ip(ip);
							vo.setMl_check("logout");
							memberDao.addMemLog(vo);
						}
					
					}
				rpath = (ModelAndView) jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		System.out.println("insert!===================");
		return rpath;
				
	}
}
=======
package dank.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.MemberDao;
import dank.mvc.vo.MemberLogVO;
import dank.mvc.vo.MemberVO;

@Component
@Aspect
public class LoggingAspect {

	@Autowired
	private MemberDao memberDao;
	
	// Login Logger
	@Around("execution(* dank.mvc.model.MemberController.log*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		// ProceedingJoinPoint 를 사용했다면 어라운드를 사용했다.
	    Object[] fd = jp.getArgs();
		ModelAndView rpath=null;
		// 메소드의 이름을 반환
		String methodName = jp.getSignature().getName();
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		// 요청이 왔을 때 AOP가 동작할 때 메소드이름을 분석해서 로그인, 로그아웃일 때 myloginlog 에 대항 로그를 저장하는 공통관심사항
		if(methodName.equals("login")) {
			try {
				MemberLogVO vo = new MemberLogVO();
				// Around Advice일 때 ProceedingJoinPoint 생략 불가
				// 비지니스 로직 (타겟객체가 가지고 있는, 적용해야 할 조인 포인트, 어드바이스를 적용해서 호출 해야 될 메소드를
				// ) 메소드를 직접 호출하는 메소드
				rpath = (ModelAndView) jp.proceed();
				if(fd[0] instanceof HttpSession &&
						fd[1] instanceof HttpServletRequest) {
				HttpSession session = (HttpSession) fd[0];
				HttpServletRequest request = (HttpServletRequest) fd[1];
				int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();	
					if(mem_code <= 0) { // 로그인 했지만 세션의 값이 없을때
					}else {
						vo.setMem_code(mem_code);
						vo.setMl_ip(ip);
						vo.setMl_check("login");
						memberDao.addMemLog(vo);
					}
				
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			//=-----------
		}else if(methodName.equals("logout")) {
			try {
				MemberLogVO vo = new MemberLogVO();
				if(fd[0] instanceof HttpSession 
						&& fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession) fd[0];
					HttpServletRequest request = (HttpServletRequest) fd[1];
					int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();	
						if(mem_code <= 0) { // 로그인 했지만 세션의 값이 없을때	
						}else {
							vo.setMem_code(mem_code);
							vo.setMl_ip(ip);
							vo.setMl_check("logout");
							memberDao.addMemLog(vo);
						}
					
					}
				rpath = (ModelAndView) jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		System.out.println("insert!===================");
		return rpath;
				
	}
}
>>>>>>> refs/remotes/origin/backupmaster
