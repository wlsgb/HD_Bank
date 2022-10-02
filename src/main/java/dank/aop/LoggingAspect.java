package main.java.dank.aop;

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

import main.java.dank.dao.MemberDao;
import main.java.dank.vo.MemberLogVO;
import main.java.dank.vo.MemberVO;

@Component
@Aspect
public class LoggingAspect {

	@Autowired
	private MemberDao memberDao;

	// Login Logger
	@Around("execution(* main.java.dank.model.MemberController.log*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		// ProceedingJoinPoint �� ����ߴٸ� ����带 ����ߴ�.
		Object[] fd = jp.getArgs();
		ModelAndView rpath = null;
		// �޼ҵ��� �̸��� ��ȯ
		String methodName = jp.getSignature().getName();

		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		// ��û�� ���� �� AOP�� ������ �� �޼ҵ��̸��� �м��ؼ� �α���, �α׾ƿ��� �� myloginlog �� ���� �α׸� �����ϴ� ������ɻ���
		if (methodName.equals("login")) {
			try {
				MemberLogVO vo = new MemberLogVO();
				// Around Advice�� �� ProceedingJoinPoint ���� �Ұ�
				// �����Ͻ� ���� (Ÿ�ٰ�ü�� ������ �ִ�, �����ؾ� �� ���� ����Ʈ, �����̽��� �����ؼ� ȣ�� �ؾ� �� �޼ҵ带
				// ) �޼ҵ带 ���� ȣ���ϴ� �޼ҵ�
				rpath = (ModelAndView)jp.proceed();
				if (fd[0] instanceof HttpSession &&
					fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession)fd[0];
					HttpServletRequest request = (HttpServletRequest)fd[1];
					int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
					if (mem_code <= 0) { // �α��� ������ ������ ���� ������
					} else {
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
		} else if (methodName.equals("logout")) {
			try {
				MemberLogVO vo = new MemberLogVO();
				if (fd[0] instanceof HttpSession
					&& fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession)fd[0];
					HttpServletRequest request = (HttpServletRequest)fd[1];
					int mem_code = ((MemberVO)session.getAttribute("member")).getMem_code();
					if (mem_code <= 0) { // �α��� ������ ������ ���� ������
					} else {
						vo.setMem_code(mem_code);
						vo.setMl_ip(ip);
						vo.setMl_check("logout");
						memberDao.addMemLog(vo);
					}

				}
				rpath = (ModelAndView)jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		System.out.println("insert!===================");
		return rpath;

	}
}
